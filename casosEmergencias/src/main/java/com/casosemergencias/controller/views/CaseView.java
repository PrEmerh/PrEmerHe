package com.casosemergencias.controller.views;

import java.util.Date;
import java.util.Map;

import com.casosemergencias.dao.vo.PickListsVO;
import com.casosemergencias.model.Caso;
import com.casosemergencias.model.Contacto;
import com.casosemergencias.model.Cuenta;
import com.casosemergencias.model.Direccion;
import com.casosemergencias.model.Suministro;

public class CaseView extends ObjectView {

	private Integer id;
	private String sfid;
	private String numeroCaso;
	private String estado;
	private String numeroInservice;
	private String submotivo;
	private Date fechaApertura;
	private String subestado;
	private String nombreContacto;
	private String direccionSuministro;
	private String comuna;
	private String tiempoEstimacion;
	private String canalOrigen;
	private String canalOrigenLabel;
	private String nombreCuenta;
	private String suministro;
	private String direccion;
	private String estadoSuministro;
	private String peticion;
	private String peticionLabel;
	private String callCenter;
	private String editMode;
	private String type;
	private String typeLabel;
	private String description;
	private String condicionAgravante;
	private String canalNotificacion;
	private String telefonoContacto;
	private String emailNotificacion;
	private String facebook;
	private String twitter;
	private boolean actDatosContacto;
	private String respuestaAlCliente;
	private String favorabilidadDelCaso;
	private Date fechaEstimadaCierre;
	private String parent;
	private String propietarioCaso;	//owner
	private Date fechaCierre;
	private String tipoAtencionInterna;
	private Contacto contactoJoin;
	private String numeroMedidor;
	private Direccion direccionJoin;
	private Cuenta cuentaJoin;
	private Suministro suministroJoin;
	private String cuerpoMail;	
	private String asunto;	//subject
	private String tipoAtencionSEC;
	private String ani;
	private String descripcionEstado;
	
	/*Joins con picklist*/
	private String labelSubestadoPickList;
	private String labelSubmotivoPickList;
	private String labelCanalorigenPickList;//no existe
	/**/
	/*Mapas para mostrar los combos de caso*/
	private Map<String, String> mapStatus;
	private Map<String, String> mapSubStatus;
	private Map<String, String> mapPeticion;
	private Map<String, String> mapOrigin;
	private Map<String, String> mapCallCenter;
	private Map<String, String> mapSubMotivo;
	private Map<String, String> mapCondicionAgravante;
	private Map<String, String> mapCanalNotificacion;
	private Map<String, String> mapFavorabilidadCaso;
	/**/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumeroCaso() {
		return numeroCaso;
	}

