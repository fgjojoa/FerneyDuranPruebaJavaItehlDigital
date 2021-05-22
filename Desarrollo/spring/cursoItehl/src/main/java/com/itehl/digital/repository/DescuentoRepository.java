package com.itehl.digital.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.itehl.digital.model.Curso;
import com.itehl.digital.model.Descuento;

/**
 * Repositorio para manejar la entidad descuento
 * @author ferney
 *
 */
public interface DescuentoRepository extends CrudRepository<Descuento, String>{

	/**
	 * Elimina un descuento
	 */
	@Override
	public void delete(Descuento descuento);
	
	/**
	 * Lista los descuentos de un curso
	 * @param curso
	 * @return
	 */
	public List<Descuento> findByCurso(Curso curso);
	
	
}
