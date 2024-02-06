package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.*;

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


@RestController
@RequiredArgsConstructor
public class MainController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<Product>  getProducts() {
        System.out.println("Get all products");
        var x = productService.getAllProducts();
        List<Product> ls = new ArrayList<Product>();
        return x == null ? ls : x;
    }

    @PostMapping("/add")
    public List<Product> addProduct(@RequestBody Product product) {
        System.out.println("Add product");
        productService.addProduct(product);
        var x = productService.getAllProducts();
        List<Product> ls = new ArrayList<Product>();
        return x == null ? ls : x;
    }

    @PutMapping("/update/{id}")
    public List<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        System.out.println("Update product");
        productService.updateProduct(id, product);
        var x = productService.getAllProducts();
        List<Product> ls = new ArrayList<Product>();
        return x == null ? ls : x;
    }

    @DeleteMapping("/delete/{id}")
    public List<Product> deleteProduct(@PathVariable Long id) {
        System.out.println("Delete product");
        productService.deleteProduct(id);
        var x = productService.getAllProducts();
        List<Product> ls = new ArrayList<Product>();
        return x == null ? ls : x;
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