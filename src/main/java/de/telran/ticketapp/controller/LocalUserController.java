package de.telran.ticketapp.controller;

import de.telran.ticketapp.converter.Converter;
import de.telran.ticketapp.dto.CreateUserRequestDto;
import de.telran.ticketapp.dto.UserResponseDto;
import de.telran.ticketapp.entity.LocalUser;
import de.telran.ticketapp.service.LocalUserService;
import de.telran.ticketapp.service.TicketService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {"title " : "Regular" }
 * Ticket -> title -> Ticket.getTitle()
 * <p>
 * {"title " : "Regular" }  -> Ticket ticket
 * <p>
 * ticket = new Ticket() ; ticket.setTitle("Regular")
 */

@RestController
@RequestMapping("/users")
@Slf4j
public class LocalUserController {

    @Autowired
    private LocalUserService localUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Converter<LocalUser, CreateUserRequestDto, UserResponseDto> converter;

    @GetMapping
    List<LocalUser> getAll() {
        List<LocalUser> all = localUserService.getAll();
        log.debug("List all  {}", all);
        return all;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UserResponseDto create(@RequestBody @Valid CreateUserRequestDto userRequestDto) {
        LocalUser entity = converter.toEntity(userRequestDto);
        entity.setPassword(passwordEncoder.encode(userRequestDto.password()));
        LocalUser localUser = localUserService.create(entity);
        UserResponseDto dto = converter.toDto(localUser);
        return dto;

//        return converter.toDto(
//                localUserService.create(
//                        converter.toEntity(userRequestDto)));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, ?>> handleConstraintViolationException(MethodArgumentNotValidException exception) {
        Map<String, ?> errors = exception.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(fieldError -> fieldError.getField(),
                        fieldError -> fieldError.getDefaultMessage() != null ?
                                fieldError.getDefaultMessage() : "Invalid data"));


        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
