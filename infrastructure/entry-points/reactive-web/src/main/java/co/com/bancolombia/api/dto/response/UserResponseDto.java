package co.com.bancolombia.api.dto.response;

import java.time.LocalDate;

public record UserResponseDto(String name,
                              String lastName,
                              String email,
                              LocalDate birthDate,
                              String address,
                              String phoneNumber,
                              Double baseSalary) {
}
