package com.vtn.repository;

import com.vtn.model.product.ProductCategory;
import com.vtn.model.product.ProductFavorite;
import com.vtn.model.product.ProductImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vtn.model.product.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findByCategoryIdAndStatusTrue(int id, Pageable page);

    Product findProductByProductId(int productId);

    int countAllByCategoryId(int productCategoryId);

    Page<Product> findByProductNameLikeAndStatusTrue(String key, Pageable pageable);

    @Query(value = "select ProductName from Product where dbo.fChuyenCoDauThanhKhongDau(ProductName) LIKE CONCAT(N'%',dbo.fChuyenCoDauThanhKhongDau(:key),'%')", nativeQuery = true)
    List<String> listProductNameByKeyWord(@Param("key") String key);

    @Query(value = "select * from Product where dbo.fChuyenCoDauThanhKhongDau(ProductName) LIKE CONCAT(N'%',dbo.fChuyenCoDauThanhKhongDau(:key),'%')", nativeQuery = true)
    Page<Product> findByProductNameContainsAndStatusTrue(String key, Pageable page);

    @Query(value = "select Amount from Product where ProductId=?1", nativeQuery = true)
    int getCurrentAmount(int productId);


    interface ProductFavoriteRepository extends JpaRepository<ProductFavorite, Integer> {
        ProductFavorite findByProductIdAndCustomerIdAndStatusTrue(int productId, int customerId);

        ProductFavorite findByProductIdAndCustomerIdAndStatusFalse(int productId, int customerId);

        ProductFavorite findProductFavoriteByFavoriteId(int favoriteId);

        boolean existsByProductIdAndCustomerId(int productId, int customerId);

        Page<ProductFavorite> findByCustomerIdAndStatusTrue(int id, Pageable pageable);

    }

    interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    }

    interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {
        @Query(value = "select ImageURL from ProductImage where ProductId=?1", nativeQuery = true)
        List<String> getListProductImage(int productId);
    }
}
