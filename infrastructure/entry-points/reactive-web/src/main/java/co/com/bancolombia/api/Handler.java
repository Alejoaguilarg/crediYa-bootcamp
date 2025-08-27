package co.com.bancolombia.api;

import co.com.bancolombia.api.dto.request.CreateUserRequestDTO;
import co.com.bancolombia.api.dto.response.UserResponseDto;
import co.com.bancolombia.model.user.User;
import co.com.bancolombia.usecase.user.AddUserUseCase;
import co.com.bancolombia.usecase.user.command.CreateUserCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class Handler {

    private final AddUserUseCase addUserUseCase;

    public Mono<ServerResponse> saveUser(final ServerRequest request) {
        return request
                .bodyToMono(CreateUserRequestDTO.class)
                .map(userDto -> new CreateUserCommand(
                        userDto.name(),
                        userDto.lastName(),
                        userDto.email(),
                        userDto.birthDate(),
                        userDto.address(),
                        userDto.phoneNumber(),
                        userDto.baseSalary()
                ))
                .flatMap(addUserUseCase::execute)
                .doOnSuccess(user -> log.info("User created successfully: id={}", user.getId()))
                .doOnError(ex -> log.error("Error creating user: {}", ex.getMessage(), ex))
                .flatMap(savedUser -> ServerResponse
                        .created(URI.create("/api/v1/usuarios/"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(new UserResponseDto(savedUser.getName(),
                                savedUser.getLastName(),
                                savedUser.getEmail(),
                                savedUser.getBirthDate(),
                                savedUser.getAddress(),
                                savedUser.getPhoneNumber(),
                                savedUser.getBaseSalary()))
                        .onErrorResume(ex -> ServerResponse.status(HttpStatus.CONFLICT)
                                .bodyValue(Map.of("Error", ex.getMessage()))
                        )
                );
    }
}
