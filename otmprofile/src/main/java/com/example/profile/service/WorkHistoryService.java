package com.example.profile.service;

import java.util.List;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.profile.dao.WorkHistoryDao;
import com.example.profile.entity.WorkHistory;
import com.example.profile.exception.ResourceNotFoundException;

@Service
public interface WorkHistoryService {
	
	WorkHistoryDao save(WorkHistory workHistory);
	List<WorkHistoryDao> getAllWorkHistory();
	WorkHistoryDao getWorkHistoryById(UUID id) throws ResourceNotFoundException;
	WorkHistoryDao updateWorkHistory(WorkHistory workHistory, UUID id) throws ResourceNotFoundException;
	void deleteWorkHistory(UUID id) throws ResourceNotFoundException;
}
