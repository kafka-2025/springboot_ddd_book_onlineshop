package com.mokabanana.onlineshop.order.application;

import com.mokabanana.onlineshop.order.domain.ShippingInfo;

public record CreateOrderRequest(ShippingInfo shippingInfo) {
}
