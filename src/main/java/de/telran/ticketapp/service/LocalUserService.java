package de.telran.ticketapp.service;

import de.telran.ticketapp.entity.LocalUser;

import java.util.List;

public interface LocalUserService {

    List<LocalUser> getAll();

    LocalUser create(LocalUser localUser);

    LocalUser getById(Long id);

}
