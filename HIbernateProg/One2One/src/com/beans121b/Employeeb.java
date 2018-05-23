package com.beans121b;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Employeeb {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)

	private int id;
	
	private String firstName;
	
	private String lastName;
	
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn
	private Addressb addressb;

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

	public Addressb getAddressb() {
		return addressb;
	}

	public void setAddressb(Addressb addressb) {
		this.addressb = addressb;
	} 
	
	
	
	
	
}
