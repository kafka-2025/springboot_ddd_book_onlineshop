package com.mokabanana.onlineshop.product.query.dto;

import com.mokabanana.onlineshop.common.domain.Money;
import com.mokabanana.onlineshop.product.command.domain.ProductCode;

public record ProductQueryResponse(
        Long id,
        String productCode,
        String name,
        long price,
        int stockQuantity
) {
    public ProductQueryResponse(Long id, ProductCode productCode, String name, Money price, int stockQuantity) {
        this(id, productCode.code(), name, price.price().longValue(), stockQuantity);
    }
}
