package co.com.bancolombia.r2dbc.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("usr")
public class UserEntity {

    @Id
    private Long id;
    @Column("name")
    private String name;
    @Column("last_name")
    private String lastName;
    @Column("email")
    private String email;
    @Column("birth_date")
    private LocalDate birthDate;
    @Column("address")
    private String address;
    @Column("phone_number")
    private String phoneNumber;
    @Column("base_salary")
    private Double baseSalary;
}
