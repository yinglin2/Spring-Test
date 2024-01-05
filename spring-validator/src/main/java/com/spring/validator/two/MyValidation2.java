package com.spring.validator.two;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;

import java.util.Set;

@Service
public class MyValidation2 {

    @Autowired
    private Validator validator;

    public boolean validateUser(User user) {
        BindException bindException = new BindException(user, user.getName());
        validator.validate(user, bindException);
        return bindException.hasErrors();
    }
}
