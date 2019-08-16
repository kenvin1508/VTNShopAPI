package com.vtn.service;

import com.vtn.VtnShopUtil;
import com.vtn.controller.ProductController;
import com.vtn.model.address.Address;
import com.vtn.model.oder.Order;
import com.vtn.model.oder.OrderDetail;
import com.vtn.model.oder.OrderTemp;
import com.vtn.model.product.Product;
import com.vtn.model.product.ProductTemp;
import com.vtn.repository.AddressRepository;
import com.vtn.repository.OrderRepository;
import com.vtn.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository.OrderProductRepository ordProRep;
    @Autowired
    OrderRepository.OrderDetailRepository ordDetRep;
    @Autowired
    OrderRepository.OrderStatusRepository ordStaRep;
    @Autowired
    OrderRepository.PaymentForm payForRep;
    @Autowired
    ProductRepository proRep;
    @Autowired
    AddressRepository.CustomerAdressRepository addRep;


    private Order insertOrder(OrderTemp orderTemp) {
        Order orderSaved = new Order();
        orderSaved.setAddressId(orderTemp.getAddressId());
        orderSaved.setCreatedDate(orderTemp.getCreatedDate());
        orderSaved.setCustomerId(orderTemp.getCustomerId());
        orderSaved.setPaymentFormId(orderTemp.getPaymentFormId());
        orderSaved.setPhone(orderTemp.getPhone());
        orderSaved.setNote(orderTemp.getNote());
        orderSaved.setStatusId(orderTemp.getStatusId());
        orderSaved.setTotal(orderTemp.getTotal());
        ordProRep.save(orderSaved);
        return orderSaved;
    }

    public List<ProductTemp> insertOrderDetail(OrderTemp orderTemp) {
        try {
            List<ProductTemp> productTemps = toProcessAmount(orderTemp.getProducts());
            if (productTemps.size() != 0) {
                return productTemps;
            } else {
                Order orderSaved = insertOrder(orderTemp);
                for (ProductTemp product : orderTemp.getProducts()) {
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setOrderId(orderSaved.getOrderId());
                    orderDetail.setProductId(product.getProductId());
                    orderDetail.setPriceSale(product.getPriceSale());
                    orderDetail.setAmount(product.getAmount());
                    orderDetail.setTotal(product.getTotal());
                    orderDetail.setCreatedDate(orderSaved.getCreatedDate());
                    ordDetRep.save(orderDetail);
                }
                return productTemps;
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    private List<ProductTemp> toProcessAmount(ArrayList<ProductTemp> products) {
        List<ProductTemp> productTemps = new ArrayList<>();
        for (ProductTemp productTemp : products) {
            int currentAmount = proRep.getCurrentAmount(productTemp.getProductId());
            int productAmount = Integer.parseInt(productTemp.getAmount());
            if (productAmount > currentAmount) {
                productTemps.add(productTemp);
            }
        }
        if (productTemps.size() != 0) {
            return productTemps;
        } else {
            for (ProductTemp productTemp : products) {
                int currentAmount = proRep.getCurrentAmount(productTemp.getProductId());
                int newAmount = currentAmount - Integer.parseInt(productTemp.getAmount());
                Product product = proRep.findProductByProductId(productTemp.getProductId());
                product.setAmount(newAmount + "");
                proRep.save(product);
            }
        }
        return productTemps;
    }

    public List<OrderTemp> getListOrders(int customerId, int page, int size) {
        List<Order> orders = ordProRep.findByCustomerId(customerId, PageRequest.of(page, size)).getContent();
        List<OrderTemp> orderTemps = new ArrayList<>();
        for (Order order : orders) {
            String orderStatus = ordStaRep.getStatusDescrip(order.getStatusId());
            String createdDate = VtnShopUtil.formatDate(order.getCreatedDate());
            String total = order.getTotal();
            int orderId = order.getOrderId();
            Address address = addRep.findAddressByAddressId(order.getAddressId());
            String phone = address.getPhone();
            String customerName = address.getName();
            String addressDescip = address.getAddressDescrip();
            String paymentFormName = payForRep.getName(order.getPaymentFormId());
            OrderTemp orderTemp = new OrderTemp(orderId, createdDate, orderStatus, addressDescip, phone, customerName, total, paymentFormName);
            orderTemps.add(orderTemp);
        }
        return orderTemps;
    }

    public List<ProductTemp> getListOrdersDetail(int orderId) {
        List<OrderDetail> orderDetails = ordDetRep.findByOrderId(orderId);
        List<ProductTemp> productTemps = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetails) {
            int productId = orderDetail.getProductId();
            String priceSale = orderDetail.getPriceSale();
            String amount = orderDetail.getAmount();
            String total = orderDetail.getTotal();
            Product product = proRep.findProductByProductId(orderDetail.getProductId());
            product.setProductImage(VtnShopUtil.getBaseUrl() + product.getProductImage());
            ProductTemp productTemp = new ProductTemp(productId, amount, priceSale, total, product);
            productTemps.add(productTemp);
        }
        return productTemps;
    }

    public boolean cancelOrder(int orderId) {
        try {
            Order order = ordProRep.findOrderByOrderId(orderId);
            order.setStatusId(6);
            ordProRep.save(order);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
