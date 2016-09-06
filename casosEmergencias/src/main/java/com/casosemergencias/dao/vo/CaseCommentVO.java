package com.casosemergencias.dao.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.casosemergencias.model.CaseComment;

@Entity
@Table(name = "salesforce.casecomment")
public class CaseCommentVO extends ObjectVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//campo de Heroku
	//Used to track the IsDeleted field from Salesforce allowing Heroku Connect to handle deletes when polling for updates
	@Column(name = "isdeleted")
	private Boolean isDeleted;
	
	// campo de Heroku
	@Column(name = "_hc_lastop")
	private String hcLastop;
	// campo de Heroku
	@Column(name = "_hc_err")
	private String hcError;
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "sfid")
	private String sfid;
	
	@Column(name = "createdbyid")
	private String createdbyid;

	@Column(name = "createddate")
	private Date createddate;

	@Column(name = "ispublished")
	private Boolean ispublished;
	
	@Column(name = "parentid")
	private String caseid;
	
	@Column(name = "commentbody")
	private String comment;
	
	@Column(name = "creatorname")
	private String creatorname;
	
	@Column(name = "lastmodifieddate")
	private Date lastmodifieddate;
	
	@Column(name = "lastmodifiedbyid")
	private String lastmodifiedbyid;

	public CaseCommentVO(Boolean isDeleted, String hcLastop, String hcError, Integer id, String sfid,
			String createdbyid, Date createddate, Boolean ispublished, String caseid, String comment,
			String creatorname, Date lastmodifieddate, String lastmodifiedbyid) {
		super();
		this.isDeleted = isDeleted;
		this.hcLastop = hcLastop;
		this.hcError = hcError;
		this.id = id;
		this.sfid = sfid;
		this.createdbyid = createdbyid;
		this.createddate = createddate;
		this.ispublished = ispublished;
		this.caseid = caseid;
		this.comment = comment;
		this.creatorname = creatorname;
		this.lastmodifieddate = lastmodifieddate;
		this.lastmodifiedbyid = lastmodifiedbyid;
	}

	public CaseCommentVO() {
		super();
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getHcLastop() {
		return hcLastop;
	}

	public void setHcLastop(String hcLastop) {
		this.hcLastop = hcLastop;
	}

	public String getHcError() {
		return hcError;
	}

	public void setHcError(String hcError) {
		this.hcError = hcError;
	}

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

	public Boolean getIspublished() {
		return ispublished;
	}

	public void setIspublished(Boolean ispublished) {
		this.ispublished = ispublished;
	}

	public String getCaseid() {
		return caseid;
	}

	public void setCaseid(String caseid) {
		this.caseid = caseid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCreatorname() {
		return creatorname;
	}

	public void setCreatorname(String creatorname) {
		this.creatorname = creatorname;
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

	@Override
	public Object instantiateTargetLogic() {
		CaseComment caseComment = new CaseComment();
		return caseComment;
	}
	
	
	
}