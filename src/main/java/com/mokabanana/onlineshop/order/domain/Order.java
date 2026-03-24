package com.mokabanana.onlineshop.order.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_order")
@Access(AccessType.FIELD)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(comment = "주문ID")
    private Long id;  // 시스템 내부용, 외부에 노출 안 함

    @Embedded
    private OrderNo orderNo;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "receiver.name", column = @Column(name = "receiver_name")),
            @AttributeOverride(name = "receiver.phone", column = @Column(name = "receiver_phone"))
    })
    private ShippingInfo shippingInfo;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_order_line", joinColumns = @JoinColumn(name = "order_id", comment = "주문ID"))
    // 밸류를 저장할 테이블 지정
    @OrderColumn(name = "line_seq", columnDefinition = "INT COMMENT '주문 항목 순서'")
    private List<OrderLine> orderLines;

    protected Order() {
    }

    /*
    팩토리 메서드
    1. 객체 생성에 의미 있는 이름과 통제권 부여.
    2. 생성 로직 캡슐화 : 초기값 설정, 유효성 검증을 내부 로직에 숨김.
    3. 불완전한 객체 생성 방지
    4. 반환 타입의 유연성
     */
    public static Order create(ShippingInfo shippingInfo, List<OrderLine> orderLines) {
        Order order = new Order();
        order.orderNo = OrderNo.generate();
        order.orderState = OrderState.PAYMENT_WAITING;
        order.shippingInfo = shippingInfo;
        order.orderLines = orderLines;
        return order;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }
}
