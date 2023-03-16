package com.example.profile.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.profile.dao.SkillDao;
import com.example.profile.dao.WorkHistoryDao;
import com.example.profile.entity.WorkHistory;
import com.example.profile.exception.ResourceNotFoundException;
import com.example.profile.repo.WorkHistoryRepo;
import com.example.profile.service.WorkHistoryService;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Service
@Log4j2
public class WorkHistoryServiceImpl implements WorkHistoryService {
	@Autowired
	private WorkHistoryRepo workHistoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public WorkHistoryDao save(WorkHistory workHistory) {
		log.info("Entered into Save WorkHistory method");
		workHistory.setStartDate(LocalDateTime.now());
		workHistory.setEndDate(LocalDateTime.now());
		workHistoryRepo.save(workHistory);
		return modelMapper.map(workHistory, WorkHistoryDao.class);
	}

	

	public WorkHistoryDao getWorkHistoryById(UUID id) throws ResourceNotFoundException {
		log.info("Entered into GetById WorkHistory method");
		Optional<WorkHistory> workHistory = workHistoryRepo.findById(id);
		if(workHistory.isPresent())
		{
			return modelMapper.map(workHistory, WorkHistoryDao.class);
		}
		else
		{
			throw new ResourceNotFoundException("WorkHistory ", id);
		}
	}

	public WorkHistoryDao updateWorkHistory(WorkHistory workHistory, UUID id) throws ResourceNotFoundException {
		log.info("Entered into Update WorkHistory method");
		WorkHistory existingWorkHistory = workHistoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("WorkHistory", id));
		existingWorkHistory.setCompanyName(workHistory.getCompanyName());
		existingWorkHistory.setStartDate(workHistory.getStartDate());
		existingWorkHistory.setEndDate(workHistory.getEndDate());
		existingWorkHistory.setDesignation(workHistory.getDesignation());
		existingWorkHistory.setProjectName(workHistory.getProjectName());
		existingWorkHistory.setProjectBio(workHistory.getProjectBio());
		workHistoryRepo.save(existingWorkHistory);
		return modelMapper.map(existingWorkHistory, WorkHistoryDao.class);
		
	}

	@Override
	public void deleteWorkHistory(UUID id) throws ResourceNotFoundException {
		log.info("Entered into Delete WorkHistory method");
		workHistoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("WorkHistory", id));
		workHistoryRepo.deleteById(id);		
	}

	@Override
	public List<WorkHistoryDao> getAllWorkHistory() {
		log.info("Entered into GetAll WorkHistory method");
		List<WorkHistory> workHistory = workHistoryRepo.findAll();
		List<WorkHistoryDao> workHistoryDaos = workHistory.stream().map(e-> modelMapper.map(e, WorkHistoryDao.class)).collect(Collectors.toList());
		return workHistoryDaos;
	}

}
