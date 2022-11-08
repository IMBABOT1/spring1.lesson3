package com.geekbrains.spring.web.converters;


import com.geekbrains.spring.web.dto.ProductDto;
import com.geekbrains.spring.web.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductSoapConverter {


    public com.geekbrains.spring.web.soap.Product entityToDto(Product product) {
        com.geekbrains.spring.web.soap.Product p = new com.geekbrains.spring.web.soap.Product();
        p.setId(product.getId());
        p.setPrice(product.getPrice());
        p.setTitle(product.getTitle());
        p.setCategory(product.getCategory().getTitle());
        return p;
    }
}
