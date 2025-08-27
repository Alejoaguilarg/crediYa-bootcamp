package co.com.bancolombia.r2dbc.repositories;

import co.com.bancolombia.model.user.User;
import co.com.bancolombia.r2dbc.entities.UserEntity;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<UserEntity, Long>,
        ReactiveQueryByExampleExecutor<UserEntity> {
    Mono<User> findByEmail(String email);
}
