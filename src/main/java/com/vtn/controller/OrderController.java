package com.vtn.controller;

import com.vtn.model.oder.Order;
import com.vtn.model.oder.OrderDetail;
import com.vtn.model.oder.OrderTemp;
import com.vtn.model.product.ProductTemp;
import com.vtn.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService ordSer;

    @PostMapping("/insert")
    public ResponseEntity<List<ProductTemp>> insertOrder(@RequestBody OrderTemp orderTemp) {
        List<ProductTemp> productTemps = ordSer.insertOrderDetail(orderTemp);
        if (productTemps.size() != 0) {
            return new ResponseEntity<>(productTemps, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/getorders")
    public List<OrderTemp> getListOrders(int id, int page, int size) {
        return ordSer.getListOrders(id, page, size);
    }

    @GetMapping("/getorderdetail")
    public List<ProductTemp> getOrderDetail(int id) {
        return ordSer.getListOrdersDetail(id);
    }

    @GetMapping("/cancel")
    public ResponseEntity<?> cancelOrder(@RequestParam int id) {
        if (ordSer.cancelOrder(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
