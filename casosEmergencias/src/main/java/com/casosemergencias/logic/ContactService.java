package com.casosemergencias.logic;

import java.util.List;
import com.casosemergencias.model.Contacto;
import com.casosemergencias.model.Direccion;

public interface ContactService {

	public List<Contacto> listOfContactsTable();
	public Contacto readContactoBySfid(String sfid);

	

}
