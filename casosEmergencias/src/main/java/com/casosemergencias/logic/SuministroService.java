package com.casosemergencias.logic;

import java.util.List;

import com.casosemergencias.model.Suministro;

public interface SuministroService {
	
	public List<Suministro> readAllSuministros();

	public Suministro readSuministroById(String id);

}
