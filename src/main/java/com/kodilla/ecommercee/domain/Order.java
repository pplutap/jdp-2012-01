package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ORDER")
public class Order {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID",
            unique = true)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "order",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();
}
