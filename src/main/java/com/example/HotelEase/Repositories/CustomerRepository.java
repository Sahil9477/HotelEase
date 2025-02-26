package com.example.HotelEase.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HotelEase.Entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

