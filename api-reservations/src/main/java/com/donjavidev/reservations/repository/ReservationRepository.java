package com.donjavidev.reservations.repository;


import com.donjavidev.reservations.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository  extends JpaRepository<Reservation, Long> {

}
