package co.com.linadev.springbootwebflux.controller;

import co.com.linadev.springbootwebflux.model.Player;
import co.com.linadev.springbootwebflux.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping("/fillData")
    public Flux<Player> fillData(){
        return playerService.fillData();
    }

    @DeleteMapping("/clearData")
    public Mono<Void> deleteAll(){
        return playerService.deleteClearData();
    }

    @GetMapping("/club/{club}")
    public Flux<Player> findAllByPlayerClub(@PathVariable String club){
        return playerService.findAllByPlayerClub(club);
    }

    @GetMapping("/name/{name}")
    public Flux<Player> findAllByPlayerNameStartingWith(@PathVariable String name){
        return playerService.findAllByPlayerNameContains(name);
    }


}
