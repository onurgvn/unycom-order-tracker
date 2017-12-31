package com.unycom.ordertracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unycom.ordertracker.entity.Order;
import com.unycom.ordertracker.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/{custCode}")
    public String listOrders(Model model, @PathVariable("custCode") String custCode) {

        List<Order> orders = orderService.getOrders(custCode);
        model.addAttribute("orders", orders);

        return "orders/list";
    }

    @RequestMapping("/orderdetails/{orderId}")
    public String orderDetails(Model model, @PathVariable("orderId") int ordId) {

        List<Order> orders = orderService.getOrderDetails(ordId);
        model.addAttribute("orders", orders);

        return "orders/details";
    }
}