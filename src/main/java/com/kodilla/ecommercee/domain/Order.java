package com.kodilla.ecommercee.domain;

import lombok.NoArgsConstructor;
import javax.persistence.*;


@NoArgsConstructor
@Entity(name = "order")
public class Order {
    private long id;
    private String name;
    private List<Product> products;

    @Id
    @GeneratedValue
    @Column(name = "ID",
            unique = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "product",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY)
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
