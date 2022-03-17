package com.moneymanagerapp.services.impl;

import com.moneymanagerapp.controllers.requests.RegistrationRequest;
import com.moneymanagerapp.domain.Role;
import com.moneymanagerapp.domain.User;
import com.moneymanagerapp.utils.EmailValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final UserServiceImpl userServiceImpl;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException(String.format("email %s not valid", request.getEmail()));
        }
        return userServiceImpl.signUpUser(new User(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword()
        ));
    }
}
