package co.com.linadev.springbootwebflux.service;

import co.com.linadev.springbootwebflux.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    // fill data

}
