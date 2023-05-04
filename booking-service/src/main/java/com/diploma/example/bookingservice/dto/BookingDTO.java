package com.diploma.example.bookingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {

    private Long id;
    private Long clientId;
    private Long masterId;
    private Long serviceId;
    private LocalDateTime timeSlot;
    private String status;

    // Constructors, getters, and setters

}
