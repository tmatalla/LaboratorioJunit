package com.laboratorio.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Table - User
@Table
@Entity
public class Tablaone {

@Id
private long idOne;

private String nameOne;
private String roleOne;

@OneToMany(mappedBy = "tablaOne",//mappedBy el nombre que le hemos puesto en la tabla Many
		cascade = CascadeType.ALL,//each operation perform in the tablaOne se propagará a los registros de tablaMany
		fetch=FetchType.EAGER,
		orphanRemoval = true) //si quitamos attributos de tablaOne también se quitarán los de tablaMany
private List<Tablamany> tablamanys = new ArrayList<Tablamany>();

protected Tablaone() {
	super();
}

public Tablaone(long idOne,String nameOne, String roleOne) {
	super();
	this.idOne=idOne;
	this.nameOne = nameOne;
	this.roleOne = roleOne;
}

public long getIdOne() {
	return idOne;
}

public String getNameOne() {
	return nameOne;
}

public String getRoleOne() {
	return roleOne;
}

public List<Tablamany> getTablamanys() {
	return tablamanys;
}
public void setTablamanys(List<Tablamany> tablamanys) {
	this.tablamanys = tablamanys;
}

@Override
public String toString() {
	return "Tablaone [idOne=" + idOne + ", nameOne=" + nameOne + ", roleOne=" + roleOne + ", tablamanys=" + tablamanys
			+ "]";
}

}
