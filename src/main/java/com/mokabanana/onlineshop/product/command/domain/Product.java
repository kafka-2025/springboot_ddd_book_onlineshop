package com.mokabanana.onlineshop.product.command.domain;

import com.mokabanana.onlineshop.common.domain.Money;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_product", comment = "상품")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private ProductCode productCode;
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "price", column = @Column(name = "order_price", comment = "상품 단가")),
            @AttributeOverride(name = "currency", column = @Column(name = "order_currency", comment = "통화", length = 10))
    })
    private Money price;
    private int stockQuantity;

    public static Product create(String name, Money price, int stockQuantity) {
        Product product = new Product();
        product.name = name;
        product.productCode = ProductCode.generate();
        product.price = price;
        product.stockQuantity = stockQuantity;
        return product;
    }

    public Long getId() {
        return id;
    }

    public ProductCode getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    protected Product() {
    }
}
