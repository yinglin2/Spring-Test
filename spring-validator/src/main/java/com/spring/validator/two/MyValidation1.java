package com.spring.validator.two;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MyValidation1 {
    @Autowired
    private Validator validator;

    public boolean validateUser(User user) {
        Set<ConstraintViolation<User>> validatorSet = validator.validate(user);
        return validatorSet.isEmpty();
    }

}
