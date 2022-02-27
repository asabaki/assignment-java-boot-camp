package com.asabaki.bootcamp.Payment;


import com.asabaki.bootcamp.Order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentRepository paymentRepository;

    public int createPayment(Integer orderId) {
        try {
            var order = this.orderService.getOrderById(orderId);
            var payment = this.paymentRepository.save(new Payment(order.getOrderId()));
            this.orderService.paidOrder(orderId);

            return payment.getPaymentId();
        } catch (Exception e) {
            return -1;
        }
    }
}
