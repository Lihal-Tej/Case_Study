package com.testlabs.model;

import java.util.Date;
import java.util.List;

import com.testlabs.controllers.SkillMapper;

public class ClientMaster {
	
	private int clientId;
	private String clientName;
	private String mandatorySkills;
	private String additionalSkills;
	private String totalPositions;
	private String sourcingRate;
	private String type;
	private String profilesShared;
	private String screenReject;
	private String techInterview;
	private String techRejects;
	private String finalSelect;
	private String experiance;
	private Date joiningDate;
	private Date insertedDate;
	private Date updatedDate;
	private String location;
	private String clientRate;
	private String imp;
	
	
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getMandatorySkills() {
		return mandatorySkills;
	}
	public void setMandatorySkills(String mandatorySkills) {
		this.mandatorySkills = mandatorySkills;
	}
	public String getAdditionalSkills() {
		return additionalSkills;
	}
	public void setAdditionalSkills(String additionalSkills) {
		this.additionalSkills = additionalSkills;
	}
	public String getTotalPositions() {
		return totalPositions;
	}
	public void setTotalPositions(String totalPositions) {
		this.totalPositions = totalPositions;
	}
	public String getSourcingRate() {
		return sourcingRate;
	}
	public void setSourcingRate(String sourcingRate) {
		this.sourcingRate = sourcingRate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProfilesShared() {
		return profilesShared;
	}
	public void setProfilesShared(String profilesShared) {
		this.profilesShared = profilesShared;
	}
	public String getScreenReject() {
		return screenReject;
	}
	public void setScreenReject(String screenReject) {
		this.screenReject = screenReject;
	}
	public String getTechInterview() {
		return techInterview;
	}
	public void setTechInterview(String techInterview) {
		this.techInterview = techInterview;
	}
	public String getTechRejects() {
		return techRejects;
	}
	public void setTechRejects(String techRejects) {
		this.techRejects = techRejects;
	}
	public String getFinalSelect() {
		return finalSelect;
	}
	public void setFinalSelect(String finalSelect) {
		this.finalSelect = finalSelect;
	}
	
	public String getExperiance() {
		return experiance;
	}
	public void setExperiance(String experiance) {
		this.experiance = experiance;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Date getInsertedDate() {
		return insertedDate;
	}
	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getClientRate() {
		return clientRate;
	}
	public void setClientRate(String clientRate) {
		this.clientRate = clientRate;
	}
	
	public String getImp() {
		return imp;
	}
	public void setImp(String imp) {
		this.imp = imp;
	}
	@Override
	public String toString() {
		return "ClientMaster [clientId=" + clientId + ", clientName=" + clientName + ", mandatorySkills="
				+ mandatorySkills + ", additionalSkills=" + additionalSkills + ", totalPositions=" + totalPositions
				+ ", sourcingRate=" + sourcingRate + ", type=" + type + ", profilesShared=" + profilesShared
				+ ", screenReject=" + screenReject + ", techInterview=" + techInterview + ", techRejects=" + techRejects
				+ ", finalSelect=" + finalSelect + ", candidateState=" + experiance + ", joiningDate=" + joiningDate
				+ ", insertedDate=" + insertedDate + ", updatedDate=" + updatedDate + ", location=" + location
				+ ", clientRate=" + clientRate + "]";
	}
	

}
