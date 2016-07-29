package com.casosemergencias.logic;

import java.util.Map;

public interface PickListsService {
	
	Map<String, Map<String, String>> getPickListPorObjeto(String objeto);
	
	Map<String, String> getPickListPorCampo(String objeto, String campo);

}
