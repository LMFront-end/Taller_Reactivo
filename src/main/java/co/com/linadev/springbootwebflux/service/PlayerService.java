package co.com.linadev.springbootwebflux.service;

import co.com.linadev.springbootwebflux.model.Player;
import co.com.linadev.springbootwebflux.repository.PlayerRepository;
import co.com.linadev.springbootwebflux.utils.CsvUtilFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    // delete clear data
    public Mono<Void> deleteClearData(){
        return playerRepository.deleteAll();
    }

    // filtrar por club
    public Flux<Player> findAllByPlayerClub(String club){
        return playerRepository.findAllByPlayerClubOrderByPlayerName(club);
    }

    // filtrar por nombre
    public Flux<Player> findAllByPlayerNameContains(String name){
        return playerRepository.findAllByPlayerNameContainingIgnoreCase(name);
    }

    // filtrar mayores a cualquier edad


    // filtrar por nacionalidad

    // ranking de pais

    // ordenar por nombre


}
