package com.itehl.digital.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itehl.digital.model.Curso;
import com.itehl.digital.model.Modalidad;
import com.itehl.digital.repository.CursoRepository;

/**
 * Controlador de Servivios para la entidad Modalidad
 * 
 * @author ferney
 *
 */
@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
@RequestMapping("/apicurso")
public class CursoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6790144023322460689L;

	@Autowired
	CursoRepository repositorio;

	/**
	 * Servicio que lista todos los cursos
	 * @return
	 */
	@GetMapping("/cursos")
	public ResponseEntity<List<Curso>> getAllCursos() {
		try {
			List<Curso> lst = new ArrayList<Curso>();

			this.repositorio.findAll().forEach(lst::add);

			if (lst.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(lst, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Servicio que Lista los cursos segun una modalidad
	 * @param modalidad
	 * @return
	 */
	@PostMapping("/modalidad")
	public ResponseEntity<List<Curso>> cursosByModalidad(@RequestBody Modalidad modalidad) {
		try {
			List<Curso> lst = new ArrayList<Curso>();

			this.repositorio.findByModalidad(modalidad).forEach(lst::add);

			if (lst.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(lst, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	/**
	 * Servicio para crear o actualizar un Curso
	 * @param curso
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<Curso> save(@RequestBody Curso curso) {
		try {
			this.repositorio.save(curso);
			return new ResponseEntity<Curso>(curso, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Servico para eliminar un Curso
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") String id) {
		try {
			this.repositorio.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
