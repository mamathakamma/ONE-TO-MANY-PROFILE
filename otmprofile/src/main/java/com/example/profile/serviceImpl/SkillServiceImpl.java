package com.example.profile.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.profile.dao.EducationDao;
import com.example.profile.dao.SkillDao;
import com.example.profile.entity.Education;
import com.example.profile.entity.Skill;
import com.example.profile.exception.ResourceNotFoundException;
import com.example.profile.repo.SkillRepo;
import com.example.profile.service.SkillService;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Service
@Log4j2
public class SkillServiceImpl implements SkillService {
	@Autowired
	private SkillRepo skillRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public SkillDao save(Skill skill) {
		log.info("Entered into Save Skill method");
		skillRepo.save(skill);
		return modelMapper.map(skill, SkillDao.class);
	}

	@Override
	public List<SkillDao> getAllSkill() {
		log.info("Entered into GetAll Skill method");
		List<Skill> skill = skillRepo.findAll();
		List<SkillDao> skillDaos = skill.stream().map(e-> modelMapper.map(e, SkillDao.class)).collect(Collectors.toList());
		return skillDaos;
	}
	
	@Override
	public SkillDao getSkillById(UUID id) throws ResourceNotFoundException {
		log.info("Entered into GetById Skill method");
		Optional<Skill> skill = skillRepo.findById(id);
		if(skill.isPresent())
		{
			return modelMapper.map(skill, SkillDao.class);
		}
		else
		{
			throw new ResourceNotFoundException("Skill not found", id);
		}
	}

	public SkillDao updateSkill(Skill skill, UUID id) throws ResourceNotFoundException {
		log.info("Entered into Update Skill method");
		Skill existingSkill = skillRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Skill", id));
		existingSkill.setName(skill.getName());
		skillRepo.save(existingSkill);
		return modelMapper.map(existingSkill, SkillDao.class);
		
	}

	@Override
	public void deleteSkill(UUID id) throws ResourceNotFoundException {
		log.info("Entered into Delete Skill method");
		skillRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Skill", id));
		skillRepo.deleteById(id);		
	}
}
