package com.ABC.Gloflox.controller;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ABC.Gloflox.Entity.Classes;
import com.ABC.Gloflox.Service.ClassService;
import com.ABC.Gloflox.springDataJpa.ClassesJpaRepository;

import jakarta.validation.Valid;



@RestController
public class ClassesController {
	
	@Autowired
	ClassService service;
	
	
	@GetMapping("/classes")
	public List<Classes> getAllClasses() {
		return service.findAll();
	}
	
	
	@GetMapping("/classes/{id}")
	public ResponseEntity<Optional<Classes>> getClassById(@PathVariable long id ){
		Optional<Classes> obj=service.findById(id);
		return new ResponseEntity<>(obj,HttpStatus.OK);
	
	}
	
	@PostMapping("/classes")
	public ResponseEntity<String> creatingClasses(@RequestBody Classes obj) throws Exception {
		
		if(obj.getEndDate().isBefore(obj.getStartDate()) || obj.getClassName().isEmpty() ) {
			throw new Exception();
		}
		
		service.createClass(obj);
		return new ResponseEntity<> (("Class has been created"),HttpStatus.CREATED);
	}
	

}
