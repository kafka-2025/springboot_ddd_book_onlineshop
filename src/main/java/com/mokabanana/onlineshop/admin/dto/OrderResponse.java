package com.mokabanana.onlineshop.admin.dto;

import com.mokabanana.onlineshop.order.domain.Order;
import com.mokabanana.onlineshop.order.domain.OrderLine;
import com.mokabanana.onlineshop.order.domain.ShippingInfo;

import java.util.List;

public record OrderResponse(
        String orderNo,
        String orderState,
        ShippingInfo shippingInfo,
        List<OrderLine> orderLines
) {
    public static OrderResponse from(Order order) {
        return new OrderResponse(
                order.getOrderNo().number(),
                order.getOrderState().name(),
                order.getShippingInfo(),
                order.getOrderLines()
        );
    }
}
