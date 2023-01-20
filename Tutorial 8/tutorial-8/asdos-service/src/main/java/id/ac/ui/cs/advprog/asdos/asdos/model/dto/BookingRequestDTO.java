package id.ac.ui.cs.advprog.asdos.asdos.model.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

@Data
public class BookingRequestDTO {
    String asdosCode;
    String name;
    String bookerClass;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    LocalTime requestedTime;
}
