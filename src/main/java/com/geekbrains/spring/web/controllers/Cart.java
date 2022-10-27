package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.geekbrains.spring.web.exceptions.ResourceNotFoundException;
import com.geekbrains.spring.web.services.ProductsService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/cart")
public class Cart {

    private List<Product> products;

    private final ProductsService productsService;


    @PostConstruct
    public void init() {
        products = new ArrayList<>();
    }

    @GetMapping("/{id}")
    public void addProductById(@PathVariable Long id) {
        Product product = productsService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
        products.add(product);
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return products;
    }
}



