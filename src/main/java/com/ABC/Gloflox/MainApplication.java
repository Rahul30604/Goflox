package com.ABC.Gloflox;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ABC.Gloflox.Entity.Classes;
import com.ABC.Gloflox.Service.ClassService;
import com.ABC.Gloflox.springDataJpa.ClassesJpaRepository;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {
 
	@Autowired
	ClassService service;
	
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		service.createClass(new Classes(1l,"Yoga",LocalDate.of(2024, 10, 1),LocalDate.of(2024,10,6),10));
		service.createClass(new Classes(2l,"Meditation",LocalDate.of(2024, 4, 10),LocalDate.of(2024,4,14),2));
		//repository.save(new Classes(3l,"Zumba",LocalDate.of(2024, 10, 10),LocalDate.of(2024,4,14),10));
		
	}

}
