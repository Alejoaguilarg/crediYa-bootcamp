package co.com.bancolombia.api.dto.request;

import java.time.LocalDate;

public record CreateUserRequestDTO (
        String name,
        String lastName,
        String email,
        LocalDate birthDate,
        String address,
        String phoneNumber,
        Double baseSalary)
{}
