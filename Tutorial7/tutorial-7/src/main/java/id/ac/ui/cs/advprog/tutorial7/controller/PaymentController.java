package id.ac.ui.cs.advprog.tutorial7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.ac.ui.cs.advprog.tutorial7.core.vaapi.VirtualAccount;
import id.ac.ui.cs.advprog.tutorial7.model.PaymentDetails;
import id.ac.ui.cs.advprog.tutorial7.model.PaymentResponse;
import id.ac.ui.cs.advprog.tutorial7.service.PaymentService;

@RestController
@RequestMapping("/api")
public class PaymentController {
    
    @Autowired
    PaymentService paymentService;
    
    @PostMapping("/new-va")
    public ResponseEntity createNewVa(@RequestBody VirtualAccount va) {
        
        String ret = paymentService.createNewVA(va.getVaAmount(), va.getBank());
        va.setVa(ret);
        return ResponseEntity.ok(va);

    }

    @PostMapping("/pay")
    public ResponseEntity<Object> pay(@RequestBody PaymentDetails paymentDetails) {

        long st = System.currentTimeMillis();
        PaymentResponse ret = paymentService.pay(paymentDetails.getVa(), paymentDetails.getPayAmount(), paymentDetails.getDay(), paymentDetails.getTime());
        long ed = System.currentTimeMillis();

        ret.time = ed - st;
        System.out.println(ret);
        return new ResponseEntity<Object>(ret, HttpStatus.OK);
        
    }
}
