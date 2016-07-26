package com.casosemergencias.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.casosemergencias.dao.Contact;
import com.casosemergencias.dao.ContactDAO;
import com.casosemergencias.model.Contacto;


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
	public List<Contacto> listOfAllContacts() {
		
		List<Contacto> listOfContactsTable= new ArrayList<Contacto>();
		List<Contact> listOfAllContacs =new ArrayList<Contact>();
		listOfAllContacs=contactDao.readAllContact();
		Contacto contacto= new Contacto();
		
		for(Contact con:listOfAllContacs){

				contacto.setId(con.getId());
				contacto.setSfid(con.getSfid());
				contacto.setName(con.getName());
				contacto.setAccountRun(con.getAccountRun());
				contacto.setPhone(con.getPhone());
				contacto.setEmail(con.getEmail());
							
			listOfContactsTable.add(contacto);
			contacto=null;			
		}		
		return listOfContactsTable;		
	}
	


}