package com.asabaki.bootcamp.Basket;

import com.asabaki.bootcamp.Product.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BasketControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("It should properly show all basket")
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    public void case01() {
        var objects = testRestTemplate.getForObject("/api/basket/all", Basket[].class);
        assertEquals(0, objects.length);
    }

    @Test
    @DisplayName("It should properly add items to basket")
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    public void addItem() {
        var product = new Product(1, "iPhoneX", 900);
        var objects = testRestTemplate.postForObject("/api/basket/addItems", new Product[]{ product }, Product[].class);
        assertEquals(1, objects.length);
    }
}