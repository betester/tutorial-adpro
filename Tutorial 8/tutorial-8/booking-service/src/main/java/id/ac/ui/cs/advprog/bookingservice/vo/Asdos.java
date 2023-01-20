package id.ac.ui.cs.advprog.bookingservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asdos {
    private String code;
    private String name;
    private String asdosClass;
    private String officeHourOpen;
    private String officeHourClose;
}
