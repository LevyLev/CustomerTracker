package com.levylev.CRMtrackerfinal.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.levylev.CRMtrackerfinal.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	//field for entity manager creat automat de spring boot
	private EntityManager entityManager;
	
	@Autowired
	public CustomerDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	@Override
	public List<Customer> getCustomers() {

		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",
																Customer.class);
		
		//execute query and get result list
		List<Customer>customers=theQuery.getResultList();
		
		//return the results
		return customers;
		
	}

	@Override
	public Object saveCustomer(Customer theCustomer) {
		//get the current hibernate action
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theCustomer);
		return null;
	}

	@Override
	public Customer getCustomer(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Customer theCustomer = currentSession.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}
}
