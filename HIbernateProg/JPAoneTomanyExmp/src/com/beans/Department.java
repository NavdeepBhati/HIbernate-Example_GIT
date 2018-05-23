package com.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="deptm2m")
public class Department {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	
	
	
	
	@ManyToMany
	//(targetEntity=Persons.class,mappedBy="department")
	//@OrderBy("pname ASC")
	//@MapKey(name="id")
	List<Persons> personsList= new ArrayList<>();
	
	
	public List<Persons> getPersonsList() {
		return personsList;
	}
	public void setPersonsList(List<Persons> personsList) {
		this.personsList = personsList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department(String name) {
		super();
		this.name = name;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
