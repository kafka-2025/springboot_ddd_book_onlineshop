package com.mokabanana.onlineshop.order.ui;

import com.mokabanana.onlineshop.order.application.CreateOrderRequest;
import com.mokabanana.onlineshop.order.domain.ShippingInfo;

public record OrderRequest(ShippingInfo shippingInfo) {
    public CreateOrderRequest to() {
        return new CreateOrderRequest(this.shippingInfo());
    }
}
