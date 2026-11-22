package ie.atu.sample.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateBookingRequest(
        @NotBlank(message = "name is required") String name,
        @NotNull(message = "roomId is required") Long roomId,
        @NotNull(message = "attendees is required")
        @Min(value = 1, message = "attendees must be at least 1") Integer attendees
) {}
