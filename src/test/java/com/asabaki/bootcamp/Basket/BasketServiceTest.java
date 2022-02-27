package com.asabaki.bootcamp.Basket;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BasketServiceTest {

    @Mock
    BasketRepository basketRepository;

    @Test
    void getBasketById() {
        var toReturn = new ArrayList<Integer>();
        toReturn.add(1);
        when(basketRepository.getById(1)).thenReturn(new Basket(1, toReturn));

        var basketService = new BasketService(basketRepository);
        var basket = basketService.getBasketById(1);
        assertEquals(1, basket.getItems().toArray().length);
    }

    @Test
    void getBasket() {
        var basketService = new BasketService(basketRepository);
        var baskets = basketService.getBasket();
        assertEquals(0, baskets.toArray().length);
    }
}