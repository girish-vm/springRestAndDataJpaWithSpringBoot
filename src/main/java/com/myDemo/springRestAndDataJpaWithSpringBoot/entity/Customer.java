/**
 * 
 */
package com.myDemo.springRestAndDataJpaWithSpringBoot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author gimanjun
 *
 */
@Entity
@Table(name="Customer")
public class Customer implements Serializable {
	private static final long serialVersionUID = -3009157732242241606L;
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id;
	 
	  @Column(name = "firstname")
	  private String firstName;
	 
	  @Column(name = "lastname")
	  private String lastName;
	 
	  protected Customer() {
	  }
	 
	  public Customer(String firstName, String lastName) {
	    this.firstName = firstName;
	    this.lastName = lastName;
	  }
	 
	  @Override
	  public String toString() {
	    return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
	  }
	}

