package com.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Employee {

	@Id
	private int id;  
	
	//@NotNull
	private String firstName;  
	
	//@NotNull
	private String lastName;
	
	
	@OneToOne(
			fetch=FetchType.EAGER,    //Adress will be loaded lazily
			optional=false)				//So if the get statement is within the session than its okay 
									// else it will give Lazy initialization exception error
										// to solve it make it eager.
	
	
	@PrimaryKeyJoinColumn 				// pk &fk are same for employee table 
	private Address address;
	
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
}
