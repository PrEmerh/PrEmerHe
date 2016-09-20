package com.casosemergencias.controller.views;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.casosemergencias.dao.vo.CasosReiteradosVO;
import com.casosemergencias.dao.vo.ObjectVO;
import com.casosemergencias.model.CasosReiterados;

//Objeto que tiene el modelo de un CasosReiterados, se utiliza en el Servicio
public class CasosReiteradosView extends ObjectView {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String sfid;
	private String name;
	private Double numCasos;
	private Double numDias;

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

	public Double getNumCasos() {
		return numCasos;
	}

	public void setNumCasos(Double numCasos) {
		this.numCasos = numCasos;
	}

	public Double getNumDias() {
		return numDias;
	}

	public void setNumDias(Double numDias) {
		this.numDias = numDias;
	}

	@Override
	public Object instantiateTargetLogic() {
		CasosReiterados casoReit = new CasosReiterados();
		return casoReit;
	}

	
}
