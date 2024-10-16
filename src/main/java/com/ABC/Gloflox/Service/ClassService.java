package com.ABC.Gloflox.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ABC.Gloflox.Entity.ClassSlots;
import com.ABC.Gloflox.Entity.Classes;
import com.ABC.Gloflox.springDataJpa.ClassesJpaRepository;

@Service
public class ClassService {
	
	@Autowired
	ClassesJpaRepository repository;
	
	
	public Classes createClass(Classes obj) {
		Classes savedClass=repository.save(obj);
		
		List<ClassSlots> slots= createClassSlots(savedClass);
	    savedClass.setSlots(slots);
	    
	    return repository.save(savedClass);
	
	}


	private List<ClassSlots> createClassSlots(Classes savedClass) {
		// TODO Auto-generated method stub
		List<ClassSlots> slots=new ArrayList<>();
		LocalDate startDate=savedClass.getStartDate();
		LocalDate endDate=savedClass.getEndDate();
		int capacity=savedClass.getCapacity();
		
		LocalDate currentDate=startDate;
		while(!currentDate.isAfter(endDate)) {
			ClassSlots slot=new ClassSlots(savedClass,currentDate,capacity);
			slots.add(slot);
			currentDate=currentDate.plusDays(1);
		}
		return slots;
		
	}


	public List<Classes> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}


	public Optional<Classes> findById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}
	

}
