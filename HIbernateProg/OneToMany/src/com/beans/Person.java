package com.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Person {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String pname;

	@OneToMany
	@JoinTable(name="dept_pers")
	List<Department> dlist = new ArrayList<>();
//	Department department;
	
	
	
	
	
	
	public int getId() {
		return id;
	}

	public List<Department> getD() {
		return dlist;
	}

	public void setD(List<Department> d) {
		this.dlist = d;
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
