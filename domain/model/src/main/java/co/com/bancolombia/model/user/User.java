package co.com.bancolombia.model.user;
import co.com.bancolombia.model.common.Validations;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    private static final int STRING_MIN_LENGTH = 3;
    private static final int STRING_MAX_LENGTH = 50;

    public static final String FIELD_NAME = "Name";
    public static final String FIELD_LAST_NAME = "Last name";
    public static final String FIELD_ADDRESS = "Address";

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private String address;
    private String phoneNumber;
    private Double baseSalary;

    public static User create(String name, String lastName, String email, LocalDate birthDate,
                              String address, String phoneNumber, Double baseSalary) {
        User user = new User(null, name, lastName, email, birthDate, address, phoneNumber, baseSalary);
        user.validate();
        return user;
    }

    public boolean isNew() {
        return id == null;
    }

    public User update(String name, String lastName, String email, LocalDate birthDate,
                       String address, String phoneNumber, Double baseSalary) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.baseSalary = baseSalary;
        validate();
        return this;
    }

    private void validate() {
        Validations.required(name, FIELD_NAME);
        Validations.lengthBetween(name, STRING_MIN_LENGTH, STRING_MAX_LENGTH, FIELD_NAME);

        Validations.required(lastName, FIELD_LAST_NAME);
        Validations.lengthBetween(lastName, STRING_MIN_LENGTH, STRING_MAX_LENGTH, FIELD_LAST_NAME);

        Validations.required(address, FIELD_ADDRESS);
        Validations.lengthBetween(address, STRING_MIN_LENGTH, STRING_MAX_LENGTH, FIELD_ADDRESS);

        Validations.email(email);
        Validations.phoneNumber(phoneNumber);
        Validations.salary(baseSalary);
        Validations.birthDate(birthDate);
    }
}

