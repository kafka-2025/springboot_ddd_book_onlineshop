package com.mokabanana.onlineshop.common.domain;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public record Money(BigDecimal price, String currency) {

    public static Money won(long price) {
        return new Money(BigDecimal.valueOf(price), "KRW");
    }

    public Money multiply(int quantity) {
        return new Money(price.multiply(new BigDecimal(quantity)), currency);
    }
}
