package id.ac.ui.cs.advprog.bookingservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import id.ac.ui.cs.advprog.bookingservice.model.Booking;
import id.ac.ui.cs.advprog.bookingservice.model.dto.CreateBookingDTO;
import id.ac.ui.cs.advprog.bookingservice.repository.BookingRepository;
import id.ac.ui.cs.advprog.bookingservice.vo.Asdos;
import id.ac.ui.cs.advprog.bookingservice.vo.BookingApproval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final RestTemplate restTemplate;
    private static final String LIST_ASDOS_URL = "http://ASDOS-SERVICE/asdos/";
    private static final String BOOK_ASDOS_URL = "http://ASDOS-SERVICE/asdos/book";

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, RestTemplate restTemplate) {
        this.bookingRepository = bookingRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking createBooking(CreateBookingDTO bookingRequest) {
        // ToDo
        // send data to asdos-service
        BookingApproval dto = restTemplate.postForEntity(BOOK_ASDOS_URL,bookingRequest, BookingApproval.class).getBody();
        assert dto != null;
        if (dto.getStatus().equals("Failed") ) {
            return null;
        }
        //check if it is valid, if valid, then save the data
        Booking newBooking = new Booking();
        newBooking.setBookerName(bookingRequest.getName());
        newBooking.setBookerClass(bookingRequest.getBookerClass());
        newBooking.setAsdosId(bookingRequest.getAsdosCode());
        newBooking.setBookTime(bookingRequest.getRequestedTime());
        bookingRepository.save(newBooking);
        return newBooking;
    }

    @Override
    public Booking deleteBooking(int id) {
        Booking booking = bookingRepository.findBookingById(id);
        bookingRepository.deleteById(booking.getId());
        return booking;
    }

    @Override
    public List<Asdos> getAllAsdos() {
        // ToDo
        ResponseEntity<Asdos[]> asdoses = restTemplate.getForEntity(LIST_ASDOS_URL,Asdos[].class);
        return Arrays.asList(Objects.requireNonNull(asdoses.getBody()));
    }
}
