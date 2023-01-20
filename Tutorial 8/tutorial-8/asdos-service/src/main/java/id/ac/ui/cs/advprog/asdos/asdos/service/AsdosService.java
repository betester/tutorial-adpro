package id.ac.ui.cs.advprog.asdos.asdos.service;

import id.ac.ui.cs.advprog.asdos.asdos.model.Asdos;
import id.ac.ui.cs.advprog.asdos.asdos.model.dto.BookingApprovalDTO;
import id.ac.ui.cs.advprog.asdos.asdos.model.dto.BookingRequestDTO;

import java.util.List;

public interface AsdosService {

    List<Asdos> getAllAsdos();
    Asdos getAsdosByCode(String code);
    List<Asdos> filterAsdosByClass(String asdosClass);
    BookingApprovalDTO validateAsdosBooking(BookingRequestDTO bookingRequest);

}
