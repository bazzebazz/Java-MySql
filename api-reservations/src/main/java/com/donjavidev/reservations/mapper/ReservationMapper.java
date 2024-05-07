package com.donjavidev.reservations.mapper;

import com.donjavidev.reservations.dto.ReservationDTO;
import com.donjavidev.reservations.model.Reservation;
import org.springframework.core.convert.converter.Converter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationMapper extends Converter<Reservation, ReservationDTO> {

    @Override
    ReservationDTO convert(Reservation source);

}