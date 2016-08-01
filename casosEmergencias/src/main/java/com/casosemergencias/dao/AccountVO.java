package com.casosemergencias.dao;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="salesforce.account")
public class AccountVO implements Serializable{
	
	private static final long serialVersionUID = 1L;


	//campo de Heroku
		//Used to track the IsDeleted field from Salesforce allowing Heroku Connect to handle deletes when polling for updates
		@Column(name = "isdeleted")
		private Boolean isDeleted;
		//campo de Heroku
		//Used to track the IsDeleted field from Salesforce allowing Heroku Connect to handle deletes when polling for updates
		@Column(name = "systemmodstamp")
		private Date systemDate;
		//campo de Heroku
		@Column(name = "_hc_lastop")
		private String hcLastop;
		//campo de Heroku
		@Column(name = "_hc_err")
		private String hcError;
		
		@Id
		@Column(name = "id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		
		@Column(name = "sfid")
		private String sfid;

		@Column(name = "name")
		private String name;
		
		@Column(name = "apellido_paterno__c")
		private String apellidoPaterno;
		
		@Column(name = "apellido_materno__c")
		private String apellidoMaterno;
		
		@Column(name = "tipo_de_identidad__c")
		private String tipoIdentidad;
		
//		@Column(name = "account__run__c")
//		private String accountRun;

		@Column(name = "fecha_nacimiento__c")
		private Date fechaNacimiento;
		
		@Column(name = "phone")
		private String phone;
		
		@Column(name = "tel_fono_secundario__c")
		private String telefonoSecundario;
		
		@Column(name = "email_principal__c")
		private String emailPrincipal;
		
		@Column(name = "email_secundario__c")
		private String emailSecundario;
		
		@Column(name = "direccion__c")
		private String direccion;
		
		@Column(name = "accountsource")
		private String accountsource;
		
		@Column(name = "id_empresa__c")
		private String idEmpresa;
		
		//Tipo de registro de cuenta
		

		public AccountVO(Boolean isDeleted, Date systemDate, String hcLastop, String hcError, Integer id, String sfid,
				String name, String apellidoPaterno, String apellidoMaterno, String tipoIdentidad, String accountRun,
				Date fechaNacimiento, String phone, String telefonoSecundario, String email, String emailSecundario,
				String direccion, String accountsource, String idEmpresa) {
			super();
			this.isDeleted = isDeleted;
			this.systemDate = systemDate;
			this.hcLastop = hcLastop;
			this.hcError = hcError;
			this.id = id;
			this.sfid = sfid;
			this.name = name;
			this.apellidoPaterno = apellidoPaterno;
			this.apellidoMaterno = apellidoMaterno;
			this.tipoIdentidad = tipoIdentidad;
			//this.accountRun = accountRun;
			this.fechaNacimiento = fechaNacimiento;
			this.phone = phone;
			this.telefonoSecundario = telefonoSecundario;
			this.emailPrincipal = emailPrincipal;
			this.emailSecundario = emailSecundario;
			this.direccion = direccion;
			this.accountsource = accountsource;
			this.idEmpresa = idEmpresa;
		}

		public AccountVO() {
			super();
		}

		public Boolean getIsDeleted() {
			return isDeleted;
		}

		public void setIsDeleted(Boolean isDeleted) {
			this.isDeleted = isDeleted;
		}

		public Date getSystemDate() {
			return systemDate;
		}

		public void setSystemDate(Date systemDate) {
			this.systemDate = systemDate;
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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getApellidoPaterno() {
			return apellidoPaterno;
		}

		public void setApellidoPaterno(String apellidoPaterno) {
			this.apellidoPaterno = apellidoPaterno;
		}

		public String getApellidoMaterno() {
			return apellidoMaterno;
		}

		public void setApellidoMaterno(String apellidoMaterno) {
			this.apellidoMaterno = apellidoMaterno;
		}

		public String getTipoIdentidad() {
			return tipoIdentidad;
		}

		public void setTipoIdentidad(String tipoIdentidad) {
			this.tipoIdentidad = tipoIdentidad;
		}

//		public String getAccountRun() {
//			return accountRun;
//		}
//
//		public void setAccountRun(String accountRun) {
//			this.accountRun = accountRun;
//		}

		public Date getFechaNacimiento() {
			return fechaNacimiento;
		}

		public void setFechaNacimiento(Date fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getTelefonoSecundario() {
			return telefonoSecundario;
		}

		public void setTelefonoSecundario(String telefonoSecundario) {
			this.telefonoSecundario = telefonoSecundario;
		}

		public String getEmailPrincipal() {
			return emailPrincipal;
		}

		public void setEmailPrincipal(String email) {
			this.emailPrincipal = email;
		}

		public String getEmailSecundario() {
			return emailSecundario;
		}

		public void setEmailSecundario(String emailSecundario) {
			this.emailSecundario = emailSecundario;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public String getAccountsource() {
			return accountsource;
		}

		public void setAccountsource(String accountsource) {
			this.accountsource = accountsource;
		}

		public String getIdEmpresa() {
			return idEmpresa;
		}

		public void setIdEmpresa(String idEmpresa) {
			this.idEmpresa = idEmpresa;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}


	
		
}
