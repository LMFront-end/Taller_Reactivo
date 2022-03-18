package co.com.linadev.springbootwebflux.service;

import co.com.linadev.springbootwebflux.model.Player;
import co.com.linadev.springbootwebflux.repository.PlayerRepository;
import co.com.linadev.springbootwebflux.utils.CsvUtilFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class PlayerServiceTest {

    PlayerRepository repository;
    PlayerService playerService;

    @BeforeEach
    public void setup(){
        repository = Mockito.mock(PlayerRepository.class);
        playerService = new PlayerService(repository);
    }

    @Test
    void fillData() {
        List<Player> list = CsvUtilFile.getPlayers();
        Mockito.when(repository.saveAll(list)).thenReturn(Flux.fromIterable(list));
        StepVerifier.create(playerService.fillData()).expectNextCount(list.size()).verifyComplete();
    }

    @Test
    void deleteClearData() {
    }

    @Test
    void findAllByPlayerClub() {
    }

    @Test
    void findAllByPlayerNameContains() {
    }

    @Test
    void findAllByPlayerAgeGreaterThan() {
    }

    @Test
    void findAllByPlayerAgeLessThan() {
    }

    @Test
    void findAllByPlayerAge() {
    }

    @Test
    void findAllByPlayerCountryContainingIgnoreCase() {
    }

    @Test
    void findAllByPlayerCountryContainingIgnoreCaseOrderByPlayerStatOne() {
    }
}