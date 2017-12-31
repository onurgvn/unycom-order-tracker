package com.unycom.ordertracker.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUST_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "confirmation_date")
    private Date confirmationDate;


    @Column(name = "completion_date")
    private Date completionDate;

    @Column(name = "product")
    private String product;

    @Column(name = "original_price")
    private int originalPrice;

    @Column(name = "status")
    private Status status;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "customer_code")
    private Customer customer;

    @Column(name = "last_price")
    private int lastPrice;


    public Order() {

    }

    public Order(Date orderDate, Date confirmationDate, Date completionDate, String product, int originalPrice,
                 Status status, Customer customer, int lastPrice) {
        this.orderDate = orderDate;
        this.confirmationDate = confirmationDate;
        this.completionDate = completionDate;
        this.product = product;
        this.originalPrice = originalPrice;
        this.status = status;
        this.customer = customer;
        this.lastPrice = lastPrice;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public Date getOrderDate() {
        return orderDate;
    }


    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }


    public Date getConfirmationDate() {
        return confirmationDate;
    }


    public void setConfirmationDate(Date confirmationDate) {
        this.confirmationDate = confirmationDate;
    }


    public Date getCompletionDate() {
        return completionDate;
    }


    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }


    public String getProduct() {
        return product;
    }


    public void setProduct(String product) {
        this.product = product;
    }


    public int getOriginalPrice() {
        return originalPrice;
    }


    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }


    public Status getStatus() {
        return status;
    }


    public void setStatus(Status status) {
        this.status = status;
    }


    public Customer getCustomer() {
        return customer;
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public int getLastPrice() {
        return lastPrice;
    }


    public void setLastPrice(int lastPrice) {
        this.lastPrice = lastPrice;
    }

    

	@Override
    public String toString() {
        return "Order [id=" + id + ", orderDate=" + orderDate + ", confirmationDate=" + confirmationDate
                + ", completionDate=" + completionDate + ", product=" + product + ", originalPrice=" + originalPrice
                + ", status=" + status + "]";
    }

}