package com.srdevpereira.springbootmongodb.config;

import com.srdevpereira.springbootmongodb.domain.User;
import com.srdevpereira.springbootmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User u1 = new User(null, "Maria Silva", "maria@gmail.com");
        User u2 = new User(null, "Alex Monteiro", "alex@gmail.com");
        User u3 = new User(null, "Saulo Pereira", "saulo@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
    }
}
