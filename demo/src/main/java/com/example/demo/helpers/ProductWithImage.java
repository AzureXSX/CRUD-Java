package com.example.demo.helpers;

import java.lang.reflect.Array;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import com.example.demo.models.Product;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductWithImage extends Product {
    private List<byte[]> images;
}
