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
@Document(collection="curso")
public class Curso implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8127504143730979717L;

	@Id
	private String id;	
	private String nombre;
	private String descripcion;
	private String horas;
	private String dirigido;
    private Double costo;
    private Modalidad modalidad;
    
	public Curso() {
		super();
	}

	public Curso(String id, String nombre, String descripcion, String horas, String dirigido, Double costo,
			Modalidad modalidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.horas = horas;
		this.dirigido = dirigido;
		this.costo = costo;
		this.modalidad = modalidad;
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

	public String getHoras() {
		return horas;
	}

	public void setHoras(String horas) {
		this.horas = horas;
	}

	public String getDirigido() {
		return dirigido;
	}

	public void setDirigido(String dirigido) {
		this.dirigido = dirigido;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Modalidad getModalidad() {
		return modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}
	
	@Override
	public Curso clone() throws CloneNotSupportedException {
		return (Curso)super.clone();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof com.itehl.digital.model.Curso))
			return false;
		else {
			com.itehl.digital.model.Curso ref = (com.itehl.digital.model.Curso)obj;
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
