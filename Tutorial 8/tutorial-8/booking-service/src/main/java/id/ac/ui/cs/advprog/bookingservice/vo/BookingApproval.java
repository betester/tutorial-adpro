package id.ac.ui.cs.advprog.bookingservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingApproval {
    private String status;
    private String message;
}
