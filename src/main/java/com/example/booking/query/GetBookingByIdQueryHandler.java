package com.example.booking.query;

import com.example.booking.dto.BookingDto;
import com.example.booking.mediator.ICommandHandler;
import com.example.booking.repository.BookingReadRepository;
import org.springframework.stereotype.Service;

@Service("GetBookingByIdQueryHandler")
public class GetBookingByIdQueryHandler implements ICommandHandler<GetBookingByIdQuery, BookingDto> {
    private final BookingReadRepository repo;

    public GetBookingByIdQueryHandler(BookingReadRepository repo) {
        this.repo = repo;
    }

    @Override
    public BookingDto handle(GetBookingByIdQuery query) {
        return repo.findById(query.bookingId());
    }
}
