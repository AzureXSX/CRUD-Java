package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private Long ProductId;
    
    @Column(name = "ProductName")
    private String ProductName;

    @Column(name = "Description")
    private String Description;

    @Column(name = "Price")
    private Double Price;
}
