package com.mokabanana.onlineshop.admin.ui;

import com.mokabanana.onlineshop.admin.dto.OrderListResponse;
import com.mokabanana.onlineshop.common.dto.ListRequest;
import com.mokabanana.onlineshop.common.dto.PageResponse;
import com.mokabanana.onlineshop.order.application.OrderQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminOrderController {

    private final OrderQueryService orderQueryService;

    public AdminOrderController(OrderQueryService orderQueryService) {
        this.orderQueryService = orderQueryService;
    }

    @GetMapping("/orders")
    public ResponseEntity<PageResponse<OrderListResponse>> orders(ListRequest listRequest) {
        PageResponse<OrderListResponse> list = orderQueryService.getList(listRequest);
        return ResponseEntity.ok(list);
    }
}
