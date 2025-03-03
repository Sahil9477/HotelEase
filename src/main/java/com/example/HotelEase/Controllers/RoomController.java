package com.example.HotelEase.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.HotelEase.Entities.Room;
import com.example.HotelEase.Services.RoomService;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{roomNumber}")
    public Room getRoomByNumber(@PathVariable Integer roomNumber) {
        return roomService.getRoomByNumber(roomNumber);
    }

    @PostMapping
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @DeleteMapping("/{roomNumber}")
    public void deleteRoom(@PathVariable Integer roomNumber) {
        roomService.deleteRoom(roomNumber);
    }
    @PutMapping("/{roomNumber}/availability/{status}")
    public Room updateRoomAvailability(@PathVariable Integer roomNumber, @PathVariable boolean status) {
        return roomService.updateRoomAvailability(roomNumber, status);
    }
    @GetMapping("/{roomNumber}/availability")
    public boolean checkRoomAvailability(@PathVariable Integer roomNumber) {
        return roomService.isRoomAvailable(roomNumber);
    }

}
