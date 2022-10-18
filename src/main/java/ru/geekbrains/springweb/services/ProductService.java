package ru.geekbrains.springweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.springweb.data.Product;
import ru.geekbrains.springweb.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findALl(){
        return productRepository.findALl();
    }

    public Product getProductById(Long id){
        return productRepository.getProductById(id);
    }
}
