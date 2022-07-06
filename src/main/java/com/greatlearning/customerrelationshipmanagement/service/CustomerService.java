package com.greatlearning.customerrelationshipmanagement.service;

import java.util.List;
import com.greatlearning.customerrelationshipmanagement.model.Customer;

public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(long customerId);

	public void save(Customer customer);

	public void delete(long customerId);

}
