package com.moneymanagerapp.services;

import com.moneymanagerapp.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDto findUserByEmail(String email);
}
