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
@Table(name="salesforce.suministro__c")
public class SuministroVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//campo de Heroku
	//Used to track the IsDeleted field from Salesforce allowing Heroku Connect to handle deletes when polling for updates
	@Column(name = "isdeleted")
	private Boolean isDeleted;
	//campo de Heroku
	//The date and time (in the UTC time zone) that the Salesforce object was last modified and used by Heroku Connect when polling for updates
	@Column(name = "systemmodstamp")
	private Date systemDate;
	//campo de Heroku
	@Column(name = "_hc_lastop")
	private String hcLastop;
	//campo de Heroku
	@Column(name = "_hc_err")
	private String hcError;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "sfid")
	private String sfid;
	
	@Column(name = "createddate")
	private Date createdDate;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "full_electric__c")
	private String fullElectric;
	
	@Column(name = "casos_abiertos__c")
	private Boolean casosAbiertos;
	
	@Column(name = "tipo_de_transformador__c")
	private String tipoTransformador;
	
	@Column(name = "createdbyid")
	private String createdbyid;
	
	@Column(name = "corte_por_deuda__c")
	private Boolean cortePorDeuda;
	
	@Column(name = "tipo_lectura__c")
	private String tipoLectura;
	
	@Column(name = "estado_de_conexi_n__c")
	private String estadoConexion;
	
	@Column(name = "clasificaci_n_cliente__c")
	private String clasificacionCliente;
	
	@Column(name = "vip__c")
	private String vip;
	
	@Column(name = "tipo_de_medida__c")
	private String tipoMedida;
	
	@Column(name = "comuna_reparto__c")
	private String comunaReparto;
	
	@Column(name = "comuna__c")
	private String comuna;
	
	@Column(name = "n_mero_medidor__c")
	private String numeroMedidor;
	
	@Column(name = "dv_numero_suministro__c")
	private String dvNumeroSuministro;
	
	@Column(name = "datos_clientes_con_disciplina__c")
	private String datosClientesConDisciplina;
	
	@Column(name = "modelo_medidor__c")
	private String modeloMedidor;
	
	@Column(name = "n_mero_suministro__c")
	private String numeroSuministro;
	
	@Column(name = "numero_de_transformador__c")
	private String numeroTransformador;
	
	@Column(name = "condominio_sector__c")
	private String condominioSector;
	
	@Column(name = "proceso_de_lectura__c")
	private String procesoLectura;
	
	@Column(name = "ownerid")
	private String ownerid;
	
	@Column(name = "nombre_transformador__c")
	private String nombreTransformador;
	
	@Column(name = "estado_del_suministro__c")
	private String estadoSuministro;
	
	@Column(name = "marca_medidor__c")
	private String marcaMedidor;
	
	@Column(name = "fecha_de_corte__c")
	private Date fechaCorte;
	
	@Column(name = "propiedad_medidor__c")
	private String propiedadMedidor;
	
	@Column(name = "lastmodifiedbyid")
	private String lastmodifiedbyid;
	
	@Column(name = "id_empresa__c")
	private String idEmpresa;
	
	@Column(name = "direccion__c")
	private String direccion;
	
	@Column(name = "item_contrato__c")
	private String itemContrato;
	
	@Column(name = "run_rut__c")
	private String runRut;
	
	@Column(name = "pago_en_proceso__c")
	private Boolean pagoEnProceso;
	
	@Column(name = "nombre_due_o_boleta__c")
	private String nombreDuenoBoleta;
	
	@Column(name = "bloque__c")
	private String bloque;
	
	@Column(name = "tipo_de_conexi_n__c")
	private String tipoConexion;
	
	@Column(name = "punto_conexi_n_red__c")
	private String puntoConexionRed;
	
	@Column(name = "idcontactonavegacion__c")
	private String idcontactonavegacion;
	
	@Column(name = "direccion_cliente__c")
	private String direccionCliente;
	
	@Column(name = "electrodependiente__c")
	private String electrodependiente;
	
	@Column(name = "medida_de_disciplina__c")
	private String medidaDisciplina;
	
	@Column(name = "horario_de_racionamiento__c")
	private String horarioRacionamiento;
	
	@Column(name = "casos_reiterados__c")
	private Double casosReiterados;
	
	@Column(name = "zona_peligrosa__c")
	private Boolean zonaPeligrosa;
	
	@Column(name = "tarifa__c")
	private String tarifa;
	
	@Column(name = "tipo_de_vivienda__c")
	private String tipoVivienda;
	
	@Column(name = "tipo_de_agrupaci_n__c")
	private String tipoAgrupacion;
	
	@Column(name = "alimentador__c")
	private String alimentador;
	
	@Column(name = "direcci_n_de_boleta__c")
	private String direccionBoleta;
	
	@Column(name = "cuenta__c")
	private String cuenta;
	
	@Column(name = "subestaci_n_el_ctrica_conexi_n__c")
	private String subestacionElectricaConexion;
	
	@Column(name = "ruta__c")
	private String ruta;
	
	@Column(name = "direccionconcatenada__c")
	private String direccionconcatenada;
	
	@Column(name = "tipo_de_cuenta__c")
	private String tipoCuenta;
	
	@Column(name = "tipo_de_segmento__c")
	private String tipoSegmento;
	
	@Column(name = "tipo_de_servicio__c")
	private String tipoServicio;

	public SuministroVO(Boolean isDeleted, Date systemDate, String hcLastop, String hcError, Integer id, String sfid,
			Date createdDate, String name, String fullElectric, Boolean casosAbiertos, String tipoTransformador,
			String createdbyid, Boolean cortePorDeuda, String tipoLectura, String estadoConexion,
			String clasificacionCliente, String vip, String tipoMedida, String comunaReparto, String comuna,
			String numeroMedidor, String dvNumeroSuministro, String datosClientesConDisciplina,
			String modeloMedidor, String numeroSuministro, String numeroTransformador, String condominioSector,
			String procesoLectura, String ownerid, String nombreTransformador, String estadoSuministro,
			String marcaMedidor, Date fechaCorte, String propiedadMedidor, String lastmodifiedbyid,
			String idEmpresa, String direccion, String itemContrato, String runRut, Boolean pagoEnProceso,
			String nombreDuenoBoleta, String bloque, String tipoConexion, String puntoConexionRed,
			String idcontactonavegacion, String direccionCliente, String electrodependiente,
			String medidaDisciplina, String horarioRacionamiento, Double casosReiterados,
			Boolean zonaPeligrosa, String tarifa, String tipoVivienda, String tipoAgrupacion,
			String alimentador, String direccionBoleta, String cuenta, String subestacionElectricaConexion,
			String ruta, String direccionconcatenada, String tipoCuenta, String tipoSegmento,
			String tipoServicio) {
		super();
		this.isDeleted = isDeleted;
		this.systemDate = systemDate;
		this.hcLastop = hcLastop;
		this.hcError = hcError;
		this.id = id;
		this.sfid = sfid;
		this.createdDate = createdDate;
		this.name = name;
		this.fullElectric = fullElectric;
		this.casosAbiertos = casosAbiertos;
		this.tipoTransformador = tipoTransformador;
		this.createdbyid = createdbyid;
		this.cortePorDeuda = cortePorDeuda;
		this.tipoLectura = tipoLectura;
		this.estadoConexion = estadoConexion;
		this.clasificacionCliente = clasificacionCliente;
		this.vip = vip;
		this.tipoMedida = tipoMedida;
		this.comunaReparto = comunaReparto;
		this.comuna = comuna;
		this.numeroMedidor = numeroMedidor;
		this.dvNumeroSuministro = dvNumeroSuministro;
		this.datosClientesConDisciplina = datosClientesConDisciplina;
		this.modeloMedidor = modeloMedidor;
		this.numeroSuministro = numeroSuministro;
		this.numeroTransformador = numeroTransformador;
		this.condominioSector = condominioSector;
		this.procesoLectura = procesoLectura;
		this.ownerid = ownerid;
		this.nombreTransformador = nombreTransformador;
		this.estadoSuministro = estadoSuministro;
		this.marcaMedidor = marcaMedidor;
		this.fechaCorte = fechaCorte;
		this.propiedadMedidor = propiedadMedidor;
		this.lastmodifiedbyid = lastmodifiedbyid;
		this.idEmpresa = idEmpresa;
		this.direccion = direccion;
		this.itemContrato = itemContrato;
		this.runRut = runRut;
		this.pagoEnProceso = pagoEnProceso;
		this.nombreDuenoBoleta = nombreDuenoBoleta;
		this.bloque = bloque;
		this.tipoConexion = tipoConexion;
		this.puntoConexionRed = puntoConexionRed;
		this.idcontactonavegacion = idcontactonavegacion;
		this.direccionCliente = direccionCliente;
		this.electrodependiente = electrodependiente;
		this.medidaDisciplina = medidaDisciplina;
		this.horarioRacionamiento = horarioRacionamiento;
		this.casosReiterados = casosReiterados;
		this.zonaPeligrosa = zonaPeligrosa;
		this.tarifa = tarifa;
		this.tipoVivienda = tipoVivienda;
		this.tipoAgrupacion = tipoAgrupacion;
		this.alimentador = alimentador;
		this.direccionBoleta = direccionBoleta;
		this.cuenta = cuenta;
		this.subestacionElectricaConexion = subestacionElectricaConexion;
		this.ruta = ruta;
		this.direccionconcatenada = direccionconcatenada;
		this.tipoCuenta = tipoCuenta;
		this.tipoSegmento = tipoSegmento;
		this.tipoServicio = tipoServicio;
	}

	public SuministroVO() {
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullElectric() {
		return fullElectric;
	}

	public void setFullElectric(String fullElectric) {
		this.fullElectric = fullElectric;
	}

	public Boolean getCasosAbiertos() {
		return casosAbiertos;
	}

	public void setasosAbiertos(Boolean casosAbiertos) {
		this.casosAbiertos = casosAbiertos;
	}

	public String getTipoTransformador() {
		return tipoTransformador;
	}

	public void setTipoTransformador(String tipoTransformador) {
		this.tipoTransformador = tipoTransformador;
	}

	public String getCreatedbyid() {
		return createdbyid;
	}

	public void setCreatedbyid(String createdbyid) {
		this.createdbyid = createdbyid;
	}

	public Boolean getCortePorDeuda() {
		return cortePorDeuda;
	}

	public void setCorte_por_deuda(Boolean cortePorDeuda) {
		this.cortePorDeuda = cortePorDeuda;
	}

	public String getTipoLectura() {
		return tipoLectura;
	}

	public void setTipoLectura(String tipoLectura) {
		this.tipoLectura = tipoLectura;
	}

	public String getEstadoConexion() {
		return estadoConexion;
	}

	public void setEstadoConexion(String estadoConexion) {
		this.estadoConexion = estadoConexion;
	}

	public String getClasificacionCliente() {
		return clasificacionCliente;
	}

	public void setClasificacionCliente(String clasificacionCliente) {
		this.clasificacionCliente = clasificacionCliente;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public String getTipoMedida() {
		return tipoMedida;
	}

	public void setTipoMedida(String tipoMedida) {
		this.tipoMedida = tipoMedida;
	}

	public String getComunaReparto() {
		return comunaReparto;
	}

	public void setComunaReparto(String comunaReparto) {
		this.comunaReparto = comunaReparto;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getNumeroMedidor() {
		return numeroMedidor;
	}

	public void setNumeroMedidor(String numeroMedidor) {
		this.numeroMedidor = numeroMedidor;
	}

	public String getDvNumeroSuministro() {
		return dvNumeroSuministro;
	}

	public void setDvNumeroSuministro(String dvNumeroSuministro) {
		this.dvNumeroSuministro = dvNumeroSuministro;
	}

	public String getDatosClientesConDisciplina() {
		return datosClientesConDisciplina;
	}

	public void setDatosClientesConDisciplina(String datosClientesConDisciplina) {
		this.datosClientesConDisciplina = datosClientesConDisciplina;
	}

	public String getModeloMedidor() {
		return modeloMedidor;
	}

	public void setModeloMedidor(String modeloMedidor) {
		this.modeloMedidor = modeloMedidor;
	}

	public String getNumeroSuministro() {
		return numeroSuministro;
	}

	public void setNumeroSuministro(String numeroSuministro) {
		this.numeroSuministro = numeroSuministro;
	}

	public String getNumeroTransformador() {
		return numeroTransformador;
	}

	public void setNumeroTransformador(String numeroTransformador) {
		this.numeroTransformador = numeroTransformador;
	}

	public String getCondominioSector() {
		return condominioSector;
	}

	public void setCondominioSector(String condominioSector) {
		this.condominioSector = condominioSector;
	}

	public String getProcesoLectura() {
		return procesoLectura;
	}

	public void setProcesoLectura(String procesoLectura) {
		this.procesoLectura = procesoLectura;
	}

	public String getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}

	public String getNombreTransformador() {
		return nombreTransformador;
	}

	public void setNombreTransformador(String nombreTransformador) {
		this.nombreTransformador = nombreTransformador;
	}

	public String getEstadoSuministro() {
		return estadoSuministro;
	}

	public void setEstadoSuministro(String estadoSuministro) {
		this.estadoSuministro = estadoSuministro;
	}

	public String getMarcaMedidor() {
		return marcaMedidor;
	}

	public void setMarcaMedidor(String marcaMedidor) {
		this.marcaMedidor = marcaMedidor;
	}

	public Date getFechaCorte() {
		return fechaCorte;
	}

	public void setFechaCorte(Date fechaCorte) {
		this.fechaCorte = fechaCorte;
	}

	public String getPropiedadMedidor() {
		return propiedadMedidor;
	}

	public void setPropiedadMedidor(String propiedadMedidor) {
		this.propiedadMedidor = propiedadMedidor;
	}

	public String getLastmodifiedbyid() {
		return lastmodifiedbyid;
	}

	public void setLastmodifiedbyid(String lastmodifiedbyid) {
		this.lastmodifiedbyid = lastmodifiedbyid;
	}

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getItemContrato() {
		return itemContrato;
	}

	public void setItemContrato(String itemContrato) {
		this.itemContrato = itemContrato;
	}

	public String getRunRut() {
		return runRut;
	}

	public void setRunRut(String runRut) {
		this.runRut = runRut;
	}

	public Boolean getPagoEnProceso() {
		return pagoEnProceso;
	}

	public void setPagoEnProceso(Boolean pagoEnProceso) {
		this.pagoEnProceso = pagoEnProceso;
	}

	public String getNombreDuenoBoleta() {
		return nombreDuenoBoleta;
	}

	public void setNombreDuenoBoleta(String nombreDuenoBoleta) {
		this.nombreDuenoBoleta = nombreDuenoBoleta;
	}

	public String getBloque() {
		return bloque;
	}

	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

	public String getPuntoConexionRed() {
		return puntoConexionRed;
	}

	public void setPuntoConexionRed(String puntoConexionRed) {
		this.puntoConexionRed = puntoConexionRed;
	}

	public String getIdcontactonavegacion() {
		return idcontactonavegacion;
	}

	public void setIdcontactonavegacion(String idcontactonavegacion) {
		this.idcontactonavegacion = idcontactonavegacion;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getElectrodependiente() {
		return electrodependiente;
	}

	public void setElectrodependiente(String electrodependiente) {
		this.electrodependiente = electrodependiente;
	}

	public String getMedidaDisciplina() {
		return medidaDisciplina;
	}

	public void setMedidaDisciplina(String medidaDisciplina) {
		this.medidaDisciplina = medidaDisciplina;
	}

	public String getHorarioRacionamiento() {
		return horarioRacionamiento;
	}

	public void setHorarioRacionamiento(String horarioRacionamiento) {
		this.horarioRacionamiento = horarioRacionamiento;
	}

	public Double getCasosReiterados() {
		return casosReiterados;
	}

	public void setCasosReiterados(Double casosReiterados) {
		this.casosReiterados = casosReiterados;
	}

	public Boolean getZonaPeligrosa() {
		return zonaPeligrosa;
	}

	public void setZonaPeligrosa(Boolean zonaPeligrosa) {
		this.zonaPeligrosa = zonaPeligrosa;
	}

	public String getTarifa() {
		return tarifa;
	}

	public void setTarifa(String tarifa) {
		this.tarifa = tarifa;
	}

	public String getTipoVivienda() {
		return tipoVivienda;
	}

	public void setTipoVivienda(String tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}

	public String getTipoAgrupacion() {
		return tipoAgrupacion;
	}

	public void setTipoAgrupacion(String tipoAgrupacion) {
		this.tipoAgrupacion = tipoAgrupacion;
	}

	public String getAlimentador() {
		return alimentador;
	}

	public void setAlimentador(String alimentador) {
		this.alimentador = alimentador;
	}

	public String getDireccionBoleta() {
		return direccionBoleta;
	}

	public void setDireccionBoleta(String direccionBoleta) {
		this.direccionBoleta = direccionBoleta;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getSubestacionElectricaConexion() {
		return subestacionElectricaConexion;
	}

	public void setSubestacionElectricaConexion(String subestacionElectricaConexion) {
		this.subestacionElectricaConexion = subestacionElectricaConexion;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getDireccionconcatenada() {
		return direccionconcatenada;
	}

	public void setDireccionconcatenada(String direccionconcatenada) {
		this.direccionconcatenada = direccionconcatenada;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public String getTipoSegmento() {
		return tipoSegmento;
	}

	public void setTipoSegmento(String tipoSegmento) {
		this.tipoSegmento = tipoSegmento;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}


}