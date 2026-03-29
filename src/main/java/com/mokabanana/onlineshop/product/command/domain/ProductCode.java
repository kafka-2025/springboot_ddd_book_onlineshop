package com.mokabanana.onlineshop.product.command.domain;

import com.mokabanana.onlineshop.common.utils.RandomCodeUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Embeddable
public record ProductCode(
        @Column(name = "product_code", length = 20, unique = true, comment = "상품코드")
        String code
) {

    public ProductCode {
        if(code == null || code.isBlank()) {
            throw new IllegalArgumentException("상품코드는 비어있을 수 없습니다.");
        }
    }

    public static ProductCode generate() {
        String datetime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
        String random = RandomCodeUtils.randomAlphanumeric(3);
        return new ProductCode("PRD-" + datetime + random);
    }
}
