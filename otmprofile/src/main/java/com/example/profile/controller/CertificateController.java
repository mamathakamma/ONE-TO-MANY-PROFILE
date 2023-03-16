package com.example.profile.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.profile.dao.CertificateDao;
import com.example.profile.entity.Certificate;
import com.example.profile.exception.ResourceNotFoundException;
import com.example.profile.service.CertificateService;

@RestController
@RequestMapping("certificate")
@CrossOrigin
public class CertificateController {
	
	@Autowired
	private CertificateService certificateService;
	
	@PostMapping
	public ResponseEntity<Certificate> save(@RequestBody Certificate certificate)
	{
		return new ResponseEntity<Certificate>(certificateService.save(certificate), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<CertificateDao> getAllCertificate()
	{
		return certificateService.getAllCertificate();
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<CertificateDao> getCertificateById(@PathVariable UUID id) throws ResourceNotFoundException {
		return new ResponseEntity<CertificateDao>(certificateService.getCertificateById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<CertificateDao> updateCertificate(@RequestBody Certificate certificate,@PathVariable UUID id) throws ResourceNotFoundException {
		return new ResponseEntity<CertificateDao>(certificateService.updateCertificate(certificate, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCertificate(@PathVariable UUID id) throws ResourceNotFoundException {
		certificateService.deleteCertificate(id);
		return new ResponseEntity<String>("Certificate deleted successfully", HttpStatus.OK);
	}	
}

