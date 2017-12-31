package com.unycom.ordertracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unycom.ordertracker.dao.OrderDAO;
import com.unycom.ordertracker.entity.Order;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Override
    @Transactional
    public List<Order> getOrders(String custCode) {

        return orderDAO.getOrders(custCode);
    }

    @Override
    @Transactional
    public List<Order> getOrderDetails(int ordNum) {

        List<Order> orderList = orderDAO.getOrderDetails(ordNum);

        for (Order order : orderList) {
            if (order.getOriginalPrice() < 1000)
                order.setLastPrice(order.getOriginalPrice() * 99 / 100);
            else if (order.getOriginalPrice() < 5000)
                order.setLastPrice(order.getOriginalPrice() * 98 / 100);
            else if (order.getOriginalPrice() < 20000)
                order.setLastPrice(order.getOriginalPrice() * 95 / 100);
            else if (order.getOriginalPrice() >= 20000)
                order.setLastPrice(order.getOriginalPrice() * 90 / 100);
            else
                order.setLastPrice(order.getOriginalPrice());
        }
        return orderList;
    }

}