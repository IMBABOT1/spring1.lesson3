package ru.geekbrains.springweb.repositories;

import ru.geekbrains.springweb.data.Product;

import java.util.List;

public interface ProductDao {

    List<Product> findAll();
    Product getProductById(Long id);
    void deleteByID(Long id);
    void changePrice(Long id, Integer price);
}
