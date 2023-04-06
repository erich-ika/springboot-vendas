package io.github.erichika.validation.constraintvalidation;

import io.github.erichika.validation.NotEmpyList;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class NotEmptyListValidator implements ConstraintValidator<NotEmpyList, List<?>> {
    @Override
    public void initialize(NotEmpyList constraintAnnotation) {
    }

    @Override
    public boolean isValid(List list, ConstraintValidatorContext constraintValidatorContext) {
        return list != null && !list.isEmpty();
    }
}
