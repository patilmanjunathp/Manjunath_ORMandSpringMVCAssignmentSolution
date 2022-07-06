package com.greatlearning.customerrelationshipmanagement.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.customerrelationshipmanagement.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	public CustomerDAOImpl(SessionFactory sessionFactory) {

		super();
		this.sessionFactory = sessionFactory;
		try {
			this.session = this.sessionFactory.getCurrentSession();

		} catch (HibernateException e) {

			this.session = this.sessionFactory.openSession();
		}
	}

	@Override
	public List<Customer> findAll() {

		List<Customer> customers = this.session.createQuery("from Customer").list();
		return customers;
	}

	@Override
	public Customer findById(long customerId) {

		Customer customer = this.session.get(Customer.class, customerId);
		return customer;
	}

	@Override
	@Transactional
	public void save(Customer customer) {

		Transaction tx = this.session.beginTransaction();
		this.session.saveOrUpdate(customer);
		tx.commit();
	}

	@Override
	@Transactional
	public void delete(long customerId) {

		Transaction tx = this.session.beginTransaction();
		Customer customer = this.session.get(Customer.class, customerId);
		this.session.delete(customer);
		tx.commit();
	}

}