	public void setNumeroCaso(String numeroCaso) {
		this.numeroCaso = numeroCaso;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNumeroInservice() {
		return numeroInservice;
	}
	public void setNumeroInservice(String numeroInservice) {
		this.numeroInservice = numeroInservice;
	}
	public String getSubmotivo() {
		return submotivo;
	}
	public void setSubmotivo(String submotivo) {
		this.submotivo = submotivo;
	}
	public Date getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	public String getSubestado() {
		return subestado;
	}
	public void setSubestado(String subestado) {
		this.subestado = subestado;
	}
	public String getNombreContacto() {
		return nombreContacto;
	}
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}
	public String getDireccionSuministro() {
		return direccionSuministro;
	}
	public void setDireccionSuministro(String direccionSuministro) {
		this.direccionSuministro = direccionSuministro;
	}
	public String getComuna() {
		return comuna;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	public String getTiempoEstimacion() {
		return tiempoEstimacion;
	}
	public void setTiempoEstimacion(String tiempoEstimacion) {
		this.tiempoEstimacion = tiempoEstimacion;
	}
	public String getCanalOrigen() {
		return canalOrigen;
	}
	public void setCanalOrigen(String canalOrigen) {
		this.canalOrigen = canalOrigen;
	}
	public String getNombreCuenta() {
		return nombreCuenta;
	}
	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}
	public String getEstadoSuministro() {
		return estadoSuministro;
	}
	public void setEstadoSuministro(String estadoSuministro) {
		this.estadoSuministro = estadoSuministro;
	}
	public String getSfid() {
		return sfid;
	}
	public void setSfid(String sfid) {
		this.sfid = sfid;
	}
	public String getPeticion() {
		return peticion;
	}
	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}
	public String getCallCenter() {
		return callCenter;
	}
	public void setCallCenter(String callCenter) {
		this.callCenter = callCenter;
	}

	public String getEditMode() {
		return editMode;
	}
	public void setEditMode(String editMode) {
		this.editMode = editMode;
	}
	
	public String getPeticionLabel() {
		return peticionLabel;
	}
	public void setPeticionLabel(String peticionLabel) {
		this.peticionLabel = peticionLabel;
	}
	
	public String getCanalOrigenLabel() {
		return canalOrigenLabel;
	}
	public void setCanalOrigenLabel(String canalOrigenLabel) {
		this.canalOrigenLabel = canalOrigenLabel;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getTypeLabel() {
		return typeLabel;
	}
	public void setTypeLabel(String typeLabel) {
		this.typeLabel = typeLabel;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCondicionAgravante() {
		return condicionAgravante;
	}
	public void setCondicionAgravante(String condicionAgravante) {
		this.condicionAgravante = condicionAgravante;
	}
	
	public String getCanalNotificacion() {
		return canalNotificacion;
	}
	public void setCanalNotificacion(String canalNotificacion) {
		this.canalNotificacion = canalNotificacion;
	}
	
	public String getTelefonoContacto() {
		return telefonoContacto;
	}
	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}
	
	public String getEmailNotificacion() {
		return emailNotificacion;
	}
	public void setEmailNotificacion(String emailNotificacion) {
		this.emailNotificacion = emailNotificacion;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	
	public boolean isActDatosContacto() {
		return actDatosContacto;
	}
	public void setActDatosContacto(boolean actDatosContacto) {
		this.actDatosContacto = actDatosContacto;
	}
	
	public String getSuministro() {
		return suministro;
	}
	public void setSuministro(String suministro) {
		this.suministro = suministro;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getRespuestaAlCliente() {
		return respuestaAlCliente;
	}
	public void setRespuestaAlCliente(String respuestaAlCliente) {
		this.respuestaAlCliente = respuestaAlCliente;
	}
	public String getFavorabilidadDelCaso() {
		return favorabilidadDelCaso;
	}
	public void setFavorabilidadDelCaso(String favorabilidadDelCaso) {
		this.favorabilidadDelCaso = favorabilidadDelCaso;
	}
	
	public Date getFechaEstimadaCierre() {
		return fechaEstimadaCierre;
	}
	public void setFechaEstimadaCierre(Date fechaEstimadaCierre) {
		this.fechaEstimadaCierre = fechaEstimadaCierre;
	}
	
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	
	public String getPropietarioCaso() {
		return propietarioCaso;
	}
	public void setPropietarioCaso(String propietarioCaso) {
		this.propietarioCaso = propietarioCaso;
	}
	public Date getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	public String getTipoAtencionInterna() {
		return tipoAtencionInterna;
	}
	public void setTipoAtencionInterna(String tipoAtencionInterna) {
		this.tipoAtencionInterna = tipoAtencionInterna;
	}
	public Contacto getContactoJoin() {
		return contactoJoin;
	}
	public void setContactoJoin(Contacto contactoJoin) {
		this.contactoJoin = contactoJoin;
	}
	public String getNumeroMedidor() {
		return numeroMedidor;
	}
	public void setNumeroMedidor(String numeroMedidor) {
		this.numeroMedidor = numeroMedidor;
	}
	public Direccion getDireccionJoin() {
		return direccionJoin;
	}
	public void setDireccionJoin(Direccion direccionJoin) {
		this.direccionJoin = direccionJoin;
	}
	public Cuenta getCuentaJoin() {
		return cuentaJoin;
	}
	public void setCuentaJoin(Cuenta cuentaJoin) {
		this.cuentaJoin = cuentaJoin;
	}
	public Suministro getSuministroJoin() {
		return suministroJoin;
	}
	public void setSuministroJoin(Suministro suministroJoin) {
		this.suministroJoin = suministroJoin;
	}
	public String getCuerpoMail() {
		return cuerpoMail;
	}
	public void setCuerpoMail(String cuerpoMail) {
		this.cuerpoMail = cuerpoMail;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getTipoAtencionSEC() {
		return tipoAtencionSEC;
	}
	public void setTipoAtencionSEC(String tipoAtencionSEC) {
		this.tipoAtencionSEC = tipoAtencionSEC;
	}
	public String getAni() {
		return ani;
	}
	public void setAni(String ani) {
		this.ani = ani;
	}
	public String getDescripcionEstado() {
		return descripcionEstado;
	}
	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}
	
	/*Joins con picklist*/	
	public String getLabelSubmotivoPickList() {
		return labelSubmotivoPickList;
	}
	public String getLabelSubestadoPickList() {
		return labelSubestadoPickList;
	}
	public void setLabelSubestadoPickList(String labelSubestadoPickList) {
		this.labelSubestadoPickList = labelSubestadoPickList;
	}
	public void setLabelSubmotivoPickList(String labelSubmotivoPickList) {
		this.labelSubmotivoPickList = labelSubmotivoPickList;
	}	
	public String getLabelCanalorigenPickList() {
		return labelCanalorigenPickList;
	}
	public void setLabelCanalorigenPickList(String labelCanalorigenPickList) {
		this.labelCanalorigenPickList = labelCanalorigenPickList;
	}
	/*Mapas combos*/
	public Map<String, String> getMapStatus() {
		return mapStatus;
	}
	public void setMapStatus(Map<String, String> mapStatus) {
		this.mapStatus = mapStatus;
	}
	public Map<String, String> getMapSubStatus() {
		return mapSubStatus;
	}
	public void setMapSubStatus(Map<String, String> mapSubStatus) {
		this.mapSubStatus = mapSubStatus;
	}
	public Map<String, String> getMapPeticion() {
		return mapPeticion;
	}
	public void setMapPeticion(Map<String, String> mapPeticion) {
		this.mapPeticion = mapPeticion;
	}
	public Map<String, String> getMapOrigin() {
		return mapOrigin;
	}
	public void setMapOrigin(Map<String, String> mapOrigin) {
		this.mapOrigin = mapOrigin;
	}
	public Map<String, String> getMapCallCenter() {
		return mapCallCenter;
	}
	public void setMapCallCenter(Map<String, String> mapCallCenter) {
		this.mapCallCenter = mapCallCenter;
	}
	public Map<String, String> getMapSubMotivo() {
		return mapSubMotivo;
	}
	public void setMapSubMotivo(Map<String, String> mapSubMotivo) {
		this.mapSubMotivo = mapSubMotivo;
	}
	public Map<String, String> getMapCondicionAgravante() {
		return mapCondicionAgravante;
	}
	public void setMapCondicionAgravante(Map<String, String> mapCondicionAgravante) {
		this.mapCondicionAgravante = mapCondicionAgravante;
	}
	public Map<String, String> getMapCanalNotificacion() {
		return mapCanalNotificacion;
	}
	public void setMapCanalNotificacion(Map<String, String> mapCanalNotificacion) {
		this.mapCanalNotificacion = mapCanalNotificacion;
	}
	public Map<String, String> getMapFavorabilidadCaso() {
		return mapFavorabilidadCaso;
	}
	public void setMapFavorabilidadCaso(Map<String, String> mapFavorabilidadCaso) {
		this.mapFavorabilidadCaso = mapFavorabilidadCaso;
	}
	/**/
	/*private Map<String, String> ordenarMapa(Map<String, String> mapa) {
		Map<String, String> sortedMap = null;
		if (mapa != null && !mapa.isEmpty()){
			//Convertir el mapa a lista
			List<Map.Entry<String, String>> list = new LinkedList<Map.Entry<String, String>>(mapa.entrySet());
	
			// Ordena con el comparador
			Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
				public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
					return (o1.getValue()).compareTo(o2.getValue());
				}
			});
			
			// Convert sorted map back to a Map
			sortedMap = new LinkedHashMap<String, String>();
			for (Iterator<Map.Entry<String, String>> it = list.iterator(); it.hasNext();) {
				Map.Entry<String, String> entry = it.next();
				sortedMap.put(entry.getKey(), entry.getValue());
			}
		}
		return sortedMap;
	}*/
	
	@Override
	public Object instantiateTargetLogic() {
		Caso caso = new Caso();
		return caso;
	}
}
