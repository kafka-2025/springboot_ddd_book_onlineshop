package com.mokabanana.onlineshop.admin.dto;

import com.mokabanana.onlineshop.order.domain.Order;
import com.mokabanana.onlineshop.order.domain.ShippingInfo;

public record OrderListResponse(
        String orderNo,
        String orderState,
        ShippingInfo shippingInfo
        ) {
    public static OrderListResponse from(Order order) {
        return new OrderListResponse(
                order.getOrderNo().number(),
                order.getOrderState().name(),
                order.getShippingInfo()
        );
    }
}
