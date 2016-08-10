package com.casosemergencias.logic;

import java.util.List;

import com.casosemergencias.model.Direccion;
import com.casosemergencias.util.DataTableProperties;

public interface DireccionService {
	public List<Direccion> listOfDireccionesTable();

	public Direccion readDireccionBySfid(String sfid);

	public List<Direccion> readAllDirecciones(DataTableProperties propDatatable);

	public Integer getNumDirecciones(DataTableProperties propDatatable);
}