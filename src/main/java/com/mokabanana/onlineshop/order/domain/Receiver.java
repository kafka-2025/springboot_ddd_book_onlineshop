package com.mokabanana.onlineshop.order.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public record Receiver(String name, String phone) {
}
