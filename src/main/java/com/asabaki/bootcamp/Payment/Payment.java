package com.asabaki.bootcamp.Payment;

import javax.persistence.*;

@Entity
@Table(name = "Payment_Table")
public class Payment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int paymentId;

    private int orderId;

    public Payment() {
    }

    public Payment(int orderId) {
        this.orderId = orderId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
