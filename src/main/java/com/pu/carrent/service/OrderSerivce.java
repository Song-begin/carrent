package com.pu.carrent.service;

import com.pu.carrent.entity.Order;

import java.util.List;

public interface OrderSerivce {

    List<Order> findAllOrders();

    List<Order> findOrdersNotPaid();

    Order findOrderById(Integer orderId);

    int addOrder(Order record);

    int changeOrder(Order record);

    int deleteOrderById(Integer orderId);

    List<Order> findOrdersByUserId(Integer userId);
}
