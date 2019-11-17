package com.vtn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.vtn.VtnShopUtil;
import com.vtn.model.*;
import com.vtn.model.product.PagingProduct;
import com.vtn.model.product.Product;
import com.vtn.model.product.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.vtn.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService proSer;

    @PostMapping("/list")
    List<Product> getListProducts(@RequestBody PagingProduct paging) {
        return proSer.findByCategoryId(paging, VtnShopUtil.getBaseUrl());
    }

    @GetMapping("/homepage")
    List<Homepage> getListHomepages(@RequestParam int page, @RequestParam int size) {
        return proSer.getListHomepages(page, size, VtnShopUtil.getBaseUrl());
    }

    @GetMapping("/promotion")
    List<Promotion> getListPromotions() {
        return proSer.getListPromotions(VtnShopUtil.getBaseUrl());
    }

    @GetMapping("/category")
    List<ProductCategory> getListCategories() {
        return proSer.getListCategories(VtnShopUtil.getBaseUrl());

    }


    @PostMapping("/listoutofstock")
    public List<OutOfStock> listIdOutOfStock(@RequestBody List<OutOfStock> outOfStocks) {
        return proSer.listIdOutOfStock(outOfStocks);
    }


    @GetMapping("/search")
    public List<Product> search(@RequestParam String key, @RequestParam int page, @RequestParam int size, @RequestParam int sort) {
        System.out.println(key);
        return proSer.search(key, page, size, sort);
    }

    @GetMapping("/searchname")
    public List<String> searchName(@RequestParam String key, @RequestParam int page, @RequestParam int size) {
        System.out.println(key);
        return proSer.getListProductName(key, page, size);
    }

    @GetMapping("/bought")
    public boolean checkBoughtorNot(@RequestParam int customerId, @RequestParam int productId) {
        return proSer.checkBoughtOrNot(customerId, productId);
    }

//    @PostMapping("/discount")
//    public Promotion getPromotionDiscount(@RequestBody Cart cart) {
//        return proSer.getPromotionDiscount(cart);
//    }

    @PostMapping("/discount")
    public ResponseEntity<Promotion> getPromotionDiscount(@RequestBody Cart cart) {
        Promotion promotion = proSer.getPromotionDiscount(cart);
        if (promotion != null) {
            return new ResponseEntity<>(promotion, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
