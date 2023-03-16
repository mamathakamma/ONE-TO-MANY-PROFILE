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

import com.example.profile.entity.Resume;
import com.example.profile.exception.ResourceNotFoundException;
import com.example.profile.service.ResumeService;

@RestController
@RequestMapping("resume")
@CrossOrigin
public class ResumeController {
	
	@Autowired
	private ResumeService resumeService;
	
	@PostMapping
	public ResponseEntity<Resume> save(@RequestBody Resume resume)
	{
		return new ResponseEntity<Resume>(resumeService.save(resume), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Resume> getAllResume()
	{
		return resumeService.getAllResume();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Resume> getResumeById(@PathVariable UUID id) throws ResourceNotFoundException {
		return new ResponseEntity<Resume>(resumeService.getResumeById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Resume> updateResume(@RequestBody Resume resume,@PathVariable UUID id) throws ResourceNotFoundException {
		return new ResponseEntity<Resume>(resumeService.updateResume(resume, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteResume(@PathVariable UUID id) throws ResourceNotFoundException {
		resumeService.deleteResume(id);
		return new ResponseEntity<String>("Resume deleted successfully", HttpStatus.OK);
	}	
}

