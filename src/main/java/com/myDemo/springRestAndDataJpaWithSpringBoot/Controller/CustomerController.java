/**
 * 
 */
package com.myDemo.springRestAndDataJpaWithSpringBoot.Controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myDemo.springRestAndDataJpaWithSpringBoot.entity.Customer;
import com.myDemo.springRestAndDataJpaWithSpringBoot.service.CustomerService;

/**
 * @author gimanjun
 *
 */
@RestController
@RequestMapping("/customerController")
public class CustomerController {
    @Autowired
	CustomerService customerService;
    
    
	@PostMapping(value="/saveCustomer")
    public String customerSave(Customer customer)
    {
		customerService.save(Arrays.asList(new Customer("girish", "manjunath"), 
                new Customer("Adam", "Johnson"),
                new Customer("Kim", "Smith"),
                new Customer("David", "Williams"),
                new Customer("Peter", "Davis")));

return "Done";
    	
    }
    
}
