package com.asabaki.bootcamp.Order;

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
class OrderControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    void checkout() {

        var product = new ArrayList<Product>();
        product.add(new Product(1, "iPhone X", 500));
        testRestTemplate.postForObject("/api/basket/addItems", product, Product[].class);
        var payload = new CheckoutPayload(1, "SomeAddress");

        var order = testRestTemplate.postForObject("/api/order/checkout", payload, Order.class);

        assertEquals("SomeAddress", order.getAddress());

    }

    @Test
    @DisplayName("It should get all order")
    void getAllOrder() {
        var objects = testRestTemplate.getForObject("/api/order/all", Order[].class);

        assertEquals(0, objects.length);
    }
}