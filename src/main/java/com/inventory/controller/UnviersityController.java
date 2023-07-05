package com.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.dto.UniversityDto;
import com.inventory.service.UniversityService;

@RestController
public class UnviersityController {

	@Autowired
	private UniversityService universityService;

	@GetMapping("/name/{name}")
	public UniversityDto getByName(@PathVariable("name") String name) {
		return universityService.getByName(name);
	}
}
