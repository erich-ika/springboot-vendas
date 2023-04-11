package io.github.erichika.validation;

import io.github.erichika.validation.constraintvalidation.NotEmptyListValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = NotEmptyListValidator.class)
public @interface NotEmpyList {
    String message() default "A lista não pode estar vazia";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
