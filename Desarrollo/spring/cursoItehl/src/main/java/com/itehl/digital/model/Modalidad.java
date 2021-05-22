package com.itehl.digital.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author ferney
 * Se define la entidad Modalidad
 */
@Document(collection="modalidad")
public class Modalidad implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2014626431783346590L;
	
	@Id
	private String id;
	private String nombre;
	private String descripcion;
	private Double descuento;
	
	public Modalidad() {
		super();
	}

	public Modalidad(String id, String nombre, String descripcion, Double descuento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.descuento = descuento;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	
	@Override
	public Modalidad clone() throws CloneNotSupportedException {
		return (Modalidad)super.clone();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof com.itehl.digital.model.Modalidad))
			return false;
		else {
			com.itehl.digital.model.Modalidad ref = (com.itehl.digital.model.Modalidad)obj;
			if (null == this.getId() || null == ref.getId())
				return false;
			else
				return (this.getId().equals(ref.getId()));
		}
	}

	@Override
    public int hashCode() {
        return Objects.hash(id);
    }		
}


