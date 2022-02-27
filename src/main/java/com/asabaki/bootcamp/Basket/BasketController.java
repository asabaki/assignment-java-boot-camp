package com.asabaki.bootcamp.Basket;

import com.asabaki.bootcamp.Product.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BasketController {
    private static final Logger logger = LoggerFactory.getLogger(BasketController.class);
    @Autowired
    BasketService basketService;


    @PostMapping("/api/basket/addItems")
    public List<Product> addItems(@RequestBody List<Product> items) {
        this.basketService.addProducts(1, items);
        return items;
    }

    @GetMapping("/api/basket/all")
    public List<Basket> getBasket() {
        return this.basketService.getBasket();
    }
}
