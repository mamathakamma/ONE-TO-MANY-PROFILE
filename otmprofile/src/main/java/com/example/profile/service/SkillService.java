package com.example.profile.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.profile.dao.SkillDao;
import com.example.profile.entity.Skill;
import com.example.profile.exception.ResourceNotFoundException;
@Service
public interface SkillService {
	
	SkillDao save(Skill skill);
	List<SkillDao> getAllSkill();
	SkillDao getSkillById(UUID id) throws ResourceNotFoundException;
	SkillDao updateSkill(Skill skill, UUID id) throws ResourceNotFoundException;
	void deleteSkill(UUID id) throws ResourceNotFoundException;
}
