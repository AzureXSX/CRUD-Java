package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Images")
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ImageId")
    private Long ImageId;
    
    @Column(name = "ProductId")
    private Long productId;

    @Column(name = "image")
    private byte[] image;
}
