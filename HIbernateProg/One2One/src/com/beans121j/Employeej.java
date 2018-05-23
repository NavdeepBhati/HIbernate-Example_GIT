package com.beans121j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;


@Entity
public class Employeej {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)

	private int id;
	
	private String firstName;
	
	private String lastName;
	
	
	@OneToOne
	@JoinTable(name="EMP_ADDR")  //Craete new table 
	private Addressj addressb;

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

	public Addressj getAddressb() {
		return addressb;
	}

	public void setAddressb(Addressj addressb) {
		this.addressb = addressb;
	} 
	
	
	
	
	
}
