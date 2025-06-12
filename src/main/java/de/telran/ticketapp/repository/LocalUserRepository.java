package de.telran.ticketapp.repository;

import de.telran.ticketapp.entity.LocalUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalUserRepository extends JpaRepository<LocalUser, Long> {
}
