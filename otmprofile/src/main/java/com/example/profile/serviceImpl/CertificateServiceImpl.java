package com.example.profile.serviceImpl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.profile.dao.CertificateDao;
import com.example.profile.entity.Certificate;
import com.example.profile.exception.ResourceNotFoundException;
import com.example.profile.repo.CertificateRepo;
import com.example.profile.service.CertificateService;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Service
@Log4j2
public class CertificateServiceImpl implements CertificateService {
	
	@Autowired
	private CertificateRepo certificateRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Certificate save(Certificate certificate) {
		log.info("Entered into Save certificate method");
		certificate.setEndDate(LocalDateTime.now());
		return certificateRepo.save(certificate);
	}

	@Override
	public List<CertificateDao> getAllCertificate() {
		log.info("Entered into GetAll certificate method");
		//Certificate certificate = modelMapper.map(certificateRepo, Certificate.class);
		List<Certificate> certificate = certificateRepo.findAll();
		List<CertificateDao> certificateDaos = certificate.stream().map(c -> modelMapper.map(c, CertificateDao.class)).collect(Collectors.toList());
		return certificateDaos;
	}
	
	public CertificateDao getCertificateById(UUID id) throws ResourceNotFoundException {
		log.info("Entered into GetById certificate method");
		Optional<Certificate> certificate = certificateRepo.findById(id);
		//modelMapper.map(certificate, CertificateDao.class);
		if(certificate.isPresent())
		{
			return modelMapper.map(certificate, CertificateDao.class);
		}
		else
		{
			throw new ResourceNotFoundException("Certificate", id);
		}
	}
	@Override
	public CertificateDao updateCertificate(Certificate certificate, UUID id) throws ResourceNotFoundException {
		log.info("Entered into Update certificate method");
		Certificate existingCertificate = certificateRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Certificate not present", id));
		existingCertificate.setName(certificate.getName());
		existingCertificate.setEndDate(certificate.getEndDate());
		existingCertificate.setUrl(certificate.getUrl());
		certificateRepo.save(existingCertificate);
		
		return modelMapper.map(existingCertificate, CertificateDao.class);
	}
	@Override
	public void deleteCertificate(UUID id) throws ResourceNotFoundException {
		log.info("Entered into Delete certificate method");
		certificateRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Certificate", id));
		certificateRepo.deleteById(id);		
	}
}
