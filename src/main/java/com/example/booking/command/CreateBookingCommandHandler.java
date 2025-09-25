package com.example.booking.command;

import com.example.booking.domain.Booking;
import com.example.booking.domain.PassengerInfo;
import com.example.booking.domain.Trip;
import com.example.booking.dto.BookingDto;
import com.example.booking.exception.BookingAlreadyExistException;
import com.example.booking.mediator.ICommandHandler;
import com.example.booking.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service("CreateBookingCommandHandler")
public class CreateBookingCommandHandler implements ICommandHandler<CreateBookingCommand, BookingDto> {
    private final BookingRepository repo;

    public CreateBookingCommandHandler(BookingRepository repo) {
        this.repo = repo;
    }

    @Override
    public BookingDto handle(CreateBookingCommand command) {
        if (repo.existsByFlightNumber(command.flightNumber())) {
            throw new BookingAlreadyExistException();
        }

        PassengerInfo passengerInfo = new PassengerInfo(command.passengerName(), command.passengerEmail());
        Trip trip = new Trip(
                command.flightNumber(),
                command.departureAirport(),
                command.arrivalAirport(),
                command.flightDate()
        );

        Booking booking = new Booking(passengerInfo, trip);

        repo.save(booking);

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
}
