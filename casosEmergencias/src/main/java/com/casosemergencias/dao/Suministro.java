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
public class Suministro implements Serializable{
	
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
	
	@Column(name = "full_electric__c")
	private String full_electric;
	
	@Column(name = "casos_abiertos__c")
	private Boolean casos_abiertos;
	
	@Column(name = "tipo_de_transformador__c")
	private String tipo_de_transformador;
	
	@Column(name = "createdbyid")
	private String createdbyid;
	
	@Column(name = "corte_por_deuda__c")
	private String corte_por_deuda;
	
	@Column(name = "tipo_lectura__c")
	private String tipo_lectura;
	
	@Column(name = "estado_de_conexi_n__c")
	private String estado_de_conexi_n;
	
	@Column(name = "clasificaci_n_cliente__c")
	private String clasificaci_n_cliente;
	
	@Column(name = "vip__c")
	private String vip;
	
	@Column(name = "tipo_de_medida__c")
	private String tipo_de_medida;
	
	@Column(name = "comuna_reparto__c")
	private String comuna_reparto;
	
	@Column(name = "comuna__c")
	private String comuna;
	
	@Column(name = "n_mero_medidor__c")
	private String n_mero_medidor;
	
	@Column(name = "dv_numero_suministro__c")
	private String dv_numero_suministro;
	
	@Column(name = "datos_clientes_con_disciplina__c")
	private String datos_clientes_con_disciplina;
	
	@Column(name = "modelo_medidor__c")
	private String modelo_medidor;
	
	@Column(name = "n_mero_suministro__c")
	private String n_mero_suministro;
	
	@Column(name = "numero_de_transformador__c")
	private String numero_de_transformador;
	
	@Column(name = "ncondominio_sector__came")
	private String condominio_sector;
	
	@Column(name = "proceso_de_lectura__c")
	private String proceso_de_lectura;
	
	@Column(name = "ownerid")
	private String ownerid;
	
	@Column(name = "nombre_transformador__c")
	private String nombre_transformador;
	
	@Column(name = "estado_del_suministro__c")
	private String estado_del_suministro;
	
	@Column(name = "marca_medidor__c")
	private String marca_medidor;
	
	@Column(name = "fecha_de_corte__c")
	private Date namefecha_de_corte;
	
	@Column(name = "propiedad_medidor__c")
	private String propiedad_medidor;
	
	@Column(name = "lastmodifiedbyid")
	private String lastmodifiedbyid;
	
	@Column(name = "id_empresa__c")
	private String id_empresa;
	
	@Column(name = "direccion__c")
	private String direccion;
	
	@Column(name = "item_contrato__c")
	private String item_contrato;
	
	@Column(name = "run_rut__c")
	private String run_rut;
	
	@Column(name = "pago_en_proceso__c")
	private Boolean pago_en_proceso;
	
	@Column(name = "nombre_due_o_boleta__c")
	private String nombre_due_o_boleta;
	
	@Column(name = "bloque__c")
	private String bloque;
	
	@Column(name = "tipo_de_conexi_n__c")
	private String tipo_de_conexi_n;
	
	@Column(name = "punto_conexi_n_red__c")
	private String punto_conexi_n_red;
	
	@Column(name = "idcontactonavegacion__c")
	private String idcontactonavegacion;
	
	@Column(name = "direccion_cliente__c")
	private String direccion_cliente;
	
	@Column(name = "electrodependiente__c")
	private String electrodependiente;
	
	@Column(name = "medida_de_disciplina__c")
	private String medida_de_disciplina;
	
	@Column(name = "horario_de_racionamiento__c")
	private String horario_de_racionamiento;
	
	@Column(name = "casos_reiterados__c")
	private Double casos_reiterados;
	
	@Column(name = "zona_peligrosa__c")
	private Boolean zona_peligrosa;
	
	@Column(name = "tarifa__c")
	private String tarifa;
	
