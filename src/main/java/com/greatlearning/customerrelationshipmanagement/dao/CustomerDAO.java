package com.greatlearning.customerrelationshipmanagement.dao;

import java.util.List;
import com.greatlearning.customerrelationshipmanagement.model.Customer;

public interface CustomerDAO {

	public List<Customer> findAll();

	public Customer findById(long customerId);

	public void save(Customer customer);

	public void delete(long customerId);
}
