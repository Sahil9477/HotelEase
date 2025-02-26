package com.example.HotelEase.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HotelEase.Entities.Room;
import com.example.HotelEase.Repositories.RoomRepository;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomByNumber(Integer roomNumber) {
        return roomRepository.findById(roomNumber).orElse(null);
    }

    @Override
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Integer roomNumber) {
        roomRepository.deleteById(roomNumber);
    }
}

