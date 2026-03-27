package com.mokabanana.onlineshop.admin.ui;

import com.mokabanana.onlineshop.admin.dto.OrderResponse;
import com.mokabanana.onlineshop.common.dto.ListRequest;
import com.mokabanana.onlineshop.common.dto.PageResponse;
import com.mokabanana.onlineshop.order.application.OrderListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminOrderController {

    private final OrderListService orderListService;

    public AdminOrderController(OrderListService orderListService) {
        this.orderListService = orderListService;
    }

    @GetMapping("/orders")
    public ResponseEntity<PageResponse<OrderResponse>> orders(ListRequest listRequest) {
        PageResponse<OrderResponse> list = orderListService.getList(listRequest);
        return ResponseEntity.ok(list);
    }
}
