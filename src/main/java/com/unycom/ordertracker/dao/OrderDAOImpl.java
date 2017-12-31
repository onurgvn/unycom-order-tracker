package com.unycom.ordertracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unycom.ordertracker.entity.Customer;
import com.unycom.ordertracker.entity.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Order> getOrders(String custCode) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Customer> query = currentSession.createQuery("from Customer where code like ?1", Customer.class);
		query.setParameter(1, "%"+custCode+"%");

		Customer customer = query.getSingleResult();

		return customer.getOrders();

        /*  //LAZY loading
        Query<Order> theQuery = currentSession.createQuery("from Order where customer.code like ?1", Order.class);
        theQuery.setParameter(1, "%"+custCode+"%");

        List<Order> orders = theQuery.getResultList();

        return orders;
        */
	}

	@Override
	@Transactional
	public List<Order> getOrderDetails(int ordNum) {

		Session currrentSession = sessionFactory.getCurrentSession();

		Query<Order> query = currrentSession.createQuery("from Order where id = :ordId", Order.class);
		query.setParameter("ordId", ordNum);

		return query.getResultList();
	}

}