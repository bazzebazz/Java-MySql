package com.donjavidev.reservations.mapper;

import com.donjavidev.reservations.dto.ReservationDTO;
import com.donjavidev.reservations.model.Reservation;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ReservationDTOMapper extends Converter<ReservationDTO, Reservation> {

    @Override
    Reservation convert(ReservationDTO source);

}