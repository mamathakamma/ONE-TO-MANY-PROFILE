package com.example.profile.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.profile.entity.Resume;
import com.example.profile.exception.ResourceNotFoundException;

@Service
public interface ResumeService {
		
	Resume save(Resume resume);
	List<Resume> getAllResume();
	Resume getResumeById(UUID id) throws ResourceNotFoundException;
	Resume updateResume(Resume resume, UUID id) throws ResourceNotFoundException;
	void deleteResume(UUID id) throws ResourceNotFoundException;
}
