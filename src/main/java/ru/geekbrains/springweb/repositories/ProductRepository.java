package ru.geekbrains.springweb.repositories;

import org.springframework.stereotype.Repository;
import ru.geekbrains.springweb.data.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1l, "Demon Souls", 10),
                new Product(2l, "Dark Souls", 10),
                new Product(3l, "Bloodborne", 10),
                new Product(4l, "Elden Ring", 10),
                new Product(5l, "Dark Souls2", 10)));
    }

    public List<Product> findALl(){
        return Collections.unmodifiableList(products);
    }

    public Product getProductById(Long id){
        for (Product p : products){
            if (p.getId() == id){
                return p;
            }
        }
        throw new RuntimeException("Product with id: " + id + " not found");
    }

    public void deleteById(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

}