	@Column(name = "tipo_de_vivienda__c")
	private String tipo_de_vivienda;
	
	@Column(name = "tipo_de_agrupaci_n__c")
	private String tipo_de_agrupaci_n;
	
	@Column(name = "alimentador__c")
	private String alimentador;
	
	@Column(name = "direcci_n_de_boleta__c")
	private String direcci_n_de_boleta;
	
	@Column(name = "cuenta__c")
	private String cuenta;
	
	@Column(name = "subestaci_n_el_ctrica_conexi_n__c")
	private String subestaci_n_el_ctrica_conexi_n;
	
	@Column(name = "ruta__c")
	private String ruta;
	
	@Column(name = "direccionconcatenada__c")
	private String direccionconcatenada;
	
	@Column(name = "tipo_de_cuenta__c")
	private String tipo_de_cuenta;
	
	@Column(name = "tipo_de_segmento__c")
	private String tipo_de_segmento;
	
	@Column(name = "tipo_de_servicio__c")
	private String tipo_de_servicio;

	public Suministro(Boolean isdeleted, Date systemmodstamp, String _hc_lastop, String _hc_err, Integer id,
			String sfid, Date createddate, String name, String full_electric, Boolean casos_abiertos,
			String tipo_de_transformador, String createdbyid, String corte_por_deuda, String tipo_lectura,
			String estado_de_conexi_n, String clasificaci_n_cliente, String vip, String tipo_de_medida,
			String comuna_reparto, String comuna, String n_mero_medidor, String dv_numero_suministro,
			String datos_clientes_con_disciplina, String modelo_medidor, String n_mero_suministro,
			String numero_de_transformador, String condominio_sector, String proceso_de_lectura, String ownerid,
			String nombre_transformador, String estado_del_suministro, String marca_medidor, Date namefecha_de_corte,
			String propiedad_medidor, String lastmodifiedbyid, String id_empresa, String direccion,
			String item_contrato, String run_rut, Boolean pago_en_proceso, String nombre_due_o_boleta, String bloque,
			String tipo_de_conexi_n, String punto_conexi_n_red, String idcontactonavegacion, String direccion_cliente,
			String electrodependiente, String medida_de_disciplina, String horario_de_racionamiento,
			Double casos_reiterados, Boolean zona_peligrosa, String tarifa, String tipo_de_vivienda,
			String tipo_de_agrupaci_n, String alimentador, String direcci_n_de_boleta, String cuenta,
			String subestaci_n_el_ctrica_conexi_n, String ruta, String direccionconcatenada, String tipo_de_cuenta,
			String tipo_de_segmento, String tipo_de_servicio) {
		super();
		this.isdeleted = isdeleted;
		this.systemmodstamp = systemmodstamp;
		this._hc_lastop = _hc_lastop;
		this._hc_err = _hc_err;
		this.id = id;
		this.sfid = sfid;
		this.createddate = createddate;
		this.name = name;
		this.full_electric = full_electric;
		this.casos_abiertos = casos_abiertos;
		this.tipo_de_transformador = tipo_de_transformador;
		this.createdbyid = createdbyid;
		this.corte_por_deuda = corte_por_deuda;
		this.tipo_lectura = tipo_lectura;
		this.estado_de_conexi_n = estado_de_conexi_n;
		this.clasificaci_n_cliente = clasificaci_n_cliente;
		this.vip = vip;
		this.tipo_de_medida = tipo_de_medida;
		this.comuna_reparto = comuna_reparto;
		this.comuna = comuna;
		this.n_mero_medidor = n_mero_medidor;
		this.dv_numero_suministro = dv_numero_suministro;
		this.datos_clientes_con_disciplina = datos_clientes_con_disciplina;
		this.modelo_medidor = modelo_medidor;
		this.n_mero_suministro = n_mero_suministro;
		this.numero_de_transformador = numero_de_transformador;
		this.condominio_sector = condominio_sector;
		this.proceso_de_lectura = proceso_de_lectura;
		this.ownerid = ownerid;
		this.nombre_transformador = nombre_transformador;
		this.estado_del_suministro = estado_del_suministro;
		this.marca_medidor = marca_medidor;
		this.namefecha_de_corte = namefecha_de_corte;
		this.propiedad_medidor = propiedad_medidor;
		this.lastmodifiedbyid = lastmodifiedbyid;
		this.id_empresa = id_empresa;
		this.direccion = direccion;
		this.item_contrato = item_contrato;
		this.run_rut = run_rut;
		this.pago_en_proceso = pago_en_proceso;
		this.nombre_due_o_boleta = nombre_due_o_boleta;
		this.bloque = bloque;
		this.tipo_de_conexi_n = tipo_de_conexi_n;
		this.punto_conexi_n_red = punto_conexi_n_red;
		this.idcontactonavegacion = idcontactonavegacion;
		this.direccion_cliente = direccion_cliente;
		this.electrodependiente = electrodependiente;
		this.medida_de_disciplina = medida_de_disciplina;
		this.horario_de_racionamiento = horario_de_racionamiento;
		this.casos_reiterados = casos_reiterados;
		this.zona_peligrosa = zona_peligrosa;
		this.tarifa = tarifa;
		this.tipo_de_vivienda = tipo_de_vivienda;
		this.tipo_de_agrupaci_n = tipo_de_agrupaci_n;
		this.alimentador = alimentador;
		this.direcci_n_de_boleta = direcci_n_de_boleta;
		this.cuenta = cuenta;
		this.subestaci_n_el_ctrica_conexi_n = subestaci_n_el_ctrica_conexi_n;
		this.ruta = ruta;
		this.direccionconcatenada = direccionconcatenada;
		this.tipo_de_cuenta = tipo_de_cuenta;
		this.tipo_de_segmento = tipo_de_segmento;
		this.tipo_de_servicio = tipo_de_servicio;
	}

