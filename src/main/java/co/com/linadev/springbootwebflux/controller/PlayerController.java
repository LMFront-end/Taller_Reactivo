package co.com.linadev.springbootwebflux.controller;

import co.com.linadev.springbootwebflux.model.Player;
import co.com.linadev.springbootwebflux.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping("/fillData")
    public Flux<Player> fillDate(){
        return playerService.fillData();
    }

}
