package co.com.linadev.springbootwebflux.repository;

import co.com.linadev.springbootwebflux.model.Player;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends ReactiveMongoRepository<Player, String> {
}
