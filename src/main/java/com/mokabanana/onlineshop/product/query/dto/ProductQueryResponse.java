package com.mokabanana.onlineshop.product.query.dto;

import com.mokabanana.onlineshop.product.command.domain.Product;

public record ProductQueryResponse(
        Long id,
        String productCode,
        String name,
        long price,
        int stockQuantity
) {
    public ProductQueryResponse (Product product) {
        this(
                product.getId(),
                product.getProductCode().code(),
                product.getName(),
                product.getPrice().price().longValue(),
                product.getStockQuantity()
        );
    }
}
