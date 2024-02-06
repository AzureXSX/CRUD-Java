package com.example.demo.services;


import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.persistence.*;
import lombok.*;
import jakarta.transaction.Transactional;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.example.demo.models.Image;
import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.helpers.ProductWithImage;
import com.example.demo.repositories.ImageRepository;;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;

    public ProductService(ProductRepository productRepository, ImageRepository imageRepository) {
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
    }

    public List<ProductWithImage> getAllProducts() {

        var products = productRepository.findAll();

        var pr = products.stream()
            .map(product -> {
                var productWithImage = new ProductWithImage();
                productWithImage.setProductId(product.getProductId());
                productWithImage.setProductName(product.getProductName());
                productWithImage.setDescription(product.getDescription());
                productWithImage.setPrice(product.getPrice());
                List<Image> images = imageRepository.findByProductId(product.getProductId());
                List<byte[]> imageBytes = images.stream()
                    .map(Image::getImage)  // assuming getData() returns the byte array
                    .collect(Collectors.toList());
        
                productWithImage.setImages(imageBytes);
                return productWithImage;
            })
            .collect(Collectors.toList());
        
        return pr;
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Image> addImages(List<Image> images) {
        return imageRepository.saveAll(images);
    }

    public Image addImage(Image image) {
        return imageRepository.save(image);
    }

    @Transactional
    public Product updateProduct(Long id, ProductWithImage updatedProduct) {

        Product p = productRepository.findById(id)
            .map(product -> {
                product.setProductName(updatedProduct.getProductName());
                product.setDescription(updatedProduct.getDescription());
                product.setPrice(updatedProduct.getPrice());
                return productRepository.save(product);
            }).orElse(null);

        if (p != null) {
            imageRepository.deleteByProductId(id);
            updatedProduct.getImages().forEach(image -> {
                Image i = new Image();
                i.setImage(image);
                i.setProductId(p.getProductId());
                imageRepository.save(i);
            });
        }
        return p;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
        imageRepository.deleteByProductId(id);
    }
}