package com.mokabanana.onlineshop.product.command.application;

import com.mokabanana.onlineshop.product.command.domain.Product;

public record CreateProductResponse(
        String productCode,
        String name,
        long price,
        int stockQuantity
) {
    public static CreateProductResponse from(Product product) {
        return new CreateProductResponse(
                        product.getProductCode().code(),
                        product.getName(),
                        product.getPrice().price().longValue(),
                        product.getStockQuantity()
        );
    }
}
