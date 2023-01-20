package id.ac.ui.cs.advprog.tutorial7.model;

import lombok.ToString;

/*
class to return on payment attemp.
OK: 1 if successfull, 0 if not
message: gives error message if unsuccessfull
*/
@ToString
public class PaymentResponse {
    public int ok;
    public String message;
    public long time;

    public PaymentResponse(int ok, String message) {
        this.ok = ok;
        this.message = message;
    }
}
