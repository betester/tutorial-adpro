package id.ac.ui.cs.advprog.bookingservice.model.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

@Data
public class CreateBookingDTO {
    String asdosCode;
    String name;
    String bookerClass;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    LocalTime requestedTime;
}
