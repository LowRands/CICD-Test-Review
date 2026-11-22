package ie.atu.sample.dto;

import ie.atu.sample.model.Booking;

public record BookingResponse(
        Long id,
        Long roomId,
        String roomName,
        String name,
        int attendees,
        String status
) {
    public static BookingResponse from(Booking booking) {
        return new BookingResponse(
                booking.getId(),
                booking.getRoom().getId(),
                booking.getRoom().getName(),
                booking.getOrganiserName(),
                booking.getAttendees(),
                booking.getStatus());
    }
}
