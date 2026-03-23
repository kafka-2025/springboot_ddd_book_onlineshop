package com.mokabanana.onlineshop.order.application;

import com.mokabanana.onlineshop.order.domain.OrderLine;
import com.mokabanana.onlineshop.order.domain.ShippingInfo;

import java.util.List;

public record CreateOrderRequest(ShippingInfo shippingInfo, List<OrderLine> orderLines) {
}
