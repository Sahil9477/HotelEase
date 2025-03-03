package com.example.HotelEase.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Room")
public class Room {
    @Id
    private Integer roomNumber;
    
    private String roomType;
    private Double roomPrice;
    
    @Column(nullable = false)
    private boolean isAvailable = true; // New field (Default: true)

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(Double roomPrice) {
		this.roomPrice = roomPrice;
	}
	public boolean isAvailable() {
        return isAvailable;
    }

	public void setAvailable(boolean availability) {
		isAvailable = availability;
	}

}
