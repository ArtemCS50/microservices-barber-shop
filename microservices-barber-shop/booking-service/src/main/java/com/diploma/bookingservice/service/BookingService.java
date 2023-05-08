package com.diploma.bookingservice.service;


import com.diploma.bookingservice.dto.BookingDTO;
import com.diploma.bookingservice.exception.BookingNotFoundException;
import com.diploma.bookingservice.model.Booking;
import com.diploma.bookingservice.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookingService {

    private final BookingRepository bookingRepository;
//    private final WebClient webClient;

    public BookingDTO createBooking(BookingDTO bookingDto) {
        Booking booking = convertToEntity(bookingDto);
        Booking savedBooking = bookingRepository.save(booking);
        return convertToDto(savedBooking);
    }

    public BookingDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
              .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + id));
        return convertToDto(booking);
    }

    public BookingDTO updateBooking(Long id, BookingDTO bookingDto) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + id));

        // Update the booking with the new data
        booking.setClientId(bookingDto.getClientId());
        booking.setMasterId(bookingDto.getMasterId());
        booking.setServiceId(bookingDto.getServiceId());
        booking.setTimeSlot(bookingDto.getTimeSlot());
        booking.setStatus(bookingDto.getStatus());

        Booking updatedBooking = bookingRepository.save(booking);
        return convertToDto(updatedBooking);
    }

    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + id));

        bookingRepository.delete(booking);
    }

    // Additional methods

    private Booking convertToEntity(BookingDTO bookingDto) {
        Booking booking = new Booking();
        booking.setClientId(bookingDto.getClientId());
        booking.setMasterId(bookingDto.getMasterId());
        booking.setServiceId(bookingDto.getServiceId());
        booking.setTimeSlot(bookingDto.getTimeSlot());
        booking.setStatus(bookingDto.getStatus());
        return booking;
    }

    private BookingDTO convertToDto(Booking booking) {
        BookingDTO bookingDto = new BookingDTO();
        bookingDto.setId(booking.getId());
        bookingDto.setClientId(booking.getClientId());
        bookingDto.setMasterId(booking.getMasterId());
        bookingDto.setServiceId(booking.getServiceId());
        bookingDto.setTimeSlot(booking.getTimeSlot());
        bookingDto.setStatus(booking.getStatus());
        return bookingDto;
    }
}
