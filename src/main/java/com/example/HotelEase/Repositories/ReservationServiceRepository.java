package com.example.HotelEase.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HotelEase.Entities.ReservationService;
import com.example.HotelEase.Entities.ReservationServicePK;

public interface ReservationServiceRepository extends JpaRepository<ReservationService, ReservationServicePK> {
}
