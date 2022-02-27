package com.asabaki.bootcamp.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/api/product")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/api/product/{id}")
    public Product getProductByName(@PathVariable Integer id) {
        return productService.getProductById(id);
    }
}
