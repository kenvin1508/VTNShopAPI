package com.vtn.service;

import com.vtn.VtnShopUtil;
import com.vtn.model.product.Product;
import com.vtn.model.product.ProductFavorite;

import com.vtn.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductFavoriteService {
    @Autowired
    ProductRepository.ProductFavoriteRepository proFavRes;
    @Autowired
    ProductRepository proRep;
    @Autowired
    ProductRepository.ProductImageRepository proImaRes;


    public List<ProductFavorite> getListFavorite(int customerId, int page, int size) {
        List<ProductFavorite> productFavorites = proFavRes.findByCustomerIdAndStatusTrue(customerId, PageRequest.of(page, size)).getContent();
        List<ProductFavorite> productFavorites1 = new ArrayList<>();
        for (ProductFavorite favorite : productFavorites) {
            Product product = proRep.findProductByProductId(favorite.getProductId());
            product.setProductImage(VtnShopUtil.getBaseUrl() + product.getProductImage());
            product.setProductImages(toProcessListImage(VtnShopUtil.getBaseUrl(), product.getProductId()));
            favorite.setProduct(product);
            productFavorites1.add(favorite);
        }
        return productFavorites1;
    }

    private List<String> toProcessListImage(String baseUrl, int productId) {
        List<String> productImages = proImaRes.getListProductImage(productId);
        List<String> productImages1 = new ArrayList<>();
        for (String imageURL : productImages) {
            productImages1.add(baseUrl + imageURL);
        }
        return productImages1;
    }

    public ProductFavorite checkExist(int customerId, int productId) {
        return proFavRes.findByProductIdAndCustomerIdAndStatusTrue(productId, customerId);
    }

    public int insert(ProductFavorite productFavorite) {
        int productId = productFavorite.getProductId();
        int customerId = productFavorite.getCustomerID();
        if (proFavRes.existsByProductIdAndCustomerId(productId, customerId)) {
            ProductFavorite productFavorite1 =
                    proFavRes.findByProductIdAndCustomerIdAndStatusFalse(productId, customerId);
            productFavorite1.setStatus(true);
            return proFavRes.save(productFavorite1).getFavoriteId();
        }
        return proFavRes.save(productFavorite).getFavoriteId();
    }

    public boolean delete(int favoriteId) {
        try {
            ProductFavorite productFavorite = proFavRes.findProductFavoriteByFavoriteId(favoriteId);
            productFavorite.setStatus(false);
            proFavRes.save(productFavorite);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
