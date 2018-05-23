package com.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="persm2m")
public class Persons {

	
	@Id
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	int id;
	
	String pname;
	
	
	
	/*@JoinColumn
	Department department;
	*/
	

	//@ManyToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="dname", referencedColumnName="name")
	//Department department;

	@ManyToMany
	List<Department> deptlist = new ArrayList<>();
	
	public List<Department> getDeptlist() {
		return deptlist;
	}

	public void setDeptlist(List<Department> deptlist) {
		this.deptlist = deptlist;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
/*
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
*/
	public Persons(String pname) {
		super();
		this.pname = pname;
	}

	public Persons() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
