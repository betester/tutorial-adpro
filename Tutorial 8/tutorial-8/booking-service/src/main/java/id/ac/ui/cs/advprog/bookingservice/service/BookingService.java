package id.ac.ui.cs.advprog.bookingservice.service;

import id.ac.ui.cs.advprog.bookingservice.model.Booking;
import id.ac.ui.cs.advprog.bookingservice.model.dto.CreateBookingDTO;
import id.ac.ui.cs.advprog.bookingservice.vo.Asdos;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBooking();
    Booking createBooking(CreateBookingDTO bookingRequest);
    Booking deleteBooking(int id);
    List<Asdos> getAllAsdos();
}
