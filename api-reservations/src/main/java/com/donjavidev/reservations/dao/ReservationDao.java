package com.donjavidev.reservations.dao;

import com.donjavidev.reservations.dto.SearchReservationCriteriaDTO;
import com.donjavidev.reservations.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationDao {
    List<Reservation> findAll(SearchReservationCriteriaDTO criteria);

    Optional<Reservation> findById(Long id);

    Reservation save(Reservation reservation);

    void deleteById(Long id);

    boolean existsById(Long id);
}
