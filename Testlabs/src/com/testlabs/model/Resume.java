package com.testlabs.model;

import org.springframework.web.multipart.MultipartFile;

public class Resume {

	private String CandidateId;
	private MultipartFile file;

	
	
	public String getCandidateId() {
		return CandidateId;
	}

	public void setCandidateId(String candidateId) {
		CandidateId = candidateId;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}
