package com.example.profile.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.profile.dao.EducationDao;
import com.example.profile.entity.Education;
import com.example.profile.exception.ResourceNotFoundException;
import com.example.profile.service.EducationService;

@RestController
@RequestMapping("education")
@CrossOrigin
public class EducationController {
	
	@Autowired
	private EducationService educationService;
	
	@PostMapping
	public ResponseEntity<EducationDao> save(@RequestBody Education education)
	{
		return new ResponseEntity<EducationDao>(educationService.save(education), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<EducationDao> getAllEducation()
	{
		return educationService.getAllEducation();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EducationDao> getEducationById(@PathVariable UUID id) throws ResourceNotFoundException {
		return new ResponseEntity<EducationDao>(educationService.getEducationById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<EducationDao> updateEducation(@RequestBody Education education,@PathVariable UUID id) throws ResourceNotFoundException {
		return new ResponseEntity<EducationDao>(educationService.updateEducation(education, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEducation(@PathVariable UUID id) throws ResourceNotFoundException {
		educationService.deleteEducation(id);
		return new ResponseEntity<String>("Education deleted successfully", HttpStatus.OK);
	}	
}
