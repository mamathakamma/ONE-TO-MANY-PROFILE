package com.example.profile.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class WorkHistoryDao {
	private String companyName;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String designation;
	private String projectName;
	private String projectBio;
}
