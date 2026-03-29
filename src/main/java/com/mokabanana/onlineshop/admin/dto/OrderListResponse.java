package com.mokabanana.onlineshop.admin.dto;

import com.mokabanana.onlineshop.order.domain.OrderNo;
import com.mokabanana.onlineshop.order.domain.OrderState;
import com.mokabanana.onlineshop.order.domain.ShippingInfo;

public record OrderListResponse(
        String orderNo,
        String orderState,
        String receiver_name,
        String receiver_phone,
        String zipCode,
        String address1,
        String address2
) {
    public OrderListResponse(OrderNo orderNo, OrderState orderState, ShippingInfo shippingInfo) {
        this(orderNo.number(),
                orderState.name(),
                shippingInfo.receiver().name(),
                shippingInfo.receiver().phone(),
                shippingInfo.address().zipCode(),
                shippingInfo.address().address1(),
                shippingInfo.address().address2()
        );
    }
}
