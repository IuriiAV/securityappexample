package de.telran.ticketapp.controller;

import de.telran.ticketapp.security.model.LoginRequest;
import de.telran.ticketapp.security.model.LoginResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class AuthenticationController {

    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest request) {
        return null;
    }
}
