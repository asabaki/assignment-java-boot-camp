package com.asabaki.bootcamp.Basket;


import com.asabaki.bootcamp.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BasketService {

    @Autowired
    private BasketRepository basketRepository;

    public BasketService() {
    }

    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public void addProducts(int basketId, List<Product> products) {
        var id = new ArrayList<Integer>();
        for (Product product: products) {
            id.add(product.getId());
        }
        Optional<Basket> basket = this.basketRepository.findById(basketId);
        if (basket.isEmpty()) {
            Basket b = new Basket(basketId, id);
            this.basketRepository.save(b);
            return;
        }

        basket.get().getItems().addAll(id);
        this.basketRepository.save(basket.get());
    }

    public Basket getBasketById(int id) {
        Basket basket = this.basketRepository.getById(id);
        return basket;
    }

    public List<Basket> getBasket() {
        return this.basketRepository.findAll();
    }
}
