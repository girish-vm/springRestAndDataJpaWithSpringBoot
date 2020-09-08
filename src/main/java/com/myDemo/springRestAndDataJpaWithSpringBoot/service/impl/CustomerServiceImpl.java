/**
 * 
 */
package com.myDemo.springRestAndDataJpaWithSpringBoot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myDemo.springRestAndDataJpaWithSpringBoot.entity.Customer;
import com.myDemo.springRestAndDataJpaWithSpringBoot.repository.CustomerRepository;
import com.myDemo.springRestAndDataJpaWithSpringBoot.service.CustomerService;

/**
 * @author gimanjun
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	
	
	
	@Override
	public void CustomerSave(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}

	@Override
	public void save(List<Customer> asList) {
		// TODO Auto-generated method stub
		customerRepository.saveAll(asList);
	}

	@Override
	public List<Customer> retrieveCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customer = customerRepository.findAll();
		return customer;
	}

}
