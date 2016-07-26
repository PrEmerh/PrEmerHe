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
	private String coordenadaX;
	
	@Column(name = "id_empresa__c")
	private String idEmpresa;
	
	@Column(name = "departamento__c")
	private String departamento;
	
	@Column(name = "createdbyid")
	private String createdById;
	
	@Column(name = "comuna__c")
	private String comuna;
	
	@Column(name = "alias_nombre_calle__c")
	private String aliasNombreCalle;
	
	@Column(name = "regi_n__c")
	private String region;
	
	@Column(name = "tipo_de_calle__c")
	private String tipoCalle;
	
	@Column(name = "coordenadas_utm_x_y__longitude__s")
	private Double coordenadasUtmXYLongitude;
	
	@Column(name = "esquina__c")
	private String esquina;
	
	@Column(name = "id_via__c")
	private String idVia;
	
	@Column(name = "lastmodifiedbyid")
	private String lastModifiedById;
	
	@Column(name = "calle__c")
	private String calle;
	
	@Column(name = "coordenadas_utm_x_y__latitude__s")
	private Double coordenadasUtmXYLatitude;
	
	@Column(name = "coordenada_y__c")
	private String coordenadaY;
	
	@Column(name = "direccionconcatenada__c")
	private String direccionConcatenada;
	
	@Column(name = "altura__c")
	private String altura;
	
	@Column(name = "literalcomuna__c")
	private String literalComuna;

	public Direccion(Boolean isdeleted, Date systemmodstamp, String _hc_lastop, String _hc_err, Integer id, String sfid,
			Date createddate, String name, String ownerid, String coordenadaX, String idEmpresa, String departamento,
			String createdById, String comuna, String aliasNombreCalle, String region, String tipoCalle,
			Double coordenadasUtmXYLongitude, String esquina, String idVia, String lastModifiedById, String calle,
			Double coordenadasUtmXYLatitude, String coordenadaY, String direccionConcatenada, String altura,
			String literalComuna) {
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
		this.coordenadaX = coordenadaX;
		this.idEmpresa = idEmpresa;
		this.departamento = departamento;
		this.createdById = createdById;
		this.comuna = comuna;
		this.aliasNombreCalle = aliasNombreCalle;
		this.region = region;
		this.tipoCalle = tipoCalle;
		this.coordenadasUtmXYLongitude = coordenadasUtmXYLongitude;
		this.esquina = esquina;
		this.idVia = idVia;
		this.lastModifiedById = lastModifiedById;
		this.calle = calle;
		this.coordenadasUtmXYLatitude = coordenadasUtmXYLatitude;
		this.coordenadaY = coordenadaY;
		this.direccionConcatenada = direccionConcatenada;
		this.altura = altura;
		this.literalComuna = literalComuna;
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

	public String getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(String coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCreatedById() {
		return createdById;
	}

	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getAliasNombreCalle() {
		return aliasNombreCalle;
	}

	public void setAliasNombreCalle(String aliasNombreCalle) {
		this.aliasNombreCalle = aliasNombreCalle;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTipoCalle() {
		return tipoCalle;
	}

	public void setTipoCalle(String tipoCalle) {
		this.tipoCalle = tipoCalle;
	}

	public Double getCoordenadasUtmXYLongitude() {
		return coordenadasUtmXYLongitude;
	}

	public void setCoordenadasUtmXYLongitude(Double coordenadasUtmXYLongitude) {
		this.coordenadasUtmXYLongitude = coordenadasUtmXYLongitude;
	}

	public String getEsquina() {
		return esquina;
	}

	public void setEsquina(String esquina) {
		this.esquina = esquina;
	}

	public String getIdVia() {
		return idVia;
	}

	public void setIdVia(String idVia) {
		this.idVia = idVia;
	}

	public String getLastModifiedById() {
		return lastModifiedById;
	}

	public void setLastModifiedById(String lastModifiedById) {
		this.lastModifiedById = lastModifiedById;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Double getCoordenadasUtmXYLatitude() {
		return coordenadasUtmXYLatitude;
	}

	public void setCoordenadasUtmXYLatitude(Double coordenadasUtmXYLatitude) {
		this.coordenadasUtmXYLatitude = coordenadasUtmXYLatitude;
	}

	public String getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(String coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	public String getDireccionConcatenada() {
		return direccionConcatenada;
	}

	public void setDireccionConcatenada(String direccionConcatenada) {
		this.direccionConcatenada = direccionConcatenada;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getLiteralComuna() {
		return literalComuna;
	}

	public void setLiteralComuna(String literalComuna) {
		this.literalComuna = literalComuna;
	}

}
	