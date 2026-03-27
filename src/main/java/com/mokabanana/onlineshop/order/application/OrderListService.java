package com.mokabanana.onlineshop.order.application;

import com.mokabanana.onlineshop.admin.dto.OrderResponse;
import com.mokabanana.onlineshop.common.dto.ListRequest;
import com.mokabanana.onlineshop.common.dto.PageResponse;
import com.mokabanana.onlineshop.order.domain.Order;
import com.mokabanana.onlineshop.order.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class OrderListService {

    private final OrderRepository orderRepository;

    public OrderListService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public PageResponse<OrderResponse> getList(ListRequest listRequest) {
        Pageable pageable = listRequest.toPageable(
                Sort.by(Sort.Direction.DESC, "id")
        );

        Page<Order> orderPage = orderRepository.findAll(pageable);
        return PageResponse.from(orderPage, OrderResponse::from);
    }
}
