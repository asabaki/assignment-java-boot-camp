package com.asabaki.bootcamp.Order;

import com.asabaki.bootcamp.Basket.Basket;
import com.asabaki.bootcamp.Basket.BasketRepository;
import com.asabaki.bootcamp.Basket.BasketService;
import com.asabaki.bootcamp.Product.Product;
import com.asabaki.bootcamp.Product.ProductRepository;
import com.asabaki.bootcamp.Product.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @Mock
    BasketRepository basketRepository;

    @Mock
    ProductRepository productRepository;

    @Test
    void createOrder() {
        var itemIds = new ArrayList<Integer>();
        itemIds.add(1);
        when(basketRepository.getById(1)).thenReturn(new Basket(1, itemIds));
        when(productRepository.findById(1)).thenReturn(Optional.of(new Product(1, "iphoneX", 500)));

        BasketService basketService = new BasketService(basketRepository);
        ProductService productService = new ProductService(productRepository);
        OrderService orderService = new OrderService(basketService, productService, orderRepository);

        var order = orderService.createOrder(1, "SomeAddress");

        assertEquals("Unpaid", order.getStatus());


    }

    @Test
    void getOrderById() {
        var itemIds = new ArrayList<Integer>();
        itemIds.add(1);
        var o = new Order(1, 500, itemIds);
        o.setStatus("Unpaid");
        o.setAddress("SomeAddress");
        when(orderRepository.findById(1)).thenReturn(Optional.of(o));

        OrderService orderService = new OrderService(orderRepository);

        try {
            var order = orderService.getOrderById(1);
            assertEquals("Unpaid", order.getStatus());

        } catch (Exception e) {

        }

    }

    @Test
    void getAllOrder() {
        when(orderRepository.findAll()).thenReturn(new ArrayList<>());

        OrderService orderService = new OrderService(orderRepository);

        var orders = orderService.getAllOrder();
        assertEquals(0, orders.toArray().length);
    }
}