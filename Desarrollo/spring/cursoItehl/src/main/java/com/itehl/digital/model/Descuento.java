package com.itehl.digital.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author ferney
 * Se define la entidad Descuento
 */
@Document(collection="descuento")
public class Descuento implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3610719897531996530L;

	@Id
	private String id;	
	private String nombre;
    private Modalidad modalidad;
    private String pais;
    private Double precio;
    private Double descuento;
    private Double precioFinal;
	private Curso  curso;
    private String fechaFinal;

    public Descuento() {
		super();
	}

	public Descuento(String id, String nombre, Modalidad modalidad, String pais, Double precio, Double descuento,
			Double pecioFinal, Curso curso, String fechaFinal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.modalidad = modalidad;
		this.pais = pais;
		this.precio = precio;
		this.descuento = descuento;
		this.precioFinal = pecioFinal;
		this.curso = curso;
		this.fechaFinal = fechaFinal;
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

	public Modalidad getModalidad() {
		return modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public Double getPrecioFinal() {
		return precioFinal;
	}

	public void setPecioFinal(Double precioFinal) {
		this.precioFinal = precioFinal;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	@Override
	public Descuento clone() throws CloneNotSupportedException {
		return (Descuento)super.clone();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof com.itehl.digital.model.Descuento))
			return false;
		else {
			com.itehl.digital.model.Descuento ref = (com.itehl.digital.model.Descuento)obj;
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
