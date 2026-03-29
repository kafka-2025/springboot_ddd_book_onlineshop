package com.mokabanana.onlineshop.product.ui;

import com.mokabanana.onlineshop.common.dto.ListRequest;
import com.mokabanana.onlineshop.common.dto.PageResponse;
import com.mokabanana.onlineshop.product.command.application.CreateProductRequest;
import com.mokabanana.onlineshop.product.command.application.CreateProductResponse;
import com.mokabanana.onlineshop.product.command.application.CreateProductService;
import com.mokabanana.onlineshop.product.query.application.ProductQueryService;
import com.mokabanana.onlineshop.product.query.dto.ProductQueryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final CreateProductService createProductService;
    private final ProductQueryService productQueryService;

    public ProductController(CreateProductService createProductService, ProductQueryService productQueryService) {
        this.createProductService = createProductService;
        this.productQueryService = productQueryService;
    }

    @PostMapping("")
    public ResponseEntity<List<CreateProductResponse>> create(@RequestBody List<CreateProductRequest> request) {
        List<CreateProductResponse> products = createProductService.create(request);
        return ResponseEntity.ok(products);
    }

    @GetMapping("")
    public ResponseEntity<?> getList(ListRequest listRequest) {
        PageResponse<ProductQueryResponse> list = productQueryService.getList(listRequest);
        return ResponseEntity.ok(list);
    }
}
