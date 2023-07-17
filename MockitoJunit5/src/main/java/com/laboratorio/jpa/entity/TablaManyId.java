package com.laboratorio.jpa.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TablaManyId implements Serializable {

private long id;
private long idOneEnMany;
protected TablaManyId() {
	super();
}
public TablaManyId(long id, long idOneEnMany) {
	super();
	this.id = id;
	this.idOneEnMany = idOneEnMany;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public long getIdOneEnMany() {
	return idOneEnMany;
}
public void setIdOneEnMany(long idOneEnMany) {
	this.idOneEnMany = idOneEnMany;
}
@Override
public String toString() {
	return "TablaManyId [id=" + id + ", idOneEnMany=" + idOneEnMany + "]";
}


}
