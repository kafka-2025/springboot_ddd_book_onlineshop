package com.mokabanana.onlineshop.order.application;

import com.mokabanana.onlineshop.admin.dao.OrderListDao;
import com.mokabanana.onlineshop.admin.dto.OrderListResponse;
import com.mokabanana.onlineshop.common.dto.ListRequest;
import com.mokabanana.onlineshop.common.dto.PageResponse;
import com.mokabanana.onlineshop.order.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class OrderQueryService {

    private final OrderRepository orderRepository;
    private final OrderListDao orderListDao;

    public OrderQueryService(OrderRepository orderRepository, OrderListDao orderListDao) {
        this.orderRepository = orderRepository;
        this.orderListDao = orderListDao;
    }

    public PageResponse<OrderListResponse> getList(ListRequest listRequest) {
        Pageable pageable = listRequest.toPageable(
                Sort.by(Sort.Direction.DESC, "id")
        );
        Page<OrderListResponse> orders = orderListDao.findOrders(pageable);
        return PageResponse.from(orders);
    }
}
