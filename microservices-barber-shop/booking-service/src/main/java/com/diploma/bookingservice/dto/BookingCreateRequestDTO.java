package com.diploma.bookingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingCreateRequestDTO {

    private String clientName;

    private String clientEmail;

    private Long serviceId;

    private Long timeSlotId;

}