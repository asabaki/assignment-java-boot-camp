package com.asabaki.bootcamp;

import com.asabaki.bootcamp.Product.Product;
import com.asabaki.bootcamp.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	ProductRepository productRepository;

	@PostConstruct
	public void initialData() {
		Iterable<Product> products = List.of(new Product[]{
				new Product(1, "iPhone 5", 600),
				new Product(2, "iPhone X", 500),
				new Product(3, "iPhone 6", 500),
				new Product(4, "iPhone 4", 100),
		});
		productRepository.saveAll(products);
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
