package com.casosemergencias.dao.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salesforce.casehistory")
public class CaseHistoryVO extends ObjectVO implements Serializable {
	
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
	
	@Column(name = "newvalue")
	private String newvalue;
	
	@Column(name = "oldvalue")
	private String oldvalue;
	
	@Column(name = "field")
	private String field;
	
	@Column(name = "caseid")
	private String caseid;

	public CaseHistoryVO(Boolean isDeleted, String hcLastop, String hcError, Integer id, String sfid,
			String createdbyid, Date createddate, String newvalue, String oldvalue, String field, String caseid) {
		super();
		this.isDeleted = isDeleted;
		this.hcLastop = hcLastop;
		this.hcError = hcError;
		this.id = id;
		this.sfid = sfid;
		this.createdbyid = createdbyid;
		this.createddate = createddate;
		this.newvalue = newvalue;
		this.oldvalue = oldvalue;
		this.field = field;
		this.caseid = caseid;
	}

	public CaseHistoryVO(){
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

	public String getNewvalue() {
		return newvalue;
	}

	public void setNewvalue(String newvalue) {
		this.newvalue = newvalue;
	}

	public String getOldvalue() {
		return oldvalue;
	}

	public void setOldvalue(String oldvalue) {
		this.oldvalue = oldvalue;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getCaseid() {
		return caseid;
	}

	public void setCaseid(String caseid) {
		this.caseid = caseid;
	}

	@Override
	public Object instantiateTargetLogic() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
