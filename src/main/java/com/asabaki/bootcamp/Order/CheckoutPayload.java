package com.asabaki.bootcamp.Order;

public class CheckoutPayload {

    private int basketId;
    private String address;

    public CheckoutPayload(int basketId, String address) {
        this.basketId = basketId;
        this.address = address;
    }

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
