package com.geekbrains.spring.web.entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

public class Category {

    private Long id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private List<Product> list;

}
