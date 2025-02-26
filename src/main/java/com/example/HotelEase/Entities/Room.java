package com.example.HotelEase.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Room")
public class Room {
    @Id
    private Integer roomNumber;
    
    private String roomType;
    private Double roomPrice;
}
