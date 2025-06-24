package de.telran.ticketapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

//constructor + getters (getName() - name(), surname(), email(), password())
public record CreateUserRequestDto(String name,
                                   String surname,
                                   @NotNull String email,
                                   String password) {
}
