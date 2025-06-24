package de.telran.ticketapp.service;

import de.telran.ticketapp.entity.LocalUser;
import de.telran.ticketapp.exception.LocalUserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class LocalUserDetailsService implements UserDetailsService {

    @Autowired
    private LocalUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LocalUser localUser = userService.getByEmail(username)
                .orElseThrow(() -> new LocalUserNotFoundException("User with email " +
                        username + " not found"));

        return new User(localUser.getEmail(), localUser.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(localUser.getRole().name())));
    }
}