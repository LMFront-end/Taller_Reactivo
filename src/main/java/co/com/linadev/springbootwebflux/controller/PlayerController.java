package co.com.linadev.springbootwebflux.controller;

import co.com.linadev.springbootwebflux.model.Player;
import co.com.linadev.springbootwebflux.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/player")
public class PlayerController {


    private final PlayerService playerService;

    //localhost:8080/api/player/fillData
    @PostMapping("/fillData")
    public Flux<Player> fillData(){
        return playerService.fillData();
    }

    //localhost:8080/api/player/clearData"
    @DeleteMapping("/clearData")
    public Mono<Void> deleteAll(){
        return playerService.deleteClearData();
    }

    //localhost:8080/api/player/club/{club}
    @GetMapping("/club/{club}")
    public Flux<Player> findAllByPlayerClub(@PathVariable String club){
        return playerService.findAllByPlayerClub(club);
    }

    //localhost:8080/api/player/name/{name}
    @GetMapping("/name/{name}")
    public Flux<Player> findAllByPlayerNameStartingWith(@PathVariable String name){
        return playerService.findAllByPlayerNameContains(name);
    }

    //localhost:8080/api/player/ageGreater/{age}
    @GetMapping("/ageGreater/{age}")
    public Flux<Player> findAllByPlayerAgeGreaterThan(@PathVariable Integer age){
        return playerService.findAllByPlayerAgeGreaterThan(age);
    }

    //localhost:8080/api/player/ageLess/{age}
    @GetMapping("/ageLess/{age}")
    public Flux<Player> findAllByPlayerAgeLessThan(@PathVariable Integer age){
        return playerService.findAllByPlayerAgeLessThan(age);
    }

    //localhost:8080/api/player/age/{age}
    @GetMapping("/age/{age}")
    public Flux<Player> findAllByPlayerAge(@PathVariable Integer age){
        return playerService.findAllByPlayerAge(age);
    }

    //localhost:8080/api/player/country/{country}
    @GetMapping("/country/{country}")
    public Flux<Player> findAllByPlayerCountryContainingIgnoreCase(@PathVariable String country){
        return playerService.findAllByPlayerCountryContainingIgnoreCase(country);
    }

    //localhost:8080/api/player/countryStatOne/{country}
    @GetMapping("/countryStatOne/{country}")
    public Flux<Player> findAllByPlayerCountryContainingIgnoreCaseOrderByPlayerStatOne(@PathVariable String country){
        return playerService.findAllByPlayerCountryContainingIgnoreCaseOrderByPlayerStatOne(country);
    }


}
