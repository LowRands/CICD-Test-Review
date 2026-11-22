package ie.atu.sample.service;

import ie.atu.sample.dto.BookingResponse;
import ie.atu.sample.dto.CreateBookingRequest;
import ie.atu.sample.model.Booking;
import ie.atu.sample.model.Room;
import ie.atu.sample.repository.BookingRepository;
import ie.atu.sample.repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;

    public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
    }

    public BookingResponse createBooking(CreateBookingRequest request) {
        Room room = roomRepository.findById(request.roomId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found"));

        if (request.attendees() > room.getCapacity()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Attendees exceed room capacity of " + room.getCapacity());
        }

        Booking booking = new Booking();
        booking.setRoom(room);
        booking.setOrganiserName(request.name());
        booking.setAttendees(request.attendees());
        booking.setStatus("ACTIVE");

        return BookingResponse.from(bookingRepository.save(booking));
    }

    public BookingResponse getById(Long id) {
        return bookingRepository.findByIdWithRoom(id)
                .map(BookingResponse::from)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found"));
    }

    public List<BookingResponse> searchByRoomName(String roomName) {
        return bookingRepository.searchByRoomName(roomName).stream().map(BookingResponse::from).toList();
    }
}
