package com.vtn.repository;

import com.vtn.model.oder.Order;
import com.vtn.model.oder.OrderDetail;
import com.vtn.model.oder.OrderStatus;

import com.vtn.model.oder.PaymentForm;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository {
    interface OrderProductRepository extends JpaRepository<Order, Integer> {
        @Query(value = "select * from [Order] where CustomerId=?1 ORDER BY CASE WHEN StatusId = '4' THEN 1 ELSE 2 END, StatusId,CreatedDate DESC", nativeQuery = true)
        Page<Order> findByCustomerId(int customerId, Pageable page);

        @Query(value = "select OrderId  from [Order]   where CustomerId=?1 and StatusId ='5'", nativeQuery = true)
        List<Integer> getListOrderId(int customerId);

        @Query(value = "update [Order] set StatusId=6  where OrderId =?1", nativeQuery = true)
        int cancelOrder(int orderId);

        Order findOrderByOrderId(int orderId);
    }

    interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
        List<OrderDetail> findByOrderId(int orderId);

        // @Query(value = "select Id  from [OrderDetail]   where OrderId=?1 and ProductId =2", nativeQuery = true)
        boolean existsOrderDetailByOrderIdAndProductId(int orderId, int product);
    }

    interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
        @Query(value = "select StatusDescrip from OrderStatus where StatusId  =?1", nativeQuery = true)
        String getStatusDescrip(int statusId);
    }

    interface PaymentForm extends JpaRepository<com.vtn.model.oder.PaymentForm, Integer> {
        @Query(value = "select Name from PaymentForm where id  =?1", nativeQuery = true)
        String getName(int id);
    }
}
