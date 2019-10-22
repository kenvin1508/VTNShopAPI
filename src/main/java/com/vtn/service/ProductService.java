package com.vtn.service;

import java.util.ArrayList;
import java.util.List;

import com.vtn.VtnShopUtil;
import com.vtn.model.*;
import com.vtn.model.oder.Order;
import com.vtn.model.product.PagingProduct;
import com.vtn.model.product.Product;
import com.vtn.model.product.ProductCategory;
import com.vtn.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vtn.repository.ProductRepository;
import com.vtn.repository.PromotionRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository proRes;
    @Autowired
    ProductRepository.ProductCategoryRepository pCateRes;
    @Autowired
    PromotionRepository promRes;
    @Autowired
    ProductRepository.ProductImageRepository proImaRes;
    @Autowired
    OrderRepository.OrderProductRepository ordProRep;
    @Autowired
    OrderRepository.OrderDetailRepository ordDetRep;

    public List<Product> findByCategoryId(PagingProduct paging, String baseUrl) {
        Sort sort = null;
        if (paging.getSort() == 0) {
            sort = Sort.by("PriceSale").descending();
        }
        if (paging.getSort() == 1) {
            sort = Sort.by("PriceSale").ascending();
        }
        if (paging.getSort() == 2) {
            sort = Sort.by("PercentSale").descending();
        }
        List<Product> currentPros = proRes.findByCategoryIdAndStatusTrue(paging.getCategoryId(), PageRequest.of(paging.getPage(), paging.getSize(), sort)).getContent();
        List<Product> newPros = new ArrayList<>();
        for (Product product : currentPros) {
            product.setProductImage(baseUrl + product.getProductImage());
            product.setProductImages(toProcessListImage(baseUrl, product.getProductId()));
            newPros.add(product);
        }
        return newPros;
    }

    public List<Homepage> getListHomepages(int page, int size, String baseUrl) {
        List<Homepage> homepages = new ArrayList<>();
        List<ProductCategory> categories = pCateRes.findAll();
        for (ProductCategory productCategory : categories) {
            List<Product> products = proRes
                    .findByCategoryIdAndStatusTrue(productCategory.getCategoryId(), PageRequest.of(page, size)).getContent();
            List<Product> newPros = new ArrayList<>();

            for (Product product : products) {
                product.setProductImage(baseUrl + product.getProductImage());
                product.setDescription("");
                product.setProductImages(toProcessListImage(baseUrl, product.getProductId()));
                newPros.add(product);
            }
            String promotionImage = baseUrl + promRes.getPromotionImage(productCategory.getPromotionId()); // Get Promotion image for each category
            int amountProduct = proRes.countAllByCategoryIdAndStatusTrue(productCategory.getCategoryId());// Get Amount product by ProductCategoryId
            homepages.add(new Homepage(productCategory.getCategoryId(), productCategory.getCategoryName(), promotionImage, amountProduct, newPros));
        }
        return homepages;
    }

    private List<String> toProcessListImage(String baseUrl, int productId) {
        List<String> productImages = proImaRes.getListProductImage(productId);
        List<String> productImages1 = new ArrayList<>();
        for (String imageURL : productImages) {
            productImages1.add(baseUrl + imageURL);
        }
        return productImages1;
    }

    public List<Promotion> getListPromotions(String baseUrl) {
        List<Promotion> currentPros = promRes.findAll();
        List<Promotion> newPros = new ArrayList<>();
        for (Promotion promotion : currentPros) {
            promotion.setPromotionImage(baseUrl + promotion.getPromotionImage());
            newPros.add(promotion);
        }
        return newPros;
    }

    public List<ProductCategory> getListCategories(String baseUrl) {

        List<ProductCategory> currentCates = pCateRes.findAll();
        List<ProductCategory> newCates = new ArrayList<>();
        for (ProductCategory productCates : currentCates) {
            productCates.setCategoryImage(baseUrl + productCates.getCategoryImage());
            newCates.add(productCates);
        }
        return newCates;
    }

    public List<OutOfStock> listIdOutOfStock(List<OutOfStock> listProductId) {
        List<OutOfStock> listOutOfStock = new ArrayList<>();
        for (OutOfStock outOfStock : listProductId) {
            int amount = proRes.getCurrentAmount(outOfStock.getProductId());
            if (amount == 0) {
                listOutOfStock.add(new OutOfStock(outOfStock.getProductId(), outOfStock.getCartId()));
            }
        }
        return listOutOfStock;
    }

    public List<String> getListProductName(String key, int page, int size) {
        return proRes.listProductNameByKeyWord(key, PageRequest.of(page, size)).getContent();
    }

    public List<Product> search(String key, int page, int size, int sort) {
        Sort sortt = null;
        if (sort == 0) {
            sortt = Sort.by("PriceSale").descending();
        }
        if (sort == 1) {
            sortt = Sort.by("PriceSale").ascending();
        }
        if (sort == 2) {
            sortt = Sort.by("PercentSale").descending();
        }
        List<Product> currentPros = proRes.findByProductNameContainsAndStatusTrue(key, PageRequest.of(page, size, sortt)).getContent();
        List<Product> newPros = new ArrayList<>();
        for (Product product : currentPros) {
            product.setProductImage(VtnShopUtil.getBaseUrl() + product.getProductImage());
            product.setProductImages(toProcessListImage(VtnShopUtil.getBaseUrl(), product.getProductId()));
            newPros.add(product);
        }
        return newPros;
    }

    public boolean checkBoughtOrNot(int customerId, int productId) {
        List<Integer> orderIds = ordProRep.getListOrderId(customerId);
        if (orderIds.size() != 0) {
            for (Integer orderId : orderIds) {
                if (ordDetRep.existsOrderDetailByOrderIdAndProductId(orderId, productId)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

}
