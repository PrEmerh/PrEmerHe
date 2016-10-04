package com.casosemergencias.logic;

import java.util.List;

import com.casosemergencias.model.Suministro;
import com.casosemergencias.util.datatables.DataTableProperties;

public interface SuministroService {
	
	public List<Suministro> readAllSuministros();	
	public List<Suministro> readAllSuministros(DataTableProperties propDatatable);
	public Suministro readSuministroBySfid(String id);	
	public List<Suministro> readSuministrosAsociarContacto(DataTableProperties propDatatable);
	public Integer getNumSuministros(DataTableProperties propDatatable);
	public Integer getNumSuministrosDeUnaCuetna(String sfidCuenta);
	public List<Suministro> readSuministrosCuenta(String sfidCuenta, Integer numeroSuministros);
	
}