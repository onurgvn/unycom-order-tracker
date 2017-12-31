package com.unycom.ordertracker.service;

import java.util.List;

import com.unycom.ordertracker.entity.Order;

public interface OrderService {

    List<Order> getOrders(String custCode);

    List<Order> getOrderDetails(int ordNum);
}