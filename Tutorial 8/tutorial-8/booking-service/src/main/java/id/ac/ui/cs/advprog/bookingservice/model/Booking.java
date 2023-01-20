package id.ac.ui.cs.advprog.bookingservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "Booking")
@Data
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "booker_name")
    private String bookerName;

    @Column(name = "booker_class")
    private String bookerClass;

    @Column(name = "asdos_id")
    private String asdosId;

    @Column(name = "booking_time")
    private LocalTime bookTime;

    public Booking(String bookerName, String bookerClass, String asdosId, LocalTime bookTime) {
        this.bookerName = bookerName;
        this.bookerClass = bookerClass;
        this.asdosId = asdosId;
        this.bookTime = bookTime;
    }
}
