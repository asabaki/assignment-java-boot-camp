package com.asabaki.bootcamp.Product;

import javax.persistence.*;

@Table(name = "product")
@Entity
public class Product {
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Id
    private Integer id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {

    }
}
