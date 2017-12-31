package com.unycom.ordertracker.dao;

import java.util.List;

import com.unycom.ordertracker.entity.Customer;

public interface CustomerDAO {
    List<Customer> getCustomers();
}