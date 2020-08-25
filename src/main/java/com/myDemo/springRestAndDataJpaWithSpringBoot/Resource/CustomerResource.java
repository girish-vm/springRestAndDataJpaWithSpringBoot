/**
 * 
 */
package com.myDemo.springRestAndDataJpaWithSpringBoot.Resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.myDemo.springRestAndDataJpaWithSpringBoot.entity.Customer;
import com.myDemo.springRestAndDataJpaWithSpringBoot.repository.CustomerRepository;


/**
 * @author gimanjun
 *
 */
@Component

public class CustomerResource {

	@Autowired
	CustomerRepository customerRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerResource.class);
	@Cacheable(value="custs")
	public List<Customer> getAllCustomer()
	{
		logger.info("getting data from db once!!!!");
	return	customerRepository.findAll();
	}
	
	 	
}
