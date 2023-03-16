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

import com.example.profile.dao.WorkHistoryDao;
import com.example.profile.entity.WorkHistory;
import com.example.profile.exception.ResourceNotFoundException;
import com.example.profile.service.WorkHistoryService;

@RestController
@RequestMapping("workHistory")
@CrossOrigin
public class WorkHistoryController {
	
    @Autowired
	private WorkHistoryService workHistoryService;
	
	@PostMapping
	public ResponseEntity<WorkHistoryDao> save(@RequestBody WorkHistory workHistory)
	{
		return new ResponseEntity<WorkHistoryDao>(workHistoryService.save(workHistory), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<WorkHistoryDao> getAllWorkHistory()
	{
		return workHistoryService.getAllWorkHistory();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<WorkHistoryDao> getWorkHistoryById(@PathVariable UUID id) throws ResourceNotFoundException {
		return new ResponseEntity<WorkHistoryDao>(workHistoryService.getWorkHistoryById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<WorkHistoryDao> updateWorkHistory(@RequestBody WorkHistory workHistory,@PathVariable UUID id) throws ResourceNotFoundException {
		return new ResponseEntity<WorkHistoryDao>(workHistoryService.updateWorkHistory(workHistory, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteWorkHistory(@PathVariable UUID id) throws ResourceNotFoundException {
		workHistoryService.deleteWorkHistory(id);
		return new ResponseEntity<String>("WorkHistory deleted successfully", HttpStatus.OK);
	}	
}
