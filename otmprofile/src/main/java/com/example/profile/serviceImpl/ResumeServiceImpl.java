package com.example.profile.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.profile.entity.Resume;
import com.example.profile.exception.ResourceNotFoundException;
import com.example.profile.repo.ResumeRepo;
import com.example.profile.service.ResumeService;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Service
@Log4j2
public class ResumeServiceImpl implements ResumeService {
	@Autowired
	private ResumeRepo resumeRepo;

	@Override
	public Resume save(Resume resume) {
		log.info("Entered into Save Resume method");
		return resumeRepo.save(resume);
	}

	@Override
	public List<Resume> getAllResume() {
		log.info("Entered into GetAll Resume method");
		return resumeRepo.findAll();
	}

	public Resume getResumeById(UUID id) throws ResourceNotFoundException {
		log.info("Entered into GetById Resume method");
		Optional<Resume> resume = resumeRepo.findById(id);
		if(resume.isPresent())
		{
			return resume.get();
		}
		else
		{
			throw new ResourceNotFoundException("Resume", id);
		}
	}

	public Resume updateResume(Resume resume, UUID id) throws ResourceNotFoundException {
		log.info("Entered into Update Resume method");
		Resume existingResume = resumeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resum", id));
		existingResume.setName(resume.getName());
		existingResume.setMobileNo(resume.getMobileNo());
		existingResume.setEmail(resume.getEmail());
		existingResume.setAddress(resume.getAddress());
		existingResume.setBio(resume.getBio());
		resumeRepo.save(existingResume);
		return existingResume;
		
	}

	@Override
	public void deleteResume(UUID id) throws ResourceNotFoundException {
		log.info("Entered into Delete Resume method");
		resumeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resume", id));
		resumeRepo.deleteById(id);		
	}

}
