package com.mokabanana.onlineshop.order.application;

import com.mokabanana.onlineshop.order.domain.Order;
import com.mokabanana.onlineshop.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderService {

    private final OrderRepository orderRepository;

    public CreateOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order create(CreateOrderRequest orderRequest) {
        Order newOrder = Order.create(orderRequest.shippingInfo());
        orderRepository.save(newOrder);
        return newOrder;
    }
}
