package de.telran.ticketapp.converter;

import de.telran.ticketapp.dto.CreateUserRequestDto;
import de.telran.ticketapp.dto.UserResponseDto;
import de.telran.ticketapp.entity.LocalUser;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<LocalUser, CreateUserRequestDto,
        UserResponseDto> {

    @Override
    public LocalUser toEntity(CreateUserRequestDto createUserRequestDto) {
        return new LocalUser(createUserRequestDto.name(),
                createUserRequestDto.surname(),
                createUserRequestDto.email(),
                createUserRequestDto.password());
    }

    @Override
    public UserResponseDto toDto(LocalUser localUser) {
        return new UserResponseDto(localUser.getId(), localUser.getName(),
                localUser.getSurname());
    }
}
