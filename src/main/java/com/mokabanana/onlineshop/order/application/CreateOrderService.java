package com.mokabanana.onlineshop.order.application;

import com.mokabanana.onlineshop.order.domain.Order;
import com.mokabanana.onlineshop.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CreateOrderService {

    private final OrderRepository orderRepository;

    public CreateOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Transactional
    public Order create(CreateOrderRequest orderRequest) {
        Order newOrder = Order.create(orderRequest.shippingInfo(), orderRequest.orderLines());
        orderRepository.save(newOrder);
        return newOrder;
    }
}
