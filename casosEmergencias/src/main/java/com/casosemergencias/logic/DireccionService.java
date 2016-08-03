package com.casosemergencias.logic;

import java.util.List;

import com.casosemergencias.model.Direccion;

public interface DireccionService {
	
	public List<Direccion> listOfDireccionesTable();
	public Direccion readDireccionBySfid(String sfid);

}
