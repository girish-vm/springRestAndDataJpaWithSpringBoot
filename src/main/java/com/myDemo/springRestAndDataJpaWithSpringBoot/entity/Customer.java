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
	  private Long id;
	 
	  @Column(name = "firstname")
	  private String firstName;
	 
	  @Column(name = "lastname")
	  private String lastName;
	 
	
	  public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	
	}

