package co.com.bancolombia.config;

import co.com.bancolombia.r2dbc.adapters.UserRepositoryAdapter;
import co.com.bancolombia.usecase.user.AddUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
public class UseCasesConfig {

    @Bean
    public AddUserUseCase addUserUseCase(final UserRepositoryAdapter userRepositoryAdapter) {
        return new AddUserUseCase(userRepositoryAdapter);
    }
}
