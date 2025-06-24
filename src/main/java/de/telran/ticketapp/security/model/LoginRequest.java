package de.telran.ticketapp.security.model;

public record LoginRequest(String email,
                           String password) {
}
