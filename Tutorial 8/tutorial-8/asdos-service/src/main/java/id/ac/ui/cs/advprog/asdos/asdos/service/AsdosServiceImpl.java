package id.ac.ui.cs.advprog.asdos.asdos.service;


import id.ac.ui.cs.advprog.asdos.asdos.model.Asdos;
import id.ac.ui.cs.advprog.asdos.asdos.model.dto.BookingApprovalDTO;
import id.ac.ui.cs.advprog.asdos.asdos.model.dto.BookingRequestDTO;
import id.ac.ui.cs.advprog.asdos.asdos.repository.AsdosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Service
public class AsdosServiceImpl implements AsdosService{
    @Autowired
    AsdosRepository asdosRepository;

    @Override
    public List<Asdos> getAllAsdos() {
        return asdosRepository.findAll();
    }

    @Override
    public Asdos getAsdosByCode(String code) {
        return asdosRepository.getByCode(code);
    }

    @Override
    public List<Asdos> filterAsdosByClass(String asdosClass) {
        return asdosRepository.getByAsdosClass(asdosClass);
    }

    @Override
    public BookingApprovalDTO validateAsdosBooking(BookingRequestDTO bookingRequest) {
        Asdos asdos = getAsdosByCode(bookingRequest.getAsdosCode());
        LocalTime requestedTime = bookingRequest.getRequestedTime();
        BookingApprovalDTO bookingApprovalDTO = new BookingApprovalDTO();
        if(requestedTime.isAfter(asdos.getOfficeHourOpen()) && requestedTime.isBefore(asdos.getOfficeHourClose())){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.US);
            bookingApprovalDTO.setStatus("Success");
            bookingApprovalDTO.setMessage("Kode Booking: " +  bookingRequest.getAsdosCode() + "_" + bookingRequest.getBookerClass() + "_" + LocalTime.now().format(formatter));
            return bookingApprovalDTO;
        }
        bookingApprovalDTO.setStatus("Failed");
        bookingApprovalDTO.setMessage("Maaf, asdos yang bersangkutan tidak dapat melakukan demo pada jam yang diminta. Harap memilih jam lain");
        return bookingApprovalDTO;
    }
}
