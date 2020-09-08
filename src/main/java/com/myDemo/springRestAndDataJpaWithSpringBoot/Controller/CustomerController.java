/**
 * 
 */
package com.myDemo.springRestAndDataJpaWithSpringBoot.Controller;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.myDemo.springRestAndDataJpaWithSpringBoot.Exception.NameNotFoundException;
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
    
    @Autowired
    RestTemplate restTemplate;
    
	@PostMapping(value="/api/saveCustomer")
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
	@GetMapping("/api/customer/{name}")
	//@Cacheable("custs")
	@CrossOrigin(origins="http://localhost:4200")
	 public List<Customer> getCustomer(@PathVariable String name)throws NameNotFoundException {
	  //List<Customer> customer = customerResource.getAllCustomer();
		
		List<Customer> customer=null;
		if(name.equalsIgnoreCase("db")) {
	  customer=customerService.retrieveCustomers();
		}
		if(name.equalsIgnoreCase("jasper")) {
			  customer=com.myDemo.springRestAndDataJpaWithSpringBoot.jasperService.jasperService.returnMe();
				}
		else {
			throw new NameNotFoundException("name is incorect!!");
		}
	  return customer;
	 }
	@GetMapping("/api/report/{format}")
	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException
	{
		jasperService.exportReport(format);
		
		return "submit";
		
	}
	
	@RequestMapping(value = "/t/products")
	   public String getProductList() {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      
	      return restTemplate.exchange("http://localhost:8763/meService", HttpMethod.GET, entity, String.class).getBody();
	     // return restTemplate.exchange("
	         //http://localhost:8763/meService", HttpMethod.GET, entity, String.class).getBody();
	   }
}

