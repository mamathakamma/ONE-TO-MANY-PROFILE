package com.example.profile.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resume")
public class Resume {

	@Id
	@GeneratedValue
	private UUID id;
	private String name;
	private String mobileNo;
	private String email;
	private String address;
	private String bio;
	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
	private List<Skill> skills;
	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
	private List<Education> educations;
	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
	private List<WorkHistory> workHistories;
	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
	private List<Certificate> certificates;
	
}