	public Suministro() {
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

	public String getFull_electric() {
		return full_electric;
	}

	public void setFull_electric(String full_electric) {
		this.full_electric = full_electric;
	}

	public Boolean getCasos_abiertos() {
		return casos_abiertos;
	}

	public void setCasos_abiertos(Boolean casos_abiertos) {
		this.casos_abiertos = casos_abiertos;
	}

	public String getTipo_de_transformador() {
		return tipo_de_transformador;
	}

	public void setTipo_de_transformador(String tipo_de_transformador) {
		this.tipo_de_transformador = tipo_de_transformador;
	}

	public String getCreatedbyid() {
		return createdbyid;
	}

	public void setCreatedbyid(String createdbyid) {
		this.createdbyid = createdbyid;
	}

	public String getCorte_por_deuda() {
		return corte_por_deuda;
	}

	public void setCorte_por_deuda(String corte_por_deuda) {
		this.corte_por_deuda = corte_por_deuda;
	}

	public String getTipo_lectura() {
		return tipo_lectura;
	}

	public void setTipo_lectura(String tipo_lectura) {
		this.tipo_lectura = tipo_lectura;
	}

	public String getEstado_de_conexi_n() {
		return estado_de_conexi_n;
	}

	public void setEstado_de_conexi_n(String estado_de_conexi_n) {
		this.estado_de_conexi_n = estado_de_conexi_n;
	}

	public String getClasificaci_n_cliente() {
		return clasificaci_n_cliente;
	}

	public void setClasificaci_n_cliente(String clasificaci_n_cliente) {
		this.clasificaci_n_cliente = clasificaci_n_cliente;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public String getTipo_de_medida() {
		return tipo_de_medida;
	}

	public void setTipo_de_medida(String tipo_de_medida) {
		this.tipo_de_medida = tipo_de_medida;
	}

	public String getComuna_reparto() {
		return comuna_reparto;
	}

	public void setComuna_reparto(String comuna_reparto) {
		this.comuna_reparto = comuna_reparto;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getN_mero_medidor() {
		return n_mero_medidor;
	}

	public void setN_mero_medidor(String n_mero_medidor) {
		this.n_mero_medidor = n_mero_medidor;
	}

	public String getDv_numero_suministro() {
		return dv_numero_suministro;
	}

	public void setDv_numero_suministro(String dv_numero_suministro) {
		this.dv_numero_suministro = dv_numero_suministro;
	}

	public String getDatos_clientes_con_disciplina() {
		return datos_clientes_con_disciplina;
	}

	public void setDatos_clientes_con_disciplina(String datos_clientes_con_disciplina) {
		this.datos_clientes_con_disciplina = datos_clientes_con_disciplina;
	}

	public String getModelo_medidor() {
		return modelo_medidor;
	}

	public void setModelo_medidor(String modelo_medidor) {
		this.modelo_medidor = modelo_medidor;
	}

	public String getN_mero_suministro() {
		return n_mero_suministro;
	}

	public void setN_mero_suministro(String n_mero_suministro) {
		this.n_mero_suministro = n_mero_suministro;
	}

	public String getNumero_de_transformador() {
		return numero_de_transformador;
	}

	public void setNumero_de_transformador(String numero_de_transformador) {
		this.numero_de_transformador = numero_de_transformador;
	}

	public String getCondominio_sector() {
		return condominio_sector;
	}

	public void setCondominio_sector(String condominio_sector) {
		this.condominio_sector = condominio_sector;
	}

	public String getProceso_de_lectura() {
		return proceso_de_lectura;
	}

	public void setProceso_de_lectura(String proceso_de_lectura) {
		this.proceso_de_lectura = proceso_de_lectura;
	}

	public String getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}

	public String getNombre_transformador() {
		return nombre_transformador;
	}

	public void setNombre_transformador(String nombre_transformador) {
		this.nombre_transformador = nombre_transformador;
	}

	public String getEstado_del_suministro() {
		return estado_del_suministro;
	}

	public void setEstado_del_suministro(String estado_del_suministro) {
		this.estado_del_suministro = estado_del_suministro;
	}

	public String getMarca_medidor() {
		return marca_medidor;
	}

	public void setMarca_medidor(String marca_medidor) {
		this.marca_medidor = marca_medidor;
	}

	public Date getNamefecha_de_corte() {
		return namefecha_de_corte;
	}

	public void setNamefecha_de_corte(Date namefecha_de_corte) {
		this.namefecha_de_corte = namefecha_de_corte;
	}

	public String getPropiedad_medidor() {
		return propiedad_medidor;
	}

	public void setPropiedad_medidor(String propiedad_medidor) {
		this.propiedad_medidor = propiedad_medidor;
	}

	public String getLastmodifiedbyid() {
		return lastmodifiedbyid;
	}

	public void setLastmodifiedbyid(String lastmodifiedbyid) {
		this.lastmodifiedbyid = lastmodifiedbyid;
	}

	public String getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(String id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getItem_contrato() {
		return item_contrato;
	}

	public void setItem_contrato(String item_contrato) {
		this.item_contrato = item_contrato;
	}

	public String getRun_rut() {
		return run_rut;
	}

	public void setRun_rut(String run_rut) {
		this.run_rut = run_rut;
	}

	public Boolean getPago_en_proceso() {
		return pago_en_proceso;
	}

	public void setPago_en_proceso(Boolean pago_en_proceso) {
		this.pago_en_proceso = pago_en_proceso;
	}

	public String getNombre_due_o_boleta() {
		return nombre_due_o_boleta;
	}

	public void setNombre_due_o_boleta(String nombre_due_o_boleta) {
		this.nombre_due_o_boleta = nombre_due_o_boleta;
	}

	public String getBloque() {
		return bloque;
	}

	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

	public String getTipo_de_conexi_n() {
		return tipo_de_conexi_n;
	}

	public void setTipo_de_conexi_n(String tipo_de_conexi_n) {
		this.tipo_de_conexi_n = tipo_de_conexi_n;
	}

	public String getPunto_conexi_n_red() {
		return punto_conexi_n_red;
	}

	public void setPunto_conexi_n_red(String punto_conexi_n_red) {
		this.punto_conexi_n_red = punto_conexi_n_red;
	}

	public String getIdcontactonavegacion() {
		return idcontactonavegacion;
	}

	public void setIdcontactonavegacion(String idcontactonavegacion) {
		this.idcontactonavegacion = idcontactonavegacion;
	}

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	public String getElectrodependiente() {
		return electrodependiente;
	}

	public void setElectrodependiente(String electrodependiente) {
		this.electrodependiente = electrodependiente;
	}

	public String getMedida_de_disciplina() {
		return medida_de_disciplina;
	}

	public void setMedida_de_disciplina(String medida_de_disciplina) {
		this.medida_de_disciplina = medida_de_disciplina;
	}

	public String getHorario_de_racionamiento() {
		return horario_de_racionamiento;
	}

	public void setHorario_de_racionamiento(String horario_de_racionamiento) {
		this.horario_de_racionamiento = horario_de_racionamiento;
	}

	public Double getCasos_reiterados() {
		return casos_reiterados;
	}

	public void setCasos_reiterados(Double casos_reiterados) {
		this.casos_reiterados = casos_reiterados;
	}

	public Boolean getZona_peligrosa() {
		return zona_peligrosa;
	}

	public void setZona_peligrosa(Boolean zona_peligrosa) {
		this.zona_peligrosa = zona_peligrosa;
	}

	public String getTarifa() {
		return tarifa;
	}

	public void setTarifa(String tarifa) {
		this.tarifa = tarifa;
	}

	public String getTipo_de_vivienda() {
		return tipo_de_vivienda;
	}

	public void setTipo_de_vivienda(String tipo_de_vivienda) {
		this.tipo_de_vivienda = tipo_de_vivienda;
	}

	public String getTipo_de_agrupaci_n() {
		return tipo_de_agrupaci_n;
	}

	public void setTipo_de_agrupaci_n(String tipo_de_agrupaci_n) {
		this.tipo_de_agrupaci_n = tipo_de_agrupaci_n;
	}

	public String getAlimentador() {
		return alimentador;
	}

	public void setAlimentador(String alimentador) {
		this.alimentador = alimentador;
	}

	public String getDirecci_n_de_boleta() {
		return direcci_n_de_boleta;
	}

	public void setDirecci_n_de_boleta(String direcci_n_de_boleta) {
		this.direcci_n_de_boleta = direcci_n_de_boleta;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getSubestaci_n_el_ctrica_conexi_n() {
		return subestaci_n_el_ctrica_conexi_n;
	}

	public void setSubestaci_n_el_ctrica_conexi_n(String subestaci_n_el_ctrica_conexi_n) {
		this.subestaci_n_el_ctrica_conexi_n = subestaci_n_el_ctrica_conexi_n;
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

	public String getTipo_de_cuenta() {
		return tipo_de_cuenta;
	}

	public void setTipo_de_cuenta(String tipo_de_cuenta) {
		this.tipo_de_cuenta = tipo_de_cuenta;
	}

	public String getTipo_de_segmento() {
		return tipo_de_segmento;
	}

	public void setTipo_de_segmento(String tipo_de_segmento) {
		this.tipo_de_segmento = tipo_de_segmento;
	}

	public String getTipo_de_servicio() {
		return tipo_de_servicio;
	}

	public void setTipo_de_servicio(String tipo_de_servicio) {
		this.tipo_de_servicio = tipo_de_servicio;
	}
	
	
	

	

	
}