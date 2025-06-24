package de.telran.ticketapp.service;

import de.telran.ticketapp.dto.UserResponseDto;
import de.telran.ticketapp.entity.LocalUser;
import de.telran.ticketapp.exception.LocalUserNotFoundException;
import de.telran.ticketapp.exception.NoUniqueLocalUserEmailException;
import de.telran.ticketapp.repository.LocalUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Slf4j
@Service
public class LocalUserServiceImpl implements LocalUserService {

    @Autowired
    private LocalUserRepository userRepository;

    @Override
    public List<LocalUser> getAll() {
        List<LocalUser> all = userRepository.findAll();
        return all;
    }

    @Override
    public LocalUser create(LocalUser localUser) {
        getByEmail(localUser.getEmail())
                .ifPresent(l -> {
                    throw new NoUniqueLocalUserEmailException("User with email " +
                            l.getEmail() + " already exists");
                });
        return userRepository.save(localUser);
    }

    @Override
    public LocalUser getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new LocalUserNotFoundException("User with id " + id + " not found"));
    }

    @Override
    public Optional<LocalUser> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
