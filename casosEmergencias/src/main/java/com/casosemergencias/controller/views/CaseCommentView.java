package com.casosemergencias.controller.views;

import java.util.Date;

import com.casosemergencias.model.CaseComment;

public class CaseCommentView extends ObjectView {
	
	 private Integer id;
	 private String sfid;
	 private String caseid;
	 private String createdbyid;
	 private Date createddate;
	 private String comment;
	 private Date lastmodifieddate;
	 private String lastmodifiedbyid;
	 private Boolean ispublished;
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSfid() {
		return sfid;
	}
	public void setSfid(String sfid) {
		this.sfid = sfid;
	}
	public String getCaseid() {
		return caseid;
	}
	public void setCaseid(String caseid) {
		this.caseid = caseid;
	}
	public String getCreatedbyid() {
		return createdbyid;
	}
	public void setCreatedbyid(String createdbyid) {
		this.createdbyid = createdbyid;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getLastmodifieddate() {
		return lastmodifieddate;
	}
	public void setLastmodifieddate(Date lastmodifieddate) {
		this.lastmodifieddate = lastmodifieddate;
	}
	public String getLastmodifiedbyid() {
		return lastmodifiedbyid;
	}
	public void setLastmodifiedbyid(String lastmodifiedbyid) {
		this.lastmodifiedbyid = lastmodifiedbyid;
	}
	public Boolean getIspublished() {
		return ispublished;
	}
	public void setIspublished(Boolean ispublished) {
		this.ispublished = ispublished;
	}
	@Override
	public Object instantiateTargetLogic() {
		CaseComment caseComment = new CaseComment();
		return caseComment;
	}


	 
}
