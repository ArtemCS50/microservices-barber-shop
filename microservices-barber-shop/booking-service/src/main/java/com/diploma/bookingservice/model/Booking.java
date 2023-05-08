package com.diploma.bookingservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "booking_id")
    private Long id;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "master_id")
    private Long masterId;

    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "time_slot")
    private LocalDateTime timeSlot;

    @Column(name = "status")
    private String status;

    // Constructors, getters, and setters

}

