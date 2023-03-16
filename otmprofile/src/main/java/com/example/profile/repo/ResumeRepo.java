package com.example.profile.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.profile.entity.Resume;

public interface ResumeRepo extends JpaRepository<Resume, UUID> {

}
