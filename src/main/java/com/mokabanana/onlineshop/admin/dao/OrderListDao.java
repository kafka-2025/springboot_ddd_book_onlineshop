package com.mokabanana.onlineshop.admin.dao;


import com.mokabanana.onlineshop.admin.dto.OrderListResponse;
import com.mokabanana.onlineshop.order.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;



public interface OrderListDao extends Repository<Order, Long> {

    @Query("""
        select new com.mokabanana.onlineshop.admin.dto.OrderListResponse(
            o.orderNo, o.orderState, o.shippingInfo
            )
            from Order o
    """)
    Page<OrderListResponse> findOrders(Pageable pageable);
}
