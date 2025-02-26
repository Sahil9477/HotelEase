package com.example.HotelEase.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HotelEase.Entities.ServiceEntity;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Integer> {
}
