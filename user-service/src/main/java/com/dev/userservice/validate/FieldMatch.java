package com.dev.userservice.validate;

import jakarta.validation.Payload;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.*;

/**
 * Validation annotation to validate that 2 fields have the same value.
 * An array of fields and their matching confirmation fields can be supplied.
 *
 * Example, compare 1 pair of fields:
 * @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")
 *
 * Example, compare more than 1 pair of fields:
 * @FieldMatch.List({
 *   @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
 *   @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")})
 */

@Target({ElementType.TYPE})
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Validated(value = FieldMatchValidator.class)
public @interface FieldMatch {
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
