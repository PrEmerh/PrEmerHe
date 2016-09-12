package com.casosemergencias.dao.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.casosemergencias.model.Suministro;

@Entity
@Table(name = "salesforce.suministro__c")
public class SuministroVO extends ObjectVO implements Serializable {

	private static final long serialVersionUID = 1L;

	// campo de Heroku
	// Used to track the IsDeleted field from Salesforce allowing Heroku Connect
	// to handle deletes when polling for updates
	@Column(name = "isdeleted")
	private Boolean isDeleted;
	// campo de Heroku
	// The date and time (in the UTC time zone) that the Salesforce object was
	// last modified and used by Heroku Connect when polling for updates
	@Column(name = "systemmodstamp")
	private Date systemDate;
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

	@Column(name = "name")
	private String name;

	@Column(name = "full_electric__c")
	private String fullElectric;

	@Column(name = "casos_abiertos__c")
	private Boolean casosAbiertos;

	@Column(name = "tipo_de_transformador__c")
	private String tipoTransformador;

	@Column(name = "corte_por_deuda__c")
	private Boolean cortePorDeuda;

	@Column(name = "tipo_lectura__c")
	private String tipoLectura;

	@Column(name = "proceso_de_lectura__c")
	private String procesoLectura;

	@Column(name = "estado_de_conexi_n__c")
	private String estadoConexion;

	@Column(name = "tipo_de_medida__c")
	private String tipoMedida;

	@Column(name = "comuna_reparto__c")
	private String comunaReparto;

	@Column(name = "comuna__c")
	private String comuna;

	@Column(name = "n_mero_medidor__c")
	private String numeroMedidor;

	@Column(name = "modelo_medidor__c")
	private String modeloMedidor;

	@Column(name = "n_mero_suministro__c")
	private String numeroSuministro;

	@Column(name = "numero_de_transformador__c")
	private String numeroTransformador;

	@Column(name = "estado_del_suministro__c")
	private String estadoSuministro;

	@Column(name = "marca_medidor__c")
	private String marcaMedidor;

	@Column(name = "fecha_de_corte__c")
	private Date fechaCorte;

	@Column(name = "propiedad_medidor__c")
	private String propiedadMedidor;

	@Column(name = "id_empresa__c")
	private String idEmpresa;

	@Column(name = "direccion__c")
	private String direccion;

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

	@Column(name = "direccion_cliente__c")
	private String direccionCliente;

	@Column(name = "electrodependiente__c")
	private String electrodependiente;

	@Column(name = "Datos_Clientes_con_Disciplina__c")//lo cambiamos por como está en SF, alli hay una variable de cada tipo, pero la que lleva información es esta.
	private String medidaDisciplina;

	@Column(name = "horario_de_racionamiento__c")
	private String horarioRacionamiento;

	@Column(name = "casos_reiterados__c")
	private Double casosReiterados;

	@Column(name = "tarifa__c")
	private String tarifa;

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

	@Column(name = "tipo_de_cuenta__c")
	private String tipoCuenta;

	@Column(name = "tipo_de_segmento__c")
	private String tipoSegmento;

	@Column(name = "DireccionConcatenada__c")
	private String direccionConcatenada;

	@Column(name = "tipoevento__c")
	private String tipoEvento;

