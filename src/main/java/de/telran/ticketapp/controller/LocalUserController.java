package de.telran.ticketapp.controller;

import de.telran.ticketapp.entity.LocalUser;
import de.telran.ticketapp.service.LocalUserService;
import de.telran.ticketapp.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class LocalUserController {

    @Autowired
    private LocalUserService localUserService;

    @GetMapping
    List<LocalUser> getAll() {
        List<LocalUser> all = localUserService.getAll();
        log.debug("List all  {}", all);
        return all;
    }
}
