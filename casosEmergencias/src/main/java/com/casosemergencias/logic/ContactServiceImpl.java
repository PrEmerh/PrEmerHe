package com.casosemergencias.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.casosemergencias.dao.ContactVO;
import com.casosemergencias.dao.ContactDAO;
import com.casosemergencias.model.Contacto;
import com.casosemergencias.util.ParserModelVO;


//las transacciones se abren y cierran aqui
public class ContactServiceImpl implements ContactService{
	
	final static Logger logger = Logger.getLogger(ContactService.class);
	
	@Autowired
	private ContactDAO contactDao;
		
	/**
	 * Metodo que devuelve una lista de todos los contactos a mostrar en la tabla de nuestra app.
	 * @return listofallcontacts
	 */
	@Override
	public List<Contacto> listOfContactsTable() {
		
		List<Contacto> listOfContactsTable= new ArrayList<Contacto>();
		List<ContactVO> listOfAllContacts =new ArrayList<ContactVO>();
		listOfAllContacts=contactDao.readAllContact();
		Contacto contacto= null;
		
		
		for(ContactVO con:listOfAllContacts){
			
			contacto = new Contacto();
			
			ParserModelVO.parseDataModelVO(con, contacto);
		
			listOfContactsTable.add(contacto);
					
		}		
		return listOfContactsTable;		
	}




}