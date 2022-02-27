package com.asabaki.bootcamp.Payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping("/api/payment/create")
    public String createPayment(@RequestBody int orderId) {
        try {
            var paymentId = this.paymentService.createPayment(orderId);
            return "Payment Successful. PaymentID" + paymentId;
        } catch (Exception e) {
            return "Payment Unsuccessful";
        }
    }
}
