package com.example.booking.repository;

import com.example.booking.dto.BookingDto;
import com.example.booking.domain.Booking;

import java.util.*;
import java.util.stream.Collectors;

public class BookingReadRepository {
    private final BookingRepository bookingRepository;

    public BookingReadRepository(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public BookingDto findById(String id) {
        Booking booking = bookingRepository.findById(id);
        if (booking == null) return null;

        return new BookingDto(
                booking.getId(),
                booking.getPassengerInfo().name(),
                booking.getPassengerInfo().email(),
                booking.getTrip().flightNumber(),
                booking.getTrip().departureAirport(),
                booking.getTrip().arrivalAirport(),
                booking.getTrip().flightDate()
        );
    }

    public List<BookingDto> findAll() {
        return bookingRepository.findAll().stream()
                .map(b -> new BookingDto(
                        b.getId(),
                        b.getPassengerInfo().name(),
                        b.getPassengerInfo().email(),
                        b.getTrip().flightNumber(),
                        b.getTrip().departureAirport(),
                        b.getTrip().arrivalAirport(),
                        b.getTrip().flightDate()
                ))
                .collect(Collectors.toList());
    }
}