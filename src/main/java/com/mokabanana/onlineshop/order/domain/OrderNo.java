package com.mokabanana.onlineshop.order.domain;

import com.mokabanana.onlineshop.common.utils.RandomCodeUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Embeddable
public record OrderNo(
        @Column(name = "order_no", length = 26, unique = true, comment = "주문번호")
        String number
) {

    public OrderNo {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("주문번호는 비어있을 수 없습니다.");
        }
    }

    public static OrderNo generate() {
        String datetime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        String random = RandomCodeUtils.randomAlphanumeric(4);
        return new OrderNo("ORD-" + datetime + "-" + random);
    }
}
