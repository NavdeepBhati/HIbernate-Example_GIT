package com.beans121b;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Addressb {

	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private int AddId;

	
	
	private String city;
	
	private String area;
	
	@OneToOne(mappedBy="addressb")
	private Employeeb employeeb;

	public int getAddId() {
		return AddId;
	}

	public void setAddId(int addId) {
		AddId = addId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Employeeb getEmployeeb() {
		return employeeb;
	}

	public void setEmployeeb(Employeeb employeeb) {
		this.employeeb = employeeb;
	}
	
	
	
	
}
