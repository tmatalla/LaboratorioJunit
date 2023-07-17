package com.laboratorio.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//Table - User
@Table
@Entity
public class TablaOneId {

@Id
@GeneratedValue
private long id;

private String name;

private String role;

protected TablaOneId() {
	super();
}
public TablaOneId(String name, String role) {
	super();
	this.name = name;
	this.role = role;
}


public long getId() {
	return id;
}
public String getName() {
	return name;
}
public String getRole() {
	return role;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", role=" + role + "]";
}

}
