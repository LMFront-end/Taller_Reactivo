package co.com.linadev.springbootwebflux.service;

import co.com.linadev.springbootwebflux.model.Player;
import co.com.linadev.springbootwebflux.repository.PlayerRepository;
import co.com.linadev.springbootwebflux.utils.CsvUtilFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;
import java.util.stream.Collectors;

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
        Mockito.when(repository.deleteAll()).thenReturn(Mono.empty());
        StepVerifier.create(playerService.deleteClearData()).expectNextCount(0).verifyComplete();
    }

    @Test
    void findAllByPlayerClub() {
        String testClub = "Juventus";
        List<Player> list = CsvUtilFile.getPlayers();
        List<Player> filtrado = list.stream().filter(x -> x.getPlayerClub().equals(testClub))
                .sorted((x,y) -> x.getPlayerName().compareTo(y.getPlayerName()))
                .collect(Collectors.toList());
        Mockito.when(repository.findAllByPlayerClubOrderByPlayerName(testClub)).thenReturn(Flux.fromIterable(filtrado));
        StepVerifier.create(playerService.findAllByPlayerClub(testClub)).expectNextCount(25).verifyComplete();
    }

    @Test
    void findAllByPlayerNameContains() {
        List<Player> list = CsvUtilFile.getPlayers();
    }

    @Test
    void findAllByPlayerAgeGreaterThan() {
        List<Player> list = CsvUtilFile.getPlayers();
    }

    @Test
    void findAllByPlayerAgeLessThan() {
        List<Player> list = CsvUtilFile.getPlayers();
    }

    @Test
    void findAllByPlayerAge() {
        List<Player> list = CsvUtilFile.getPlayers();
    }

    @Test
    void findAllByPlayerCountryContainingIgnoreCase() {
        List<Player> list = CsvUtilFile.getPlayers();
    }

    @Test
    void findAllByPlayerCountryContainingIgnoreCaseOrderByPlayerStatOne() {
        List<Player> list = CsvUtilFile.getPlayers();
    }
}