package com.example.booking.query;

import com.example.booking.dto.BookingDto;
import com.example.booking.mediator.ICommandHandler;
import com.example.booking.repository.BookingReadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GetAllBookingsQueryHandler")
public class GetAllBookingsQueryHandler implements ICommandHandler<GetAllBookingsQuery, List<BookingDto>> {
    private final BookingReadRepository repo;

    public GetAllBookingsQueryHandler(BookingReadRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<BookingDto> handle(GetAllBookingsQuery query) {
        return repo.findAll();
    }
}
