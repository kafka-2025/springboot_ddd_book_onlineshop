package com.mokabanana.onlineshop.common.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public record ListRequest(int page, int size) {

    private static final int DEFAULT_SIZE = 20;
    private static final int MAX_SIZE = 100;

    public Pageable toPageable(Sort sort) {
        int normalizedPage = Math.max(page - 1, 0);
        int normalizedSize = (size <= 0)
                ? DEFAULT_SIZE
                : Math.min(size, MAX_SIZE);
        return PageRequest.of(normalizedPage, normalizedSize, sort);
    }
}
