package id.ac.ui.cs.advprog.asdos.asdos.controller;

import id.ac.ui.cs.advprog.asdos.asdos.model.Asdos;
import id.ac.ui.cs.advprog.asdos.asdos.model.dto.BookingApprovalDTO;
import id.ac.ui.cs.advprog.asdos.asdos.model.dto.BookingRequestDTO;
import id.ac.ui.cs.advprog.asdos.asdos.service.AsdosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/asdos")
public class AsdosController {
    @Autowired
    private AsdosService asdosService;

    @GetMapping(path = "/", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Iterable<Asdos>> getListAsdos(@RequestParam(required = false) String asdosClass){
        if(asdosClass != null){
            return ResponseEntity.ok(asdosService.filterAsdosByClass(asdosClass));
        }
        return ResponseEntity.ok(asdosService.getAllAsdos());
    }

    @GetMapping(path = "/{code}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity getAsdos(@PathVariable(value = "code") String code){
        return ResponseEntity.ok(asdosService.getAsdosByCode(code));
    }

    @PostMapping(path = "/book", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity bookingAsdos(@RequestBody BookingRequestDTO bookingRequestDTO){
        if( asdosService.getAsdosByCode(bookingRequestDTO.getAsdosCode()) == null ){
            BookingApprovalDTO bookingApprovalDTO = new BookingApprovalDTO();
            bookingApprovalDTO.setStatus("Failed");
            bookingApprovalDTO.setMessage("Kode asdos salah/tidak terdaftar");
            return ResponseEntity.badRequest().body(bookingApprovalDTO);
        }
        return ResponseEntity.ok(asdosService.validateAsdosBooking(bookingRequestDTO));
    }

}
