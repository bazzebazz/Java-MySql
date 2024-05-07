package com.donjavidev.reservations.listener;

import com.donjavidev.reservations.model.Reservation;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class ReservationEntityListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationEntityListener.class);

    @PrePersist
    public void prePersist(Reservation reservation) {
        reservation.setCreationDate(LocalDate.now());
    }

    @PostPersist
    public void postPersist(Reservation reservation) {
        LOGGER.info("postPersist with this reservation {}", reservation);
    }

    @PostRemove
    public void onPostRemove(Reservation reservation) {
        LOGGER.info("onPostRemove with this reservation {}", reservation);
    }

    @PostLoad
    public void onPostLoad(Reservation reservation) {
        LOGGER.info("onPostLoadData with this reservation {}", reservation);
    }
}
