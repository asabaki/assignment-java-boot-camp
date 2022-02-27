package com.asabaki.bootcamp.Product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @Test
    void getAllProduct() {
        var products = new ArrayList<Product>();
        products.add(new Product(1, "iPhone X", 500));
        products.add(new Product(2, "iPhone XR", 500));
        products.add(new Product(3, "iPhone XS", 500));
        products.add(new Product(4, "iPhone 12", 500));
        when(productRepository.findAll()).thenReturn(products);

        var productService = new ProductService(productRepository);

        var actualProducts = productService.getAllProduct();

        assertEquals(products, actualProducts);

    }

    @Test
    void getProductById() {
        var product = new Product(2, "iPhone XR", 500);
        when(productRepository.findById(2)).thenReturn(Optional.of(product));

        var productService = new ProductService(productRepository);

        var actualProduct = productService.getProductById(2);

        assertEquals(product, actualProduct);
    }
}