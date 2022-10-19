package ru.geekbrains.springweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.springweb.data.Product;
import ru.geekbrains.springweb.repositories.ProductDao;
import ru.geekbrains.springweb.repositories.ProductDaoImpl;
import ru.geekbrains.springweb.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private ProductDao productDao;

    @Autowired
    public void setProductRepository(ProductDaoImpl productDaoImpl) {
        this.productDao = productDaoImpl;
    }

    public List<Product> findALl(){
        return productDao.findAll();
    }

    public Product getProductById(Long id){
        return productDao.getProductById(id);
    }

    public void deleteById(Long id) {
        productDao.deleteByID(id);
    }

    public void changePrice(Long productId, Integer delta) {
        productDao.changePrice(productId, delta);
    }
}
