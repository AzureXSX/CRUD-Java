package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.*;

import com.example.demo.helpers.ProductWithImage;
import com.example.demo.models.Image;
import com.example.demo.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Product;
import com.example.demo.services.ProductService;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.helpers.ProductWithImage;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final ProductService productService;

    @PostMapping("/x")
    public ProductWithImage index(@RequestBody ProductWithImage product) {
        System.out.println(product.getProductName());
        return product;
    }


    @GetMapping("/products")
    public List<ProductWithImage>  getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/add")
    public List<ProductWithImage> addProduct(@RequestBody ProductWithImage product) {
        Product p = new Product();
        p.setProductName(product.getProductName());
        p.setDescription(product.getDescription());
        p.setPrice(product.getPrice());
        productService.addProduct(p);

        product.getImages().forEach(image -> {
            Image i = new Image();
            i.setImage(image);
            i.setProductId(p.getProductId());
            productService.addImage(i);
        });

        return productService.getAllProducts();
    }

    @PutMapping("/update/{id}")
    public List<ProductWithImage> updateProduct(@PathVariable Long id, @RequestBody ProductWithImage product) {
        productService.updateProduct(id, product);
        return productService.getAllProducts();
    }

    @DeleteMapping("/delete/{id}")
    public List<ProductWithImage> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return productService.getAllProducts();
    }

    // @DeleteMapping("/delete/{id}")
    // public List<Product> delete(@PathVariable int id) {
    //     list.removeIf(product -> product.ProductId == id);
    //     return list;
    // }

    // @PutMapping("/update/{id}")
    // public List<Product> update(@PathVariable int id, @RequestBody Product product) {
    //     System.out.println(product.ProductName);
    //     for (int i = 0; i < list.size(); i++) {
    //         if (list.get(i).ProductId == id) {
    //             list.set(i, product);
    //         }
    //     }
    //     return list;
    // }


    // @PostMapping("/add")
    // public List<Product> add(@RequestBody Product product) {
    //     product.ProductId = id++;
    //     list.add(product);
    //     return list;
    // }
}