package id.ac.ui.cs.advprog.bookingservice.controller;

import id.ac.ui.cs.advprog.bookingservice.model.Booking;
import id.ac.ui.cs.advprog.bookingservice.model.dto.CreateBookingDTO;
import id.ac.ui.cs.advprog.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/book")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping({"","/"})
    public String homepage(Model model) {
        model.addAttribute("asdoss", bookingService.getAllAsdos());
        return "homepage";
    }

    @GetMapping("/mybook")
    public String mybook(Model model) {
        model.addAttribute("bookings", bookingService.getAllBooking());
        return "mybook";
    }

    @GetMapping("/request-booking")
    public String requestBooking (Model model){
        model.addAttribute("createBookingDTO", new CreateBookingDTO());
        model.addAttribute("asdoss", bookingService.getAllAsdos());

        return "request-booking";
    }

    @PostMapping("/request-booking")
    public String requestBookingSubmit (CreateBookingDTO createBookingDTO, Model model){
        Booking booking = bookingService.createBooking(createBookingDTO);
        model.addAttribute("createBookingDTO", new CreateBookingDTO());
        model.addAttribute("asdoss", bookingService.getAllAsdos());
        if (booking != null){
            model.addAttribute("bookingResult", "Booking Demo Berhasil!");
        }else{
            model.addAttribute("bookingResult", "Booking Demo Gagal");
        }
        return "request-booking";
    }


}
