package com.geekbrains.spring.web.converters;

import com.geekbrains.spring.web.entities.Product;
import org.springframework.stereotype.Component;
import com.geekbrains.spring.web.dto.ProductDto;

@Component
public class ProductConverter {
    public Product dtoToEntity(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getPrice());
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice());
    }
}
