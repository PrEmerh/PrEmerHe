package com.casosemergencias.logic;

import java.util.List;

import com.casosemergencias.model.Caso;
import com.casosemergencias.util.datatables.DataTableProperties;

public interface CaseService {
	
	public List<Caso> readAllCase(DataTableProperties propDatatable);
	
	public Caso readCaseBySfid(String sfid);

	public Integer getNumCasos(DataTableProperties propDatatable);
	
	public Caso readCaseById(Integer id);

	public Integer insertCase(Caso caso);
	
	public Integer updateCase(Caso caso);
}