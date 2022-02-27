package com.asabaki.bootcamp.Product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("It should list all products")
    void getAllProduct() {
        var objects = testRestTemplate.getForObject("/api/product", Product[].class);
        assertEquals(4, objects.length);

    }

    @Test
    @DisplayName("It should get product by ID")
    void getProductByName() {
        var object = testRestTemplate.getForObject("/api/product/1", Product.class);
        assertEquals(1, object.getId());
        assertEquals("iPhone 5", object.getName());
        assertEquals(600, object.getPrice());
    }
}