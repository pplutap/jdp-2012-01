package com.kodilla.ecommercee.domain;

import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@Entity(name = "ORDER")
public class Order {
    private Long id = null;
    private String name;
    private List<Product> products;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ORDER_ID",
            unique = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "ORDER_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "PRODUCT_ID",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY)
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
