package com.javatechie.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Products {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "product_id",unique=true)
    private String productId;
    private String title;
    private String description;
    private String img;
    @OneToMany(targetEntity = Categories.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name ="cp_fk",referencedColumnName = "id")
    private List<Categories> categories;
    private String size;
    private String color;
    private int price;
    private boolean inStock;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
