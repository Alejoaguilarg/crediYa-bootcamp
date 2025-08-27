package co.com.bancolombia.usecase.user.command;

import java.time.LocalDate;

public record AddUserCommand(
        String name,
        String lastName,
        String email,
        LocalDate birthDate,
        String address,
        String phoneNumber,
        Double baseSalary
) {}
