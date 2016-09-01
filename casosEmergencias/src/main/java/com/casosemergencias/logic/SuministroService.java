package com.casosemergencias.logic;

import java.util.List;

import com.casosemergencias.model.Suministro;
import com.casosemergencias.util.DataTableProperties;

public interface SuministroService {
	
	/*Alvaro modificado*/
	public List<Suministro> readAllSuministros(DataTableProperties propDatatable);

	public Suministro readSuministroBySfid(String id);
	/*Alvaro añadido*/
	public Integer getNumSuministros(DataTableProperties propDatatable);
}
