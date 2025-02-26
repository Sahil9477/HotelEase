package com.example.HotelEase.Services;

import java.util.List;

import com.example.HotelEase.Entities.Reservation;

public interface ReservationService {
    List<Reservation> getAllReservations();
    Reservation getReservationById(Integer id);
    Reservation addReservation(Reservation reservation);
    void deleteReservation(Integer id);
}
