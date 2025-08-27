package co.com.bancolombia.usecase.user;

import co.com.bancolombia.model.ex.BusinessRuleException;
import co.com.bancolombia.model.user.User;
import co.com.bancolombia.model.user.gateways.IUserRepository;
import co.com.bancolombia.usecase.user.command.CreateUserCommand;
import reactor.core.publisher.Mono;

public class AddUserUseCase {

    private final IUserRepository userRepository;

    public AddUserUseCase(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> execute(final CreateUserCommand command) {
        return userRepository.findByEmail(command.email())
                .flatMap(existingUser ->
                        Mono.<User>error(new BusinessRuleException("409", "Email is already registered.")))
                .switchIfEmpty(userRepository.saveUser(User.create(command.name(),
                                    command.lastName(),
                                    command.email(),
                                    command.birthDate(),
                                    command.address(),
                                    command.phoneNumber(),
                                    command.baseSalary())))
                .onErrorMap(ex -> ex instanceof BusinessRuleException ? ex :
                        new BusinessRuleException("500", "Error saving user"));
    }
}
