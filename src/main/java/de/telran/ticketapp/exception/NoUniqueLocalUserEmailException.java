package de.telran.ticketapp.exception;

public class NoUniqueLocalUserEmailException extends RuntimeException{

    public NoUniqueLocalUserEmailException(String message) {
        super(message);
    }
}
