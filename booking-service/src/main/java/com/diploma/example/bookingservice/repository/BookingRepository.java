package com.diploma.example.bookingservice.repository;


import com.diploma.example.bookingservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
//    Optional<Booking> findBookingById();
}
