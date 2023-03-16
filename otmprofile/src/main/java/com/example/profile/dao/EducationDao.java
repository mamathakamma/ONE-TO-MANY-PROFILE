package com.example.profile.dao;

import java.util.UUID;

import lombok.Data;
@Data
public class EducationDao {
	private UUID id;
	private String universityName;
	private String collageName;
	private String grade;
	private String projectName;
	private String projectBio;
}
