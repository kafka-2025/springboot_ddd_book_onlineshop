package com.mokabanana.onlineshop.product.ui;

import com.mokabanana.onlineshop.product.command.application.CreateProductRequest;
import com.mokabanana.onlineshop.product.command.application.CreateProductResponse;
import com.mokabanana.onlineshop.product.command.application.CreateProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final CreateProductService createProductService;

    public ProductController(CreateProductService createProductService) {
        this.createProductService = createProductService;
    }

    @PostMapping("")
    public ResponseEntity<List<CreateProductResponse>> create(@RequestBody List<CreateProductRequest> request) {
        List<CreateProductResponse> products = createProductService.create(request);
        return ResponseEntity.ok(products);
    }
}
