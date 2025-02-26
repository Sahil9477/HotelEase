package com.example.HotelEase.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.HotelEase.Entities.ReservationService;
import com.example.HotelEase.Repositories.ReservationServiceRepository;

import java.util.List;

@RestController
@RequestMapping("/reservation-services")
public class ReservationServiceController {

    @Autowired
    private ReservationServiceRepository reservationServiceRepository;

    @GetMapping
    public List<ReservationService> getAllReservationServices() {
        return reservationServiceRepository.findAll();
    }

    @PostMapping
    public ReservationService addReservationService(@RequestBody ReservationService reservationService) {
        return reservationServiceRepository.save(reservationService);
    }
}
