package com.donjavidev.reservations.service;

import com.donjavidev.reservations.dto.SearchReservationCriteriaDTO;
import com.donjavidev.reservations.enums.APIError;
import com.donjavidev.reservations.dto.ReservationDTO;
import com.donjavidev.reservations.exception.ReservationException;
import com.donjavidev.reservations.model.Reservation;
import com.donjavidev.reservations.repository.ReservationRepository;
import com.donjavidev.reservations.specification.ReservationSpecification;
import jakarta.validation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
public class ReservationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationService.class);

    private final ReservationRepository repository;

    private final ConversionService conversionService;

    @Autowired
    public ReservationService(ReservationRepository repository, ConversionService conversionService) {
        this.repository = repository;
        this.conversionService = conversionService;
    }

    public List<ReservationDTO> getReservations(SearchReservationCriteriaDTO criteria) {
        return conversionService.convert(repository.findAll(ReservationSpecification.withSearchCriteria(criteria)), List.class);
    }

    public ReservationDTO getReservationById(Long id) {
        Optional<Reservation> result = repository.findById(id);
        if (result.isEmpty()) {
            LOGGER.debug("Not exist reservation with the id {}", id);
            throw new ReservationException(APIError.RESERVATION_NOT_FOUND);
        }
        return conversionService.convert(result.get(), ReservationDTO.class);
    }

    public ReservationDTO save(ReservationDTO reservation) {
        if (Objects.nonNull(reservation.getId())) {
            throw new ReservationException(APIError.RESERVATION_WITH_SAME_ID);
        }
        Reservation transformed = conversionService.convert(reservation, Reservation.class);
        validateEntity(transformed);
        Reservation result = repository.save(Objects.requireNonNull(transformed));
        return conversionService.convert(result, ReservationDTO.class);
    }

    public ReservationDTO update(Long id, ReservationDTO reservation) {
        if (!repository.existsById(id)) {
            LOGGER.debug("Not exist reservation with the id {}", id);
            throw new ReservationException(APIError.RESERVATION_NOT_FOUND);
        }
        Reservation transformed = conversionService.convert(reservation, Reservation.class);

        validateEntity(transformed);

        Reservation result = repository.save(Objects.requireNonNull(transformed));
        return conversionService.convert(result, ReservationDTO.class);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            LOGGER.debug("Not exist reservation with the id {}", id);
            throw new ReservationException(APIError.RESERVATION_NOT_FOUND);
        }

        repository.deleteById(id);
    }

    private void validateEntity(Reservation transformed) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Reservation>> violations = validator.validate(transformed);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
