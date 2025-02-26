package com.example.HotelEase.Entities;

import java.io.Serializable;
import java.util.Objects;

public class ReservationServicePK implements Serializable {
    private Integer reservation;
    private Integer service;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationServicePK that = (ReservationServicePK) o;
        return Objects.equals(reservation, that.reservation) &&
               Objects.equals(service, that.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservation, service);
    }
}
