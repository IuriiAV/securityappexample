package de.telran.ticketapp.converter;

public interface Converter<Entity, RequestDto, ResponseDto> {

    Entity toEntity(RequestDto dto);

    ResponseDto toDto(Entity entity);
}
