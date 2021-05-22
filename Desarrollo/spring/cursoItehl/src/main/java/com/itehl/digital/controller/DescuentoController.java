package com.itehl.digital.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itehl.digital.model.Curso;
import com.itehl.digital.model.Descuento;
import com.itehl.digital.repository.DescuentoRepository;

/**
 * Controlador de Servicion para la entidad Descuento
 * @author ferney
 *
 */
@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
@RequestMapping("/apidescuento")
public class DescuentoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5831233668791142769L;

	@Autowired
	DescuentoRepository repositorio;

	/**
	 * Servicio que Lista los Descuentos según un Curso
	 * @param modalidad
	 * @return
	 */
	@PostMapping("/curso")
	public ResponseEntity<List<Descuento>> descuentoByCurso(@RequestBody Curso curso) {
		try {
			List<Descuento> lst = new ArrayList<Descuento>();

			this.repositorio.findByCurso(curso).forEach(lst::add);

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
	 * Servicio para crear o actualizar un Descuento
	 * @param curso
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<Descuento> save(@RequestBody Descuento descuento) {
		try {
			this.repositorio.save(descuento);
			return new ResponseEntity<Descuento>(descuento, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Servico para eliminar un Descuento
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
		try {
			this.repositorio.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
