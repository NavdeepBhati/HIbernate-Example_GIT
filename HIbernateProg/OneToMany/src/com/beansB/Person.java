package com.beansB;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Person {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String pname;

	@ManyToOne
	//@JoinColumn
	Department department;
	
	
	
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Person(String pname, Department department) {
		super();
		this.pname = pname;
		this.department = department;
	}



	public Department getDepartment() {
		return department;
	}



	public void setDepartment(Department department) {
		this.department = department;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	



}
