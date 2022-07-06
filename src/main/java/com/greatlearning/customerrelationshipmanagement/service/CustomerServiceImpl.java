package com.greatlearning.customerrelationshipmanagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.greatlearning.customerrelationshipmanagement.dao.CustomerDAO;
import com.greatlearning.customerrelationshipmanagement.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public List<Customer> findAll() {
		return customerDAO.findAll();
	}

	@Override
	public Customer findById(long customerId) {

		return customerDAO.findById(customerId);
	}

	@Override
	public void save(Customer customer) {

		customerDAO.save(customer);

	}

	@Override
	public void delete(long customerId) {
		customerDAO.delete(customerId);

	}
}