	@Column(name = "suministroafectado__c")
	private Boolean suministroAfectado;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "proceso_de_lectura__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	@Where(clause = "objeto='suministro__c'  AND campo='Proceso_de_Lectura__c'")
	private PickListsVO procesoLecturaPickList;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_de_medida__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	@Where(clause = "objeto='suministro__c'  AND campo='Tipo_de_medida__c'")
	private PickListsVO tipoMedidaPickList;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_de_segmento__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	private PickListsSumTipoSegmentoVO tipoSegmentoPickList;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "subestaci_n_el_ctrica_conexi_n__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	private PickListsSumSubestacionElecVO subestacionElecPickList;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "propiedad_medidor__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	private PickListsSumPropiedadMedidorVO propMedidorPickList;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_de_conexi_n__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	private PickListsSumTipoConexionVO tipoConexionPickList;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_lectura__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	private PickListsSumTipoLecturaVO tipoLecturaPickList;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_de_transformador__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	private PickListsSumTipoTransfVO tipoTransformadorPickList;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "comuna_reparto__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	private PickListsSumComunaRepartoVO comunaRepartoPickList;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "full_electric__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	private PickListsSumFullElectricVO fullElectricPickList;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Datos_Clientes_con_Disciplina__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	private PickListsSumMedidaDisciplinaVO medidaDisciplinaPickList;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_empresa__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	private PickListsSumEmpresaVO empresaPickList;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estado_de_conexi_n__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	private PickListsSumEstadoConVO estadoConexionPickList;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estado_del_suministro__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	private PickListsSumEstadoSumVO estadoSuministroPickList;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "electrodependiente__c", referencedColumnName = "codigo", insertable = false, updatable = false)
	private PickListsSumElectrodependienteVO electrodependientePickList;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cuenta__c", referencedColumnName = "sfid", insertable = false, updatable = false)
	private AccountVO cuentaJoin;
	
	@OneToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumn(name="direccion__c", referencedColumnName="sfid", insertable = false, updatable=false)
	private DireccionVO dirSuministroJoin;

	public SuministroVO() {
	}

	public SuministroVO(Boolean isDeleted, Date systemDate, String hcLastop, String hcError, Integer id, String sfid,
			String name, String fullElectric, Boolean casosAbiertos, String tipoTransformador, Boolean cortePorDeuda,
			String tipoLectura, String procesoLectura, String estadoConexion, String tipoMedida, String comunaReparto,
			String comuna, String numeroMedidor, String modeloMedidor, String numeroSuministro,
			String numeroTransformador, String estadoSuministro, String marcaMedidor, Date fechaCorte,
			String propiedadMedidor, String idEmpresa, String direccion, String runRut, Boolean pagoEnProceso,
			String nombreDuenoBoleta, String bloque, String tipoConexion, String direccionCliente,
			String electrodependiente, String medidaDisciplina, String horarioRacionamiento, Double casosReiterados,
			String tarifa, String alimentador, String direccionBoleta, String cuenta,
			String subestacionElectricaConexion, String ruta, String tipoCuenta, String tipoSegmento,
			String direccionConcatenada, String tipoEvento, Boolean suministroAfectado,
			PickListsSumEmpresaVO empresaPickList, PickListsSumEstadoConVO estadoConexionPickList,
			PickListsSumEstadoSumVO estadoSuministroPickList,PickListsSumElectrodependienteVO electrodependientePickList) {
		super();
		this.isDeleted = isDeleted;
		this.systemDate = systemDate;
		this.hcLastop = hcLastop;
		this.hcError = hcError;
		this.id = id;
		this.sfid = sfid;
		this.name = name;
		this.fullElectric = fullElectric;
		this.casosAbiertos = casosAbiertos;
		this.tipoTransformador = tipoTransformador;
		this.cortePorDeuda = cortePorDeuda;
		this.tipoLectura = tipoLectura;
		this.procesoLectura = procesoLectura;
		this.estadoConexion = estadoConexion;
		this.tipoMedida = tipoMedida;
		this.comunaReparto = comunaReparto;
		this.comuna = comuna;
		this.numeroMedidor = numeroMedidor;
		this.modeloMedidor = modeloMedidor;
		this.numeroSuministro = numeroSuministro;
		this.numeroTransformador = numeroTransformador;
		this.estadoSuministro = estadoSuministro;
		this.marcaMedidor = marcaMedidor;
		this.fechaCorte = fechaCorte;
		this.propiedadMedidor = propiedadMedidor;
		this.idEmpresa = idEmpresa;
		this.direccion = direccion;
		this.runRut = runRut;
		this.pagoEnProceso = pagoEnProceso;
		this.nombreDuenoBoleta = nombreDuenoBoleta;
		this.bloque = bloque;
		this.tipoConexion = tipoConexion;
		this.direccionCliente = direccionCliente;
		this.electrodependiente = electrodependiente;
		this.medidaDisciplina = medidaDisciplina;
		this.horarioRacionamiento = horarioRacionamiento;
		this.casosReiterados = casosReiterados;
		this.tarifa = tarifa;
		this.alimentador = alimentador;
		this.direccionBoleta = direccionBoleta;
		this.cuenta = cuenta;
		this.subestacionElectricaConexion = subestacionElectricaConexion;
		this.ruta = ruta;
		this.tipoCuenta = tipoCuenta;
		this.tipoSegmento = tipoSegmento;
		this.direccionConcatenada = direccionConcatenada;
		this.tipoEvento = tipoEvento;
		this.suministroAfectado = suministroAfectado;
		this.empresaPickList = empresaPickList;
		this.estadoConexionPickList = estadoConexionPickList;
		this.estadoSuministroPickList = estadoSuministroPickList;
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

	public String getFullElectric() {
		return fullElectric;
	}

	public void setFullElectric(String fullElectric) {
		this.fullElectric = fullElectric;
	}

	public Boolean getCasosAbiertos() {
		return casosAbiertos;
	}

	public void setCasosAbiertos(Boolean casosAbiertos) {
		this.casosAbiertos = casosAbiertos;
	}

	public String getTipoTransformador() {
		return tipoTransformador;
	}

	public void setTipoTransformador(String tipoTransformador) {
		this.tipoTransformador = tipoTransformador;
	}

	public Boolean getCortePorDeuda() {
		return cortePorDeuda;
	}

	public void setCortePorDeuda(Boolean cortePorDeuda) {
		this.cortePorDeuda = cortePorDeuda;
	}

	public String getTipoLectura() {
		return tipoLectura;
	}

	public void setTipoLectura(String tipoLectura) {
		this.tipoLectura = tipoLectura;
	}

	public String getProcesoLectura() {
		return procesoLectura;
	}

	public void setProcesoLectura(String procesoLectura) {
		this.procesoLectura = procesoLectura;
	}

	public String getEstadoConexion() {
		return estadoConexion;
	}

	public void setEstadoConexion(String estadoConexion) {
		this.estadoConexion = estadoConexion;
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

	public String getTarifa() {
		return tarifa;
	}

	public void setTarifa(String tarifa) {
		this.tarifa = tarifa;
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

	public String getDireccionConcatenada() {
		return direccionConcatenada;
	}

	public void setDireccionConcatenada(String direccionConcatenada) {
		this.direccionConcatenada = direccionConcatenada;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Boolean getSuministroAfectado() {
		return suministroAfectado;
	}

	public void setSuministroAfectado(Boolean suministroAfectado) {
		this.suministroAfectado = suministroAfectado;
	}

	public PickListsSumEmpresaVO getEmpresaPickList() {
		return empresaPickList;
	}

	public void setEmpresaPickList(PickListsSumEmpresaVO empresaPickList) {
		this.empresaPickList = empresaPickList;
	}

	public PickListsSumEstadoConVO getEstadoConexionPickList() {
		return estadoConexionPickList;
	}

	public void setEstadoConexionPickList(PickListsSumEstadoConVO estadoConexionPickList) {
		this.estadoConexionPickList = estadoConexionPickList;
	}

	public PickListsSumEstadoSumVO getEstadoSuministroPickList() {
		return estadoSuministroPickList;
	}

	public void setEstadoSuministroPickList(PickListsSumEstadoSumVO estadoSuministroPickList) {
		this.estadoSuministroPickList = estadoSuministroPickList;
	}
	

	public PickListsSumElectrodependienteVO getElectrodependientePickList() {
		return electrodependientePickList;
	}

	public void setElectrodependientePickList(PickListsSumElectrodependienteVO electrodependientePickList) {
		this.electrodependientePickList = electrodependientePickList;
	}

	public String getLabelEmpresaPickList() {
		String result = this.getIdEmpresa();
		if (this.getEmpresaPickList() != null) {
			result = this.getEmpresaPickList().getValor();
		}
		return result;
	}

	public String getLabelEstadoConexionPickList() {
		String result = this.getEstadoConexion();
		if (this.getEstadoConexionPickList() != null) {
			result = this.getEstadoConexionPickList().getValor();
		}
		return result;
	}

	public String getLabelEstadoSuministroPickList() {
		String result = this.getEstadoSuministro();
		if (this.getEstadoSuministroPickList() != null) {
			result = this.getEstadoSuministroPickList().getValor();
		}
		return result;
	}

	public String getLabelElectrodependientePickList() {
		String result = this.getElectrodependiente();
		if (this.getElectrodependientePickList() != null) {
			result = this.getElectrodependientePickList().getValor();
		}
		return result;
	}

	@Override
	public Object instantiateTargetLogic() {
		Suministro suministro = new Suministro();
		return suministro;
	}

	public AccountVO getCuentaJoin() {
		return cuentaJoin;
	}

	public void setCuentaJoin(AccountVO cuentaJoin) {
		this.cuentaJoin = cuentaJoin;
	}

	public DireccionVO getDirSuministroJoin() {
		return dirSuministroJoin;
	}

	public void setDirSuministroJoin(DireccionVO dirSuministroJoin) {
		this.dirSuministroJoin = dirSuministroJoin;
	}

	public PickListsVO getProcesoLecturaPickList() {
		return procesoLecturaPickList;
	}
	public String getLabelProcesoLecturaPickList() {
		String result = this.getProcesoLectura();
		if (this.getProcesoLecturaPickList() != null) {
			result = this.getProcesoLecturaPickList().getValor();
		}
		return result;
	}

	public void setProcesoLecturaPickList(PickListsVO procesoLecturaPickList) {
		this.procesoLecturaPickList = procesoLecturaPickList;
	}

	public PickListsVO getTipoMedidaPickList() {
		return tipoMedidaPickList;
	}
	public String getLabelTipoMedidaPickList() {
		String result = this.getTipoMedida();
		if (this.getTipoMedidaPickList() != null) {
			result = this.getTipoMedidaPickList().getValor();
		}
		return result;
	}

	public void setTipoMedidaPickList(PickListsVO tipoMedidaPickList) {
		this.tipoMedidaPickList = tipoMedidaPickList;
	}

	public PickListsSumTipoSegmentoVO getTipoSegmentoPickList() {
		return tipoSegmentoPickList;
	}

	public String getLabelTipoSegmentoPickList() {
		String result = this.getTipoSegmento();
		if (this.getTipoSegmentoPickList() != null) {
			result = this.getTipoSegmentoPickList().getValor();
		}
		return result;
	}
	
	public void setTipoSegmentoPickList(PickListsSumTipoSegmentoVO tipoSegmentoPickList) {
		this.tipoSegmentoPickList = tipoSegmentoPickList;
	}

	public PickListsSumSubestacionElecVO getSubestacionElecPickList() {
		return subestacionElecPickList;
	}
	public String getLabelSubestacionElecPickList() {
		String result = this.getSubestacionElectricaConexion();
		if (this.getSubestacionElecPickList() != null) {
			result = this.getSubestacionElecPickList().getValor();
		}
		return result;
	}
	public void setSubestacionElecPickList(PickListsSumSubestacionElecVO subestacionElecPickList) {
		this.subestacionElecPickList = subestacionElecPickList;
	}

	public PickListsSumPropiedadMedidorVO getPropMedidorPickList() {
		return propMedidorPickList;
	}

	public String getLabelPropMedidorPickList() {
		String result = this.getPropiedadMedidor();
		if (this.getPropMedidorPickList() != null) {
			result = this.getPropMedidorPickList().getValor();
		}
		return result;
	}
	
	public void setPropMedidorPickList(PickListsSumPropiedadMedidorVO propMedidorPickList) {
		this.propMedidorPickList = propMedidorPickList;
	}

	public PickListsSumTipoConexionVO getTipoConexionPickList() {
		return tipoConexionPickList;
	}
	public String getLabelTipoConexionPickList() {
		String result = this.getTipoConexion();
		if (this.getTipoConexionPickList() != null) {
			result = this.getTipoConexionPickList().getValor();
		}
		return result;
	}
	public void setTipoConexionPickList(PickListsSumTipoConexionVO tipoConexionPickList) {
		this.tipoConexionPickList = tipoConexionPickList;
	}

	public PickListsSumTipoLecturaVO getTipoLecturaPickList() {
		return tipoLecturaPickList;
	}
	public String getLabelTipoLecturaPickList() {
		String result = this.getTipoLectura();
		if (this.getTipoLecturaPickList() != null) {
			result = this.getTipoLecturaPickList().getValor();
		}
		return result;
	}

	public void setTipoLecturaPickList(PickListsSumTipoLecturaVO tipoLecturaPickList) {
		this.tipoLecturaPickList = tipoLecturaPickList;
	}

	public PickListsSumTipoTransfVO getTipoTransformadorPickList() {
		return tipoTransformadorPickList;
	}
	public String getLabelTipoTransformadorPickList() {
		String result = this.getTipoTransformador();
		if (this.getTipoTransformadorPickList() != null) {
			result = this.getTipoTransformadorPickList().getValor();
		}
		return result;
	}
	public void setTipoTransformadorPickList(PickListsSumTipoTransfVO tipoTransformadorPickList) {
		this.tipoTransformadorPickList = tipoTransformadorPickList;
	}

	public PickListsSumComunaRepartoVO getComunaRepartoPickList() {
		return comunaRepartoPickList;
	}
	public String getLabelComunaRepartoPickList() {
		String result = this.getComunaReparto();
		if (this.getComunaRepartoPickList() != null) {
			result = this.getComunaRepartoPickList().getValor();
		}
		return result;
	}
	public void setComunaRepartoPickList(PickListsSumComunaRepartoVO comunaRepartoPickList) {
		this.comunaRepartoPickList = comunaRepartoPickList;
	}

	public PickListsSumFullElectricVO getFullElectricPickList() {
		return fullElectricPickList;
	}
	public String getLabelFullElectricPickList() {
		String result = this.getFullElectric();
		if (this.getFullElectricPickList() != null) {
			result = this.getFullElectricPickList().getValor();
		}
		return result;
	}
	public void setFullElectricPickList(PickListsSumFullElectricVO fullElectricPickList) {
		this.fullElectricPickList = fullElectricPickList;
	}

	public PickListsSumMedidaDisciplinaVO getMedidaDisciplinaPickList() {
		return medidaDisciplinaPickList;
	}
	
	public String getLabelMedidaDisciplinaPickList() {
		String result = this.getMedidaDisciplina();
		if (this.getMedidaDisciplinaPickList() != null) {
			result = this.getMedidaDisciplinaPickList().getValor();
		}
		return result;
	}

	public void setMedidaDisciplinaPickList(PickListsSumMedidaDisciplinaVO medidaDisciplinaPickList) {
		this.medidaDisciplinaPickList = medidaDisciplinaPickList;
	}
}