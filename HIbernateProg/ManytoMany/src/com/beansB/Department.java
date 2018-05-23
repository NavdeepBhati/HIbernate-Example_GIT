package com.beansB;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	String name;

	@ManyToMany(mappedBy = "dlist")
	Set<Person> plist = new HashSet<>();

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String name) {
		super();

		this.name = name;
	}

	public Department(int id, String name, Set<Person> plist) {
		super();
		this.id = id;
		this.name = name;
		this.plist = plist;
	}

	public Set<Person> getPlist() {
		return plist;
	}

	public void setPlist(Set<Person> plist) {
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
		return "Department [id=" + id + ", name=" + name +"]";
	}
	

}
