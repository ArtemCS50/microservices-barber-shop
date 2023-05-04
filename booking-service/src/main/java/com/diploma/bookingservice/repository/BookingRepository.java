package com.diploma.bookingservice.repository;


import com.diploma.bookingservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
//    Optional<Booking> findBookingById();
}
