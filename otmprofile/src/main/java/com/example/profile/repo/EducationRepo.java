package com.example.profile.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.profile.entity.Education;

public interface EducationRepo extends JpaRepository<Education, UUID>{

}
