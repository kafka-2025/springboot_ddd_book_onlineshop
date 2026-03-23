package com.mokabanana.onlineshop.order.domain;

import com.mokabanana.onlineshop.common.domain.Address;
import jakarta.persistence.Embeddable;

@Embeddable
public record ShippingInfo(Receiver receiver, Address address) {
}
