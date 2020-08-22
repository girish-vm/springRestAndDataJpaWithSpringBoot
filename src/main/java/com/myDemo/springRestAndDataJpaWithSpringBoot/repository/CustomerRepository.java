/**
 * 
 */
package com.myDemo.springRestAndDataJpaWithSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myDemo.springRestAndDataJpaWithSpringBoot.entity.Customer;

/**
 * @author gimanjun
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
