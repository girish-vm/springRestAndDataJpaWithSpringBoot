/**
 * 
 */
package com.myDemo.springRestAndDataJpaWithSpringBoot.jasperService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.myDemo.springRestAndDataJpaWithSpringBoot.constants.JaseperConstants;
import com.myDemo.springRestAndDataJpaWithSpringBoot.entity.Customer;
import com.myDemo.springRestAndDataJpaWithSpringBoot.repository.CustomerRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import static com.myDemo.springRestAndDataJpaWithSpringBoot.constants.JaseperConstants.*;
/**
 * @author gimanjun
 *
 */
@Service
public class jasperService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	JaseperConstants jaseperConstants;
	
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException
	{
		List<Customer>customer=customerRepository.findAll();
		
		File file=ResourceUtils.getFile("classpath:customer.jrxml");
		JasperReport jasperReport=JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(customer);
		Map<String,Object>params=new HashMap<String,Object>();
		params.put("innovatedBy", "girish");
		JasperPrint print=JasperFillManager.fillReport(jasperReport, params, dataSource);
		
		if(reportFormat.equalsIgnoreCase("html"))
		{
			JasperExportManager.exportReportToHtmlFile(print,jasperpath +"\\customer.html");
		}
		if(reportFormat.equalsIgnoreCase("pdf"))
		{
			JasperExportManager.exportReportToPdfFile(print, jasperpath+"\\customer.pdf");
			
		}
		
		
		return "success!!!report generated with path "+jasperpath;
	}
	
	
}
