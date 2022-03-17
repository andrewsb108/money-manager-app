package com.moneymanagerapp;

import com.moneymanagerapp.domain.Role;
import com.moneymanagerapp.domain.User;
import com.moneymanagerapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@SpringBootApplication
public class MoneyManagerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoneyManagerAppApplication.class, args);
    }

//    @Component
//    class MyRunner implements CommandLineRunner {
//
//
//        @Autowired
//        private UserRepository userRepository;
//
//        @Autowired
//        BCryptPasswordEncoder encoder;
//
//
//        @Override
//        public void run(String... args) throws Exception {
//            var customer = User.builder()
//                    .firstName("Jon")
//                    .lastName("Jonson")
//                    .email("customer@gmail.com")
//                    .password(encoder.encode("1234"))
//                    .roles(Set.of(new Role()))
//                    .enabled(true)
//                    .build();
//
//            userRepository.save(customer);
//        }
//    }
}

