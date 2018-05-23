package com.beansB;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	String pname;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "PER_DEPT", joinColumns = { @JoinColumn(name = "Person") }, inverseJoinColumns = {
			@JoinColumn(name = "DEPT_ID") })
	Set<Department> dlist = new HashSet<>();

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String pname) {
		super();
		this.pname = pname;
	}

	public Set<Department> getDlist() {
		return dlist;
	}

	public void setDlist(Set<Department> dlist) {
		this.dlist = dlist;
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

	@Override
	public String toString() {
		return "Person [id=" + id + ", pname=" + pname + "]";
	}
	

}
