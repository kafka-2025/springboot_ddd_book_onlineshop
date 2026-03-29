package com.mokabanana.onlineshop.product.command.application;

public record CreateProductRequest(String name, long price, int stockQuantity) {
}
