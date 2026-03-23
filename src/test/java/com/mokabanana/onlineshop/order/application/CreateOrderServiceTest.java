package com.mokabanana.onlineshop.order.application;

import com.mokabanana.onlineshop.common.domain.Address;
import com.mokabanana.onlineshop.order.domain.Order;
import com.mokabanana.onlineshop.order.domain.OrderState;
import com.mokabanana.onlineshop.order.domain.Receiver;
import com.mokabanana.onlineshop.order.domain.ShippingInfo;
import com.mokabanana.onlineshop.order.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateOrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private CreateOrderService createOrderService;

    private ShippingInfo shippingInfo;

    @BeforeEach
    void setUp() {
        Receiver receiver = new Receiver("홍길동", "010-1234-5678");
        Address address = new Address("12345", "서울시 강남구", "테헤란로 123");
        shippingInfo = new ShippingInfo(receiver, address);
    }

    @Test
    void 주문_생성시_PAYMENT_WAITING_상태로_저장된다() {
        CreateOrderRequest orderRequest = new CreateOrderRequest(shippingInfo);

        Order result = createOrderService.create(orderRequest);

        assertThat(result.getOrderState()).isEqualTo(OrderState.PAYMENT_WAITING);
    }

    @Test
    void 주문_생성시_배송정보가_올바르게_설정된다() {
        CreateOrderRequest orderRequest = new CreateOrderRequest(shippingInfo);

        Order result = createOrderService.create(orderRequest);

        assertThat(result.getShippingInfo()).isEqualTo(shippingInfo);
    }

    @Test
    void 주문_생성시_OrderRepository에_저장된다() {
        CreateOrderRequest orderRequest = new CreateOrderRequest(shippingInfo);

        Order result = createOrderService.create(orderRequest);

        ArgumentCaptor<Order> captor = ArgumentCaptor.forClass(Order.class);
        verify(orderRepository).save(captor.capture());
        assertThat(captor.getValue()).isEqualTo(result);
    }
}
