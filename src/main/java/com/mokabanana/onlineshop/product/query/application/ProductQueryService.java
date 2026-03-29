package com.mokabanana.onlineshop.product.query.application;

import com.mokabanana.onlineshop.common.dto.ListRequest;
import com.mokabanana.onlineshop.common.dto.PageResponse;
import com.mokabanana.onlineshop.product.query.dao.ProductQueryDao;
import com.mokabanana.onlineshop.product.query.dto.ProductQueryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductQueryService {

    private final ProductQueryDao productQueryDao;

    public ProductQueryService(ProductQueryDao productQueryDao) {
        this.productQueryDao = productQueryDao;
    }

    public PageResponse<ProductQueryResponse> getList(ListRequest listRequest) {
        Pageable pageable = listRequest.toPageable(
                Sort.by(Sort.Direction.DESC, "id")
        );
        Page<ProductQueryResponse> productPage = productQueryDao.findAll(pageable);
        return PageResponse.from(productPage);
    }
}
