package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Product;

import com.example.demo.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{
    void deleteByProductId(Long productId);
    List<Image> findByProductId(Long productId);
}
