package com.ABC.Gloflox.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ABC.Gloflox.Service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
	BookingService service;
	
	
	@PostMapping("/book")
	public ResponseEntity<String> bookClass(@RequestParam Long classId,
	                        @RequestParam String memberName,
	                        @RequestParam String bookingDate) {
	    LocalDate date = LocalDate.parse(bookingDate); 
	    String Bookingstatus= service.bookClass(classId, memberName, date);
	    if(Bookingstatus.charAt(0)=='B') return new ResponseEntity<String>(Bookingstatus,HttpStatus.CREATED);
	    return new ResponseEntity<>(Bookingstatus,HttpStatus.CONFLICT);
	}

}
