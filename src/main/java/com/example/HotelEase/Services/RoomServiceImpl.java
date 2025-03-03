package com.example.HotelEase.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HotelEase.Entities.Room;
import com.example.HotelEase.Repositories.RoomRepository;

import java.util.List;
import java.util.Optional;

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
    @Override
    public boolean isRoomAvailable(Integer roomNumber) {
        Optional<Room> roomOpt = roomRepository.findById(roomNumber);
        if (roomOpt.isPresent()) {
            Room room = roomOpt.get();
            return room.isAvailable();
        }
        return false; // If room doesn't exist, return false
    }
    @Override
    public Room updateRoomAvailability(Integer roomNumber, boolean availability) {
        Optional<Room> roomOpt = roomRepository.findById(roomNumber);
        if (roomOpt.isPresent()) {
            Room room = roomOpt.get();
            room.setAvailable(availability);
            return roomRepository.save(room);
        }
        return null;
    }
}

