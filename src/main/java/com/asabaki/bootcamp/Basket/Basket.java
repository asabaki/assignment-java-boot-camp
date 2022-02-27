package com.asabaki.bootcamp.Basket;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Basket {

    @Id
    private Integer id;

    @ElementCollection
    private List<Integer> itemsId;

    public Basket() {
    }

    public Basket(Integer id, List<Integer> items) {
        this.id = id;
        this.itemsId = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getItems() {
        return itemsId;
    }

    public void setItems(List<Integer> items) {
        this.itemsId = items;
    }
}
