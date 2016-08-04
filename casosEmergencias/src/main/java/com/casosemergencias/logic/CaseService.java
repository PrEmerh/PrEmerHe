package com.casosemergencias.logic;

import java.util.List;

import com.casosemergencias.model.Caso;

public interface CaseService {
	
	public List<Caso> readAllCase();
	
	public Caso readCaseBySfid(String sfid);
	
	public Caso readCaseById(Integer id);

}
