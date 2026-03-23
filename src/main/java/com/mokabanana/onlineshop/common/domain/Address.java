package com.mokabanana.onlineshop.common.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public record Address(String zipCode, String address1, String address2) {
}
