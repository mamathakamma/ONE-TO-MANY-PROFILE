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

import com.example.profile.dao.SkillDao;
import com.example.profile.entity.Resume;
import com.example.profile.entity.Skill;
import com.example.profile.exception.ResourceNotFoundException;
import com.example.profile.service.ResumeService;
import com.example.profile.service.SkillService;

@RestController
@RequestMapping("skill")
@CrossOrigin
public class SkillController {
	
	@Autowired
	private SkillService skillService;
	
	@PostMapping
	public ResponseEntity<SkillDao> save(@RequestBody Skill skill)
	{
		return new ResponseEntity<SkillDao>(skillService.save(skill), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<SkillDao> getAllSkill()
	{
		return skillService.getAllSkill();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<SkillDao> getSkillById(@PathVariable UUID id) throws ResourceNotFoundException {
		return new ResponseEntity<SkillDao>(skillService.getSkillById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<SkillDao> updateSkill(@RequestBody Skill skill,@PathVariable UUID id) throws ResourceNotFoundException {
		return new ResponseEntity<SkillDao>(skillService.updateSkill(skill, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteSkill(@PathVariable UUID id) throws ResourceNotFoundException {
		skillService.deleteSkill(id);
		return new ResponseEntity<String>("Skill deleted successfully", HttpStatus.OK);
	}	
}
