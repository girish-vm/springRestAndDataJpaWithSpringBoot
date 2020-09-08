package com.myDemo.springRestAndDataJpaWithSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@EnableEurekaServer
@ComponentScan(basePackages = "com.myDemo.springRestAndDataJpaWithSpringBoot")
public class SpringRestAndDataJpaWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestAndDataJpaWithSpringBootApplication.class, args);
	}
	@Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
}
