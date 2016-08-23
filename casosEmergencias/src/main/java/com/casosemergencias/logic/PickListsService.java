package com.casosemergencias.logic;

import java.util.List;
import java.util.Map;

import com.casosemergencias.model.PickList;

public interface PickListsService {
	Map<String, Map<String, String>> getPickListPorObjeto(String objeto);
	
	Map<String, String> getPickListPorCampo(String objeto, String campo);
	
	List<PickList> getPickListPorObjetoYCampo(String objeto, String campo);
}