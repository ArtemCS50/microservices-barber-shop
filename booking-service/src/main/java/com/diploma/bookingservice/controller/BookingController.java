package com.diploma.bookingservice.controller;

import com.diploma.bookingservice.service.BookingService;
import com.diploma.bookingservice.dto.BookingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingDTO createBooking(@RequestBody BookingDTO bookingDto) {
        return bookingService.createBooking(bookingDto);
    }

    @GetMapping("/{id}")
    public BookingDTO getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @PutMapping("/{id}")
    public BookingDTO updateBooking(@PathVariable Long id, @RequestBody BookingDTO bookingDto) {
        return bookingService.updateBooking(id, bookingDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }
}
