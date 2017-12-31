package com.unycom.ordertracker.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "active")
    private boolean active;

    @Column(name = "type")
    private CustomerType type;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
    private List<Order> orders;

    public Customer() {

    }

    public Customer(String code, String name, String location, Date registrationDate, boolean active, CustomerType type) {
        this.code = code;
        this.name = name;
        this.location = location;
        this.registrationDate = registrationDate;
        this.active = active;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer [code=" + code + ", name=" + name + ", location=" + location + ", registrationDate="
                + registrationDate + ", active=" + active + ", type=" + type + "]";
    }

    public void add(Order tempOrder) {
        if (orders == null) {
            orders = new ArrayList<>();

        }
        orders.add(tempOrder);
        tempOrder.setCustomer(this);

    }

}