package com.example.profile.service;

import java.util.List;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.profile.dao.CertificateDao;
import com.example.profile.entity.Certificate;
import com.example.profile.exception.ResourceNotFoundException;

@Service
public interface CertificateService {

	Certificate save(Certificate certificate);

	List<CertificateDao> getAllCertificate();

	CertificateDao getCertificateById(UUID id) throws ResourceNotFoundException;

	CertificateDao updateCertificate(Certificate certificate, UUID id) throws ResourceNotFoundException;

	void deleteCertificate(UUID id) throws ResourceNotFoundException;
}
