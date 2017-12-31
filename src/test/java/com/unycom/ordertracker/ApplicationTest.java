package com.unycom.ordertracker;

import com.unycom.ordertracker.dao.CustomerDAO;
import com.unycom.ordertracker.dao.OrderDAO;
import com.unycom.ordertracker.entity.Order;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:ordertracker-dispathcer-servlet.xml" })
public class ApplicationTest {

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private OrderDAO orderDAO;

	@Test
	public void testSize() {

		Assert.assertEquals(8, customerDAO.getCustomers().size());
	}

	@Test
	public void testCustomerCode() {

		List<Order> orders = orderDAO.getOrderDetails(16);
		for (Order order : orders) {
			Assert.assertEquals("DC2", order.getCustomer().getCode());
		}

	}

}