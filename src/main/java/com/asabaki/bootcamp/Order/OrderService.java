package com.asabaki.bootcamp.Order;


import com.asabaki.bootcamp.Basket.Basket;
import com.asabaki.bootcamp.Basket.BasketService;
import com.asabaki.bootcamp.Product.Product;
import com.asabaki.bootcamp.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class OrderService {

    @Autowired
    BasketService basketService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderRepository orderRepository;

    public OrderService(BasketService basketService, ProductService productService, OrderRepository orderRepository) {
        this.basketService = basketService;
        this.productService = productService;
        this.orderRepository = orderRepository;
    }

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderService() {
    }

    public Order createOrder(Integer basketId, String address) {
        Integer orderId = ThreadLocalRandom.current().nextInt(1, 1000);
        Basket basket = basketService.getBasketById(basketId);
        List<Product> products = new ArrayList<>();
        var totalAmount = 0;
        for (Integer productId : basket.getItems()) {
            Product p = productService.getProductById(productId);
            totalAmount += p.getPrice();
            products.add(p);
        }
        Order order = new Order(orderId, totalAmount, basket.getItems());
        order.setAddress(address);
        order.setStatus("Unpaid");
        orderRepository.save(order);
        return order;
    }

    public void paidOrder(Integer orderId) throws Exception {
        Optional<Order> o = this.orderRepository.findById(orderId);
        if (!o.isEmpty()) {
            var order = o.get();
            order.setStatus("Paid");
        }
        throw new Exception("Order is not found");
    }

    public Order getOrderById(Integer orderId) throws Exception {
        Optional<Order> o = this.orderRepository.findById(orderId);
        if (!o.isEmpty()) {
            var order = o.get();
            return order;
        }
        throw new Exception("Order is not found");
    }


    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }
}
