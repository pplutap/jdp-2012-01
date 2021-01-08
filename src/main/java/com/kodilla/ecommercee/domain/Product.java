package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "PRODUCTS")
public class Product {
    private Long id;
    private String name;
    private String description;
    private Long groupId;
    private Long price;
    private Order order;

    public Product(String name, String description, Long price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "PRODUCT_ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @Column(name = "PRICE")
    public Long getPrice() {
        return price;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ORDER_ID")
    public Order getOrder() {
        return order;
    }

    @Column(name = "GROUP_ID")
    public Long getGroupId() {
        return groupId;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setPrice(Long price) {
        this.price = price;
    }

    private void setOrder(Order order) {
        this.order = order;
    }

    private void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

}
