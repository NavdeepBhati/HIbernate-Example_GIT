package com.beansB;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String name;
	
	
	
	@OneToMany(mappedBy="department", fetch=FetchType.EAGER,cascade=CascadeType.ALL)           //mappedBY is necessary otherwise we wont be able to fetch the values bidirectionally
	List<Person> plist = new ArrayList<>();
	
	
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	public Department(int id, String name, List<Person> plist) {
		super();
		this.id = id;
		this.name = name;
		this.plist = plist;
	}
	public List<Person> getPlist() {
		return plist;
	}
	public void setPlist(List<Person> plist) {
		this.plist = plist;
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
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	
	
	
	
	
}
