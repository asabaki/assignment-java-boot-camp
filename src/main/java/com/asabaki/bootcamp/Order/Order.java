package com.asabaki.bootcamp.Order;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Order_Table")
public class Order {

    @Column(name = "orderId")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer orderId;

    private Integer total;

    private String status;
    private String address;

    @ElementCollection
    private List<Integer> prodIds;

    public Order() {
    }

    public Order(Integer orderId, Integer total, List<Integer> productIds) {
        this.orderId = orderId;
        this.total = total;
        this.prodIds = productIds;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public Integer getOrderId() {
        return orderId;
    }

    public Integer getTotal() {
        return total;
    }

    public List<Integer> getProdIds() {
        return prodIds;
    }




}
