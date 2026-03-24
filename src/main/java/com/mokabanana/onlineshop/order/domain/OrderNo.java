package com.mokabanana.onlineshop.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

@Embeddable
public record OrderNo(
        @Column(name = "order_no", length = 26, unique = true, comment = "주문번호")
        String number
) implements Serializable {

    public OrderNo {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("주문번호는 비어있을 수 없습니다.");
        }
    }

    public static OrderNo generate() {
        String datetime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        String random = randomAlphanumeric(4);
        return new OrderNo("ORD-" + datetime + "-" + random);
    }

    private static String randomAlphanumeric(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
