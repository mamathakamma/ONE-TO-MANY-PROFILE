package com.example.profile.dao;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class CertificateDao {

	private UUID id;
	private String name;
	private LocalDateTime endDate;
	private String url;
}
