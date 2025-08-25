package co.com.bancolombia.usecase.user;

import co.com.bancolombia.model.user.User;
import co.com.bancolombia.model.user.gateways.IUserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AddUserUseCase {

    private final IUserRepository userRepository;

    public Mono<User> execute(final User user) {
        return userRepository.saveUser(user);
    }
}
