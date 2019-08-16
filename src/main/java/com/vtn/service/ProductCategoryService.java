package com.vtn.service;

import java.util.List;

import com.vtn.repository.ProductRepository;
import com.vtn.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtn.model.product.ProductCategory;


@Service
public class ProductCategoryService {
    @Autowired
    ProductRepository.ProductCategoryRepository pCateRes;
    @Autowired
    PromotionRepository promRes;

    public List<ProductCategory> findAll() {
        return pCateRes.findAll();
    }

}
