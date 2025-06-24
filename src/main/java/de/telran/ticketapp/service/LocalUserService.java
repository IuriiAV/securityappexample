package de.telran.ticketapp.service;

import de.telran.ticketapp.entity.LocalUser;

import java.util.List;
import java.util.Optional;

public interface LocalUserService {

    List<LocalUser> getAll();

    LocalUser create(LocalUser localUser);

    LocalUser getById(Long id);

    Optional<LocalUser> getByEmail(String email);

}
