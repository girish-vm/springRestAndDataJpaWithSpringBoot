/**
 * 
 */
package com.myDemo.springRestAndDataJpaWithSpringBoot.entity;

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
@Table(name="Book")
public class Book {

	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name="Book_Name")
	 private String bName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public Book(Long id, String bName) {
		super();
		this.id = id;
		this.bName = bName;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bName=" + bName + "]";
	}
	 
	 
	 
	 
	
}
