package com.unycom.ordertracker.dao;

import java.util.List;

import com.unycom.ordertracker.entity.Order;

public interface OrderDAO {

	List<Order> getOrders(String custCode);

	List<Order> getOrderDetails(int ordNum);
}