package com.mokabanana.onlineshop.product.query.dao;

import com.mokabanana.onlineshop.product.command.domain.Product;
import com.mokabanana.onlineshop.product.query.dto.ProductQueryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface ProductQueryDao extends Repository<Product, Long> {

    @Query("""
                select new com.mokabanana.onlineshop.product.query.dto.ProductQueryResponse
                     (p.id, p.productCode, p.name, p.price, p.stockQuantity)
                     from Product p
            """)
    Page<ProductQueryResponse> findAll(Pageable pageable);
}
