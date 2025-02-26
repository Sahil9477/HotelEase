package com.example.HotelEase.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ReservationService")
@IdClass(ReservationServicePK.class)
public class ReservationService {
    @Id
    @ManyToOne
    @JoinColumn(name = "reservationID")
    private Reservation reservation;

    @Id
    @ManyToOne
    @JoinColumn(name = "serviceID")
    private ServiceEntity service;
}
