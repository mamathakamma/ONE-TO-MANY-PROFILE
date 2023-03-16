package com.example.profile.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.profile.dao.CertificateDao;
import com.example.profile.dao.EducationDao;
import com.example.profile.entity.Certificate;
import com.example.profile.entity.Education;
import com.example.profile.exception.ResourceNotFoundException;
import com.example.profile.repo.EducationRepo;
import com.example.profile.repo.ResumeRepo;
import com.example.profile.service.EducationService;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Service
@Log4j2
public class EducationServiceImpl implements EducationService {
	@Autowired
	private EducationRepo educationRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EducationDao save(Education education) {
		log.info("Entered into Save Education method");
		educationRepo.save(education);
		return modelMapper.map(education, EducationDao.class); 
	}
	
	
	@Override
	public EducationDao getEducationById(UUID id) throws ResourceNotFoundException {
		log.info("Entered into GetById Education method");
		Optional<Education> education = educationRepo.findById(id);
		if(education.isPresent())
		{
			return modelMapper.map(education, EducationDao.class);
		}
		else
		{
			throw new ResourceNotFoundException("Education not found", id);
		}
	}
	
	@Override
	public EducationDao updateEducation(Education education, UUID id) throws ResourceNotFoundException {
		log.info("Entered into Update Education method");
		Education existingEducation = educationRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Education", id));
		existingEducation.setUniversityName(education.getUniversityName());
		existingEducation.setCollageName(education.getCollageName());
		existingEducation.setGrade(education.getGrade());
		existingEducation.setProjectName(education.getProjectName());
		existingEducation.setProjectBio(education.getProjectBio());
		educationRepo.save(existingEducation);
		return modelMapper.map(existingEducation, EducationDao.class);
		
	}
	
	@Override
	public void deleteEducation(UUID id) throws ResourceNotFoundException {
		log.info("Entered into delete Education method");
		educationRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Education", id));
		educationRepo.deleteById(id);		
	}

	@Override
	public List<EducationDao> getAllEducation() {
		log.info("Entered into GetAll Education method");
		List<Education> education = educationRepo.findAll();
		List<EducationDao> educationDaos = education.stream().map(e-> modelMapper.map(e, EducationDao.class)).collect(Collectors.toList());
		return educationDaos;
	}
	
}
