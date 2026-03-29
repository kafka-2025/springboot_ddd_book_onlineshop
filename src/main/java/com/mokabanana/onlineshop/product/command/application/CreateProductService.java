package com.mokabanana.onlineshop.product.command.application;

import com.mokabanana.onlineshop.common.domain.Money;
import com.mokabanana.onlineshop.product.command.domain.Product;
import com.mokabanana.onlineshop.product.command.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateProductService {

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<CreateProductResponse> create(List<CreateProductRequest> request) {
        List<Product> products = productRepository.saveAll(
                request.stream().map(r -> Product.create(
                        r.name(),
                        Money.won(r.price()),
                        r.stockQuantity()
                )).toList()
        );
        return products.stream().map(CreateProductResponse::from).toList();
    }
}
