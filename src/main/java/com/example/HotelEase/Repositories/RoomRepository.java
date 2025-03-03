package com.example.HotelEase.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HotelEase.Entities.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
	 List<Room> findByIsAvailableTrue(); // Fetch only available rooms
}
