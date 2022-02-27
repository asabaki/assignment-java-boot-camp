package com.asabaki.bootcamp.Payment;

import com.asabaki.bootcamp.Order.CheckoutPayload;
import com.asabaki.bootcamp.Order.Order;
import com.asabaki.bootcamp.Product.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("It should properly create payment")
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    void createPayment() {
        var product = new ArrayList<Product>();
        product.add(new Product(1, "iPhone X", 500));

        // Add item to basket
        testRestTemplate.postForObject("/api/basket/addItems", product, Product[].class);
        var payload = new CheckoutPayload(1, "SomeAddress");

        // Create Order (Checkout)
        var order = testRestTemplate.postForObject("/api/order/checkout", payload, Order.class);

        // Make payment
        var payment = testRestTemplate.postForObject("/api/payment/create", order.getOrderId(), String.class);

        assertTrue(payment.contains("Successful"));
    }
}