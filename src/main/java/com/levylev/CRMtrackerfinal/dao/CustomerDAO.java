package com.levylev.CRMtrackerfinal.dao;

import java.util.List;

import com.levylev.CRMtrackerfinal.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public Object saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
