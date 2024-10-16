package com.ABC.Gloflox.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	

	@GetMapping("/hello")
	public String welcome() {
		return "Nice to meet you";
	}
}
