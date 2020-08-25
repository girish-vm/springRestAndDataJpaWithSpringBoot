/**
 * 
 */
package com.myDemo.springRestAndDataJpaWithSpringBoot.service;

import java.util.List;

import com.myDemo.springRestAndDataJpaWithSpringBoot.entity.Book;
import com.myDemo.springRestAndDataJpaWithSpringBoot.entity.Customer;

/**
 * @author gimanjun
 *
 */
public interface CustomerService {

	 void CustomerSave(Customer customer);

	void save(List<Customer> asList);
	
	public List<Customer> retrieveCustomers();
	
}
