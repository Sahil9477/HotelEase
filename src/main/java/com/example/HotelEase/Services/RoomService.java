package com.example.HotelEase.Services;

import java.util.List;

import com.example.HotelEase.Entities.Room;

public interface RoomService {
    List<Room> getAllRooms();
    Room getRoomByNumber(Integer roomNumber);
    Room addRoom(Room room);
    void deleteRoom(Integer roomNumber);
}

