package com.casosemergencias.logic;

import java.util.List;

import com.casosemergencias.model.Contacto;
import com.casosemergencias.util.datatables.DataTableProperties;

public interface ContactService {
	public List<Contacto> listOfContactsTable();
	public Contacto readContactoBySfid(String sfid);
	public List<Contacto> readAllContactos(DataTableProperties propDatatable);
	public Integer getNumContactos(DataTableProperties propDatatable);
	public Boolean asociarSuministro(String sfid,String contactSfid);
}