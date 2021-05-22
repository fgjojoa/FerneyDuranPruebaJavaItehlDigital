package com.itehl.digital.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.itehl.digital.model.Curso;
import com.itehl.digital.model.Modalidad;

/**
 * Repositorio para manejar la entidad Curso
 * @author ferney
 *
 */
public interface CursoRepository  extends CrudRepository<Curso, String> {

	/**
	 * Elimina un Curso
	 */
	@Override
	public void delete(Curso curso);
	
	/**
	 * Lista los cursos según una Modalidad
	 * @param modalidad
	 * @return
	 */
	public List<Curso> findByModalidad(Modalidad modalidad);

	
}
