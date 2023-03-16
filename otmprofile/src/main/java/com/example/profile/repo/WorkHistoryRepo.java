package com.example.profile.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.profile.entity.WorkHistory;

public interface WorkHistoryRepo extends JpaRepository<WorkHistory, UUID> {

}
