package com.example.demo.services;


import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {

        try{
            return productRepository.findAll();
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
        
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id)
            .map(product -> {
                product.setProductName(updatedProduct.getProductName());
                product.setDescription(updatedProduct.getDescription());
                product.setPrice(updatedProduct.getPrice());
                return productRepository.save(product);
            }).orElse(null);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}