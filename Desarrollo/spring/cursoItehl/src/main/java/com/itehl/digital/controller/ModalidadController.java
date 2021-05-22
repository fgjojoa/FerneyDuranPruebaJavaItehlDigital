package com.itehl.digital.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itehl.digital.model.Modalidad;
import com.itehl.digital.repository.ModalidadRepository;

/**
 * Controlador Para la entidad Modalidad
 * 
 * @author ferney
 *
 */
@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping("/apimodalidad")
public class ModalidadController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1263210476684347506L;

	@Autowired
	ModalidadRepository repositorio;

	/**
	 * Servicio que lista todas las modalidades
	 * @return
	 */
	@GetMapping("/modalidades")
	public ResponseEntity<List<Modalidad>> getAllModalidades() {
		try {
			List<Modalidad> lst = new ArrayList<Modalidad>();

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
}
