package com.mokabanana.onlineshop.order.domain;

import com.mokabanana.onlineshop.common.domain.Money;
import jakarta.persistence.*;

@Embeddable
public class OrderLine {

    @Column(name = "product_id", comment = "상품 단가")
    private Long productId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "price", column = @Column(name = "order_price", comment = "상품 단가")),
            @AttributeOverride(name = "currency", column = @Column(name = "order_currency", comment = "통화", length = 10))
    })
    private Money price;

    @Column(comment = "수량")
    private int quantity;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "price", column = @Column(name = "order_amount", comment = "상품 총 금액")),
            @AttributeOverride(name = "currency", column = @Column(name = "order_currency", comment = "통화", length = 10, insertable = false, updatable = false))
    })
    private Money amount;

    protected OrderLine() {}

    public OrderLine(Long productId, Money price, int quantity) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.amount = price.multiply(quantity);
    }
}
