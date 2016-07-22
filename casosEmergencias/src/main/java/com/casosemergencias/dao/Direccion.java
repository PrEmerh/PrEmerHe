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
@Table(name="salesforce.direccion__c")
public class Direccion implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//campo de Heroku
	//Used to track the IsDeleted field from Salesforce allowing Heroku Connect to handle deletes when polling for updates
	@Column(name = "isdeleted")
	private Boolean isdeleted;
	//campo de Heroku
	//Used to track the IsDeleted field from Salesforce allowing Heroku Connect to handle deletes when polling for updates
	@Column(name = "systemmodstamp")
	private Date systemmodstamp;
	//campo de Heroku
	@Column(name = "_hc_lastop")
	private String _hc_lastop;
	//campo de Heroku
	@Column(name = "_hc_err")
	private String _hc_err;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "sfid")
	private String sfid;
	
	@Column(name = "createddate")
	private Date createddate;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "ownerid")
	private String ownerid;
	
	@Column(name = "coordenada_x__c")
	private String coordenada_x;
	
	@Column(name = "id_empresa__c")
	private String id_empresa;
	
	@Column(name = "departamento__c")
	private String departamento;
	
	@Column(name = "createdbyid")
	private String createdbyid;
	
	@Column(name = "comuna__c")
	private String comuna;
	
	@Column(name = "alias_nombre_calle__c")
	private String alias_nombre_calle;
	
	@Column(name = "regi_n__c")
	private String regi_n;
	
	@Column(name = "tipo_de_calle__c")
	private String tipo_de_calle;
	
	@Column(name = "coordenadas_utm_x_y__longitude__s")
	private Double coordenadas_utm_x_y__longitude__s;
	
	@Column(name = "esquina__c")
	private String esquina;
	
	@Column(name = "id_via__c")
	private String id_via;
	
	@Column(name = "lastmodifiedbyid")
	private String lastmodifiedbyid;
	
	@Column(name = "calle__c")
	private String calle;
	
	@Column(name = "coordenadas_utm_x_y__latitude__s")
	private Double coordenadas_utm_x_y__latitude__s;
	
	@Column(name = "coordenada_y__c")
	private String coordenada_y;
	
	@Column(name = "direccionconcatenada__c")
	private String direccionconcatenada;
	
	@Column(name = "altura__c")
	private String altura;
	
	@Column(name = "literalcomuna__c")
	private String literalcomuna;

	public Direccion(Boolean isdeleted, Date systemmodstamp, String _hc_lastop, String _hc_err, Integer id, String sfid,
			Date createddate, String name, String ownerid, String coordenada_x, String id_empresa, String departamento,
			String createdbyid, String comuna, String alias_nombre_calle, String regi_n, String tipo_de_calle,
			Double coordenadas_utm_x_y__longitude__s, String esquina, String id_via, String lastmodifiedbyid,
			String calle, Double coordenadas_utm_x_y__latitude__s, String coordenada_y, String direccionconcatenada,
			String altura, String literalcomuna) {
		super();
		this.isdeleted = isdeleted;
		this.systemmodstamp = systemmodstamp;
		this._hc_lastop = _hc_lastop;
		this._hc_err = _hc_err;
		this.id = id;
		this.sfid = sfid;
		this.createddate = createddate;
		this.name = name;
		this.ownerid = ownerid;
		this.coordenada_x = coordenada_x;
		this.id_empresa = id_empresa;
		this.departamento = departamento;
		this.createdbyid = createdbyid;
		this.comuna = comuna;
		this.alias_nombre_calle = alias_nombre_calle;
		this.regi_n = regi_n;
		this.tipo_de_calle = tipo_de_calle;
		this.coordenadas_utm_x_y__longitude__s = coordenadas_utm_x_y__longitude__s;
		this.esquina = esquina;
		this.id_via = id_via;
		this.lastmodifiedbyid = lastmodifiedbyid;
		this.calle = calle;
		this.coordenadas_utm_x_y__latitude__s = coordenadas_utm_x_y__latitude__s;
		this.coordenada_y = coordenada_y;
		this.direccionconcatenada = direccionconcatenada;
		this.altura = altura;
		this.literalcomuna = literalcomuna;
	}

	public Direccion() {
		super();
	}

	public Boolean getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(Boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Date getSystemmodstamp() {
		return systemmodstamp;
	}

	public void setSystemmodstamp(Date systemmodstamp) {
		this.systemmodstamp = systemmodstamp;
	}

	public String get_hc_lastop() {
		return _hc_lastop;
	}

	public void set_hc_lastop(String _hc_lastop) {
		this._hc_lastop = _hc_lastop;
	}

	public String get_hc_err() {
		return _hc_err;
	}

	public void set_hc_err(String _hc_err) {
		this._hc_err = _hc_err;
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

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}

	public String getCoordenada_x() {
		return coordenada_x;
	}

	public void setCoordenada_x(String coordenada_x) {
		this.coordenada_x = coordenada_x;
	}

	public String getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(String id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCreatedbyid() {
		return createdbyid;
	}

	public void setCreatedbyid(String createdbyid) {
		this.createdbyid = createdbyid;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getAlias_nombre_calle() {
		return alias_nombre_calle;
	}

	public void setAlias_nombre_calle(String alias_nombre_calle) {
		this.alias_nombre_calle = alias_nombre_calle;
	}

	public String getRegi_n() {
		return regi_n;
	}

	public void setRegi_n(String regi_n) {
		this.regi_n = regi_n;
	}

	public String getTipo_de_calle() {
		return tipo_de_calle;
	}

	public void setTipo_de_calle(String tipo_de_calle) {
		this.tipo_de_calle = tipo_de_calle;
	}

	public Double getCoordenadas_utm_x_y__longitude__s() {
		return coordenadas_utm_x_y__longitude__s;
	}

	public void setCoordenadas_utm_x_y__longitude__s(Double coordenadas_utm_x_y__longitude__s) {
		this.coordenadas_utm_x_y__longitude__s = coordenadas_utm_x_y__longitude__s;
	}

	public String getEsquina() {
		return esquina;
	}

	public void setEsquina(String esquina) {
		this.esquina = esquina;
	}

	public String getId_via() {
		return id_via;
	}

	public void setId_via(String id_via) {
		this.id_via = id_via;
	}

	public String getLastmodifiedbyid() {
		return lastmodifiedbyid;
	}

	public void setLastmodifiedbyid(String lastmodifiedbyid) {
		this.lastmodifiedbyid = lastmodifiedbyid;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Double getCoordenadas_utm_x_y__latitude__s() {
		return coordenadas_utm_x_y__latitude__s;
	}

	public void setCoordenadas_utm_x_y__latitude__s(Double coordenadas_utm_x_y__latitude__s) {
		this.coordenadas_utm_x_y__latitude__s = coordenadas_utm_x_y__latitude__s;
	}

	public String getCoordenada_y() {
		return coordenada_y;
	}

	public void setCoordenada_y(String coordenada_y) {
		this.coordenada_y = coordenada_y;
	}

	public String getDireccionconcatenada() {
		return direccionconcatenada;
	}

	public void setDireccionconcatenada(String direccionconcatenada) {
		this.direccionconcatenada = direccionconcatenada;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getLiteralcomuna() {
		return literalcomuna;
	}

	public void setLiteralcomuna(String literalcomuna) {
		this.literalcomuna = literalcomuna;
	}
	
	
	
	
	
	
}
	