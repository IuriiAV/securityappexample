package de.telran.ticketapp.exception;

public class LocalUserNotFoundException extends RuntimeException {

    public LocalUserNotFoundException(String message) {
        super(message);
    }
}
