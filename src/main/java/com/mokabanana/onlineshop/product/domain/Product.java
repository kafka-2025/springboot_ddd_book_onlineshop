package com.mokabanana.onlineshop.product.domain;

import com.mokabanana.onlineshop.common.domain.Money;

public class Product {
    private Long id;
    private String name;
    private Money price;

    public Product(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
