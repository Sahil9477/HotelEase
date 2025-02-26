package com.example.HotelEase.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerID;
    
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
}

