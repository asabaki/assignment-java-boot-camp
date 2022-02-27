package com.asabaki.bootcamp.Order;

import com.asabaki.bootcamp.Basket.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    BasketService basketService;

    @Autowired
    OrderService orderService;

    @PostMapping("/api/order/checkout")
    public Order checkout(@RequestBody CheckoutPayload payload) {
        var order = this.orderService.createOrder(payload.getBasketId(), payload.getAddress());
        return order;
    }

    @GetMapping("/api/order/all")
    public List<Order> getAllOrder() {
        return this.orderService.getAllOrder();
    }

}

