package co.com.bancolombia.model.common;

import co.com.bancolombia.model.ex.ValidationRuleException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class Validations {

    public static final String FIELD_EMAIL = "Email";

    private static final BigDecimal MIN_SALARY = BigDecimal.ZERO;
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern PHONE_NUMBER_PATTERN =
            Pattern.compile("^(\\+57)?\\d{10}$");
    private static final Double MAX_SALARY = 15000000.00;

    private Validations() {
        throw new IllegalStateException("Utility class");
    }

    public static void required(final String value, final String fieldName) {
        if (value == null || value.isBlank()) {
            throw new ValidationRuleException(
                    String.format("The Field '%s' is required", fieldName)
            );
        }
    }

    public static void lengthBetween(String field, int stringMinLength, int stringMaxLength, String fieldName) {
        required(field, fieldName);
        if (field.length() < stringMinLength || field.length() > stringMaxLength) {
            throw new ValidationRuleException(
                    String.format("The Field '%s' must be between %d and %d characters", fieldName, stringMinLength, stringMaxLength)
            );
        }
    }

    public static void birthDate(final LocalDate birthDate) {
        if (birthDate == null) {
            throw new ValidationRuleException("The birth date can not be empty");
        }

        if (birthDate.isAfter(LocalDate.now())) {
            throw new ValidationRuleException("The birth date can not be a future date");
        }
    }

    public static void email(final String email) {
        Validations.required(email, FIELD_EMAIL);
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new ValidationRuleException("The email is not valid");
        }
    }

    public static void phoneNumber(final String phoneNumber) {
        if(phoneNumber == null || !PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches()){
            throw new ValidationRuleException("The phone number is not valid");
        }
    }

    public static void salary(final Double salary) {
        if (salary == null) {
            throw new ValidationRuleException("The salary cannot be null");
        }

        if (salary.isNaN() || salary.isInfinite()) {
            throw new ValidationRuleException("The salary must be a valid number");
        }

        if (salary < MIN_SALARY.doubleValue() || salary > MAX_SALARY) {
            throw new ValidationRuleException(
                    String.format("The salary must be between %.2f and %.2f",
                            MIN_SALARY.doubleValue(), MAX_SALARY));
        }
    }
}
