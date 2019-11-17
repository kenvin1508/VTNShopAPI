package com.vtn.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.vtn.model.Promotion;
import org.springframework.data.jpa.repository.Query;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
    @Query(value = "SELECT PromotionImage FROM vtnshop1.dbo.Promotion WHERE PromotionId =?1", nativeQuery = true)
    String getPromotionImage(int promotionId);

    @Query(value = "SELECT * FROM Promotion WHERE PromotionCode=?1 AND StartTime<=?2 AND EndTime>?2 AND CategoryId=?3", nativeQuery = true)
    Promotion getPromotionDiscount(String promotionCode, String time, int categoryId);
}
