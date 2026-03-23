package com.mokabanana.onlineshop.order.ui;

import com.mokabanana.onlineshop.order.application.CreateOrderRequest;
import com.mokabanana.onlineshop.order.domain.OrderLine;
import com.mokabanana.onlineshop.order.domain.ShippingInfo;

import java.util.List;

public record OrderRequest(ShippingInfo shippingInfo, List<OrderLine> orderLines) {
    public CreateOrderRequest to() {
        return new CreateOrderRequest(this.shippingInfo, this.orderLines);
    }
}
