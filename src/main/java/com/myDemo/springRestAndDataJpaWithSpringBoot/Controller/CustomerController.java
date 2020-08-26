/**
 * 
 */
package com.myDemo.springRestAndDataJpaWithSpringBoot.Controller;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myDemo.springRestAndDataJpaWithSpringBoot.Resource.CustomerResource;
import com.myDemo.springRestAndDataJpaWithSpringBoot.entity.Customer;
import com.myDemo.springRestAndDataJpaWithSpringBoot.jasperService.jasperService;
import com.myDemo.springRestAndDataJpaWithSpringBoot.service.CustomerService;

import net.sf.jasperreports.engine.JRException;

/**
 * @author gimanjun
 *
 */
@RestController
@RequestMapping("/customerController")
public class CustomerController {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
	CustomerService customerService;
    
    @Autowired
    CustomerResource customerResource;
    
    @Autowired
    jasperService jasperService;
    
    
    
	@PostMapping(value="/saveCustomer")
    public void customerSave(@RequestBody Customer customer)
    {
		if(Objects.isNull(customer))
		{
			log.info("object is null!!",customer);
		}
		else
		{
		customerService.CustomerSave(customer);
		 
		}
		log.info("customer Saved Successfully",customer);
    	
    }
	@GetMapping("/api/customer")
	@Cacheable("custs")
	@CrossOrigin(origins="http://localhost:4200")
	 public List<Customer> getCustomer() {
	  List<Customer> customer = customerResource.getAllCustomer();
	  return customer;
	 }
	@GetMapping("/report/{format}")
	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException
	{
		jasperService.exportReport(format);
		
		return "success";
		
	}
	
}
