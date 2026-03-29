package com.mokabanana.onlineshop.product.command.repository;

import com.mokabanana.onlineshop.product.command.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
