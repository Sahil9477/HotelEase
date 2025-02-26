package com.example.HotelEase.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HotelEase.Entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
