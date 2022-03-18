package co.com.linadev.springbootwebflux.repository;

import co.com.linadev.springbootwebflux.model.Player;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public interface PlayerRepository extends ReactiveMongoRepository<Player, String> {

    Flux<Player> saveAll(List<Player> playerList);
    Mono<Void> deleteAll();
    Flux<Player> findAllByPlayerClubOrderByPlayerName(String club);
}
