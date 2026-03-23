package com.mokabanana.onlineshop.order.ui;

import com.mokabanana.onlineshop.order.application.CreateOrderService;
import com.mokabanana.onlineshop.order.domain.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final CreateOrderService createOrderService;

    public OrderController(CreateOrderService createOrderService) {
        this.createOrderService = createOrderService;
    }


    @PostMapping()
    public ResponseEntity<Order> create(@RequestBody OrderRequest orderRequest) {
        Order order = createOrderService.create(orderRequest.to());
        return ResponseEntity.ok(order);
    }
}
