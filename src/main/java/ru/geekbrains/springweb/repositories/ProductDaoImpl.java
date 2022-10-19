package ru.geekbrains.springweb.repositories;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.geekbrains.springweb.data.Product;
import ru.geekbrains.springweb.utils.SessionFactoryUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{

    private SessionFactoryUtils sessionFactoryUtils;

    @Autowired
    public void setSessionFactoryUtils(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }
    @PostConstruct
    public void init() {
        sessionFactoryUtils.init();
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("select p from Product p").getResultList();
            System.out.println(products);
            session.getTransaction().commit();
            return products;
        }
    }


    @Override
    public Product getProductById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public void deleteByID(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void changePrice(Long id, Integer price) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setPrice(product.getPrice() + price);
            session.save(product);
            session.getTransaction().commit();
        }
    }
}
