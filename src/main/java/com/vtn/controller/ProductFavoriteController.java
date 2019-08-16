package com.vtn.controller;

import com.vtn.model.product.ProductFavorite;
import com.vtn.service.ProductFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorite")
public class ProductFavoriteController {
    @Autowired
    ProductFavoriteService proFavSer;

    @GetMapping("/get")
    public List<ProductFavorite> getListFavorite(@RequestParam int customerId, @RequestParam int page, @RequestParam int size) {
        return proFavSer.getListFavorite(customerId, page, size);
    }

    @GetMapping("/check")
    public int checkExist(@RequestParam int customerId, @RequestParam int productId) {
        ProductFavorite productFavorite = proFavSer.checkExist(customerId, productId);
        if (productFavorite == null) {
            return -1;
        } else {
            return productFavorite.getFavoriteId();
        }
    }

    @PostMapping("/insert")
    public int insert(@RequestParam int productId, @RequestParam int customerId) {
        ProductFavorite productFavorite = new ProductFavorite();
        productFavorite.setProductId(productId);
        productFavorite.setCustomerID(customerId);
        productFavorite.setStatus(true);
        return proFavSer.insert(productFavorite);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int favoriteId) {
        if (proFavSer.delete(favoriteId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
