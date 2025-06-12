package de.telran.ticketapp.service;

import de.telran.ticketapp.entity.LocalUser;
import de.telran.ticketapp.exception.LocalUserNotFoundException;
import de.telran.ticketapp.repository.LocalUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalUserServiceImpl implements LocalUserService {

    @Autowired
    private LocalUserRepository userRepository;

    @Override
    public List<LocalUser> getAll() {
        return userRepository.findAll();
    }

    @Override
    public LocalUser create(LocalUser localUser) {
        return userRepository.save(localUser);
    }

    @Override
    public LocalUser getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new LocalUserNotFoundException("User with id " + id + " not found"));
    }
}
