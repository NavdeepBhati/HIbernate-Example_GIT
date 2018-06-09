package com.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Address {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull
	private String zipcode;

	@NotNull
	private String city;
	

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int id,String zipcode, String city) {
		super();
	
		this.id=id;
		this.zipcode = zipcode;
		this.city = city;
	}
	public Address(String zipcode, String city) {
		this.zipcode = zipcode;
		this.city = city;
		}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
