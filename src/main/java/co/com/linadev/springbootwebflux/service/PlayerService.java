package co.com.linadev.springbootwebflux.service;

import co.com.linadev.springbootwebflux.model.Player;
import co.com.linadev.springbootwebflux.repository.PlayerRepository;
import co.com.linadev.springbootwebflux.utils.CsvUtilFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    // fill data
    public Flux<Player> fillData(){
        List<Player> playerList = CsvUtilFile.getPlayers();
        return playerRepository.saveAll(playerList);
    }
}
