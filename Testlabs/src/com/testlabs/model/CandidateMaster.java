package com.testlabs.model;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.testlabs.constatnts.FileModel;
import com.testlabs.controllers.SkillMapper;

public class CandidateMaster {
	
	private String candidateId;
	private String candidateName;
	private String candidateNumber;
	private String emailId;
	private String locationPreference;
	private String location;
	private String noticePeriod;
	private String currentCompany;
	private String currentSalary;
	private String expectesSalary;
	private String candidateStatus;
	private Date expectedJoining;
	private String insertedDate;
	private String updatedDate;
	private String onBoradingStatus;
	private Date invoiceStartDate;
	private Date billingStartDate;
	private Date billingEndDate;
	private String clientSalaray;
	private List<SkillMapper> skill;
	private String skills;
	private MultipartFile fileModel;
	private String resume_name;
	private String resume_id;
	private String file_type;
	
	
	
	
	public String getCandidateId() {
		return candidateId;
	}


	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}



	public String getResume_name() {
		return resume_name;
	}



	public void setResume_name(String resume_name) {
		this.resume_name = resume_name;
	}



	public String getResume_id() {
		return resume_id;
	}



	public void setResume_id(String resume_id) {
		this.resume_id = resume_id;
	}



	public String getFile_type() {
		return file_type;
	}



	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}



	public MultipartFile getFileModel() {
		return fileModel;
	}



	public void setFileModel(MultipartFile fileModel) {
		this.fileModel = fileModel;
	}



	public String getSkills() {
		return skills;
	}



	public void setSkills(String skills) {
		this.skills = skills;
	}



	public String getCandidateName() {
		return candidateName;
	}



	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}



	public String getCandidateNumber() {
		return candidateNumber;
	}



	public void setCandidateNumber(String candidateNumber) {
		this.candidateNumber = candidateNumber;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getLocationPreference() {
		return locationPreference;
	}



	public void setLocationPreference(String locationPreference) {
		this.locationPreference = locationPreference;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getNoticePeriod() {
		return noticePeriod;
	}



	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}



	public String getCurrentCompany() {
		return currentCompany;
	}



	public void setCurrentCompany(String currentCompany) {
		this.currentCompany = currentCompany;
	}



	public String getCurrentSalary() {
		return currentSalary;
	}



	public void setCurrentSalary(String currentSalary) {
		this.currentSalary = currentSalary;
	}



	public String getExpectesSalary() {
		return expectesSalary;
	}



	public void setExpectesSalary(String expectesSalary) {
		this.expectesSalary = expectesSalary;
	}



	public String getCandidateStatus() {
		return candidateStatus;
	}



	public void setCandidateStatus(String candidateStatus) {
		this.candidateStatus = candidateStatus;
	}



	public Date getExpectedJoining() {
		return expectedJoining;
	}



	public void setExpectedJoining(Date expectedJoining) {
		this.expectedJoining = expectedJoining;
	}



	public String getInsertedDate() {
		return insertedDate;
	}



	public void setInsertedDate(String insertedDate) {
		this.insertedDate = insertedDate;
	}



	public String getUpdatedDate() {
		return updatedDate;
	}



	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}



	public String getOnBoradingStatus() {
		return onBoradingStatus;
	}



	public void setOnBoradingStatus(String onBoradingStatus) {
		this.onBoradingStatus = onBoradingStatus;
	}



	public Date getInvoiceStartDate() {
		return invoiceStartDate;
	}



	public void setInvoiceStartDate(Date invoiceStartDate) {
		this.invoiceStartDate = invoiceStartDate;
	}



	public Date getBillingStartDate() {
		return billingStartDate;
	}



	public void setBillingStartDate(Date billingStartDate) {
		this.billingStartDate = billingStartDate;
	}



	public Date getBillingEndDate() {
		return billingEndDate;
	}



	public void setBillingEndDate(Date billingEndDate) {
		this.billingEndDate = billingEndDate;
	}



	public String getClientSalaray() {
		return clientSalaray;
	}



	public void setClientSalaray(String clientSalaray) {
		this.clientSalaray = clientSalaray;
	}

	
	public List<SkillMapper> getSkill() {
		return skill;
	}
	public void setSkill(List<SkillMapper> skill) {
		this.skill = skill;
	}


	@Override
	public String toString() {
		return "CandidateMaster [candidateName=" + candidateName + ", candidateNumber=" + candidateNumber + ", emailId="
				+ emailId + ", locationPreference=" + locationPreference + ", location=" + location + ", noticePeriod="
				+ noticePeriod + ", currentCompany=" + currentCompany + ", currentSalary=" + currentSalary
				+ ", expectesSalary=" + expectesSalary + ", candidateStatus=" + candidateStatus + ", expectedJoining="
				+ expectedJoining + ", insertedDate=" + insertedDate + ", updatedDate=" + updatedDate
				+ ", onBoradingStatus=" + onBoradingStatus + ", invoiceStartDate=" + invoiceStartDate
				+ ", billingStartDate=" + billingStartDate + ", billingEndDate=" + billingEndDate + ", clientSalaray="
				+ clientSalaray + "]";
	}
	
	
	
	
	

}
