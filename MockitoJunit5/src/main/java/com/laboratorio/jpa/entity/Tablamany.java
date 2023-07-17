package com.laboratorio.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TablaMany")
public class Tablamany implements Serializable {

@Id
private TablaManyId id;

private String nameMany;
private String roleMany;


@ManyToOne()
@JoinColumns({ 
	@JoinColumn(name = "idOneEnMany", referencedColumnName = "idOne", nullable = false, insertable = false, updatable = false) 
})
private Tablaone tablaOne;

protected Tablamany() {
	super();
}

public Tablamany(TablaManyId id, String nameMany, String roleMany) {
	super();
	this.id = id;
	this.nameMany = nameMany;
	this.roleMany = roleMany;
}

public TablaManyId getId() {
	return id;
}
public void setId(TablaManyId id) {
	this.id = id;
}

public String getNameMany() {
	return nameMany;
}
public String getRoleMany() {
	return roleMany;
}

public Tablaone getTablaOne() {
	return tablaOne;
}
public void setTablaOne(Tablaone tablaOne) {
	this.tablaOne = tablaOne;
}
@Override
public String toString() {
	return "Tablamany [id=" + id + ", nameMany=" + nameMany + ", roleMany=" + roleMany + ", tablaOne: id("+tablaOne.getIdOne()+"), name(" + tablaOne.getNameOne() + ")]";
}

}
