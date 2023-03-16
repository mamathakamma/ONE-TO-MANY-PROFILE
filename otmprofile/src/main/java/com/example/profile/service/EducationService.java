package com.example.profile.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.profile.dao.EducationDao;
import com.example.profile.entity.Education;
import com.example.profile.exception.ResourceNotFoundException;
@Service
public interface EducationService {
	
	EducationDao save(Education education);
	List<EducationDao> getAllEducation();
	EducationDao getEducationById(UUID id) throws ResourceNotFoundException;
	EducationDao updateEducation(Education education, UUID id) throws ResourceNotFoundException;
	void deleteEducation(UUID id) throws ResourceNotFoundException;
}
