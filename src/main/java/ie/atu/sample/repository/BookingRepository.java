package ie.atu.sample.repository;

import ie.atu.sample.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    // JPQL: exact room name, biggest bookings first. No matches -> empty list -> JSON []
    @Query("select b from Booking b join fetch b.room r " +
           "where r.name = :roomName order by b.attendees desc")
    List<Booking> searchByRoomName(@Param("roomName") String roomName);

    @Query("select b from Booking b join fetch b.room where b.id = :id")
    java.util.Optional<Booking> findByIdWithRoom(@Param("id") Long id);
}
