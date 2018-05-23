package com.beans121j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;


@Entity
public class Addressj {

	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private int AddId;

	
	
	private String city;
	
	private String area;
	
	
	@Transient
	@OneToOne(mappedBy="addressb")
	private Employeej employeeb;

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

	public Employeej getEmployeeb() {
		return employeeb;
	}

	public void setEmployeeb(Employeej employeeb) {
		this.employeeb = employeeb;
	}
	
	
	
	
}
