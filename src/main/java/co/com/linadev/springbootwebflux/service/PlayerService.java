package co.com.linadev.springbootwebflux.service;

import co.com.linadev.springbootwebflux.model.Player;
import co.com.linadev.springbootwebflux.repository.PlayerRepository;
import co.com.linadev.springbootwebflux.utils.CsvUtilFile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlayerService {


    private final PlayerRepository playerRepository;

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

    // filtrar (edad) mayores a
    public Flux<Player> findAllByPlayerAgeGreaterThan(Integer age){
        return playerRepository.findAllByPlayerAgeGreaterThan(age);
    }

    // filtrar (edad) menores a
    public Flux<Player> findAllByPlayerAgeLessThan(Integer age){
        return playerRepository.findAllByPlayerAgeLessThan(age);
    }

    // filtrar (edad) igual a
    public Flux<Player> findAllByPlayerAge(Integer age){
        return playerRepository.findAllByPlayerAge(age);
    }

    // filtrar por nacionalidad
    public Flux<Player> findAllByPlayerCountryContainingIgnoreCase(String country){
        return playerRepository.findAllByPlayerCountryContainingIgnoreCase(country);
    }

    // ranking de pais
    public Flux<Player> findAllByPlayerCountryContainingIgnoreCaseOrderByPlayerStatOne(String country){
        return playerRepository.findAllByPlayerCountryContainingIgnoreCaseOrderByPlayerStatOneDesc(country);
    }

}
