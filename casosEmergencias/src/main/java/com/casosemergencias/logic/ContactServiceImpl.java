package com.casosemergencias.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.casosemergencias.dao.ContactVO;
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
	public List<Contacto> listOfContactsTable() {
		
		List<Contacto> listOfContactsTable= new ArrayList<Contacto>();
		List<ContactVO> listOfAllContacts =new ArrayList<ContactVO>();
		listOfAllContacts=contactDao.readAllContact();
		Contacto contacto= null;
		
		
		for(ContactVO con:listOfAllContacts){
			
			contacto = new Contacto();
			contacto.setId(con.getId());
			contacto.setSfid(con.getSfid());
			contacto.setName(con.getName());
			contacto.setApellidoPaterno(con.getApellidoPaterno());
			contacto.setApellidoMaterno(con.getApellidoMaterno());
			contacto.setTipoIdentidad(con.getTipoIdentidad());			
			contacto.setAccountRun(con.getAccountRun());
			contacto.setCanalPreferenteContacto(con.getCanalPreferenteContacto());
			contacto.setPhone(con.getPhone());
			contacto.setTelefonoSecundario(con.getTelefonoSecundario());
			contacto.setEmail(con.getEmail());
			contacto.setFechaNacimiento(con.getFechaNacimiento());
			/*contacto.setNombrecuenta*/
			contacto.setDirContacto(con.getDirContacto());
			contacto.setEmailSecundario(con.getEmailSecundario());
			contacto.setSf4twitterFcbkUsername(con.getSf4twitterFcbkUsername());
			/*contacto.setRecuentoSeguidoresTwitter*/
			/*contacto.setInfluencer*/
			/*contacto.setInfluencerType*/
			/*contacto.setBiografiaTwitter*/
			contacto.setSf4twitterTwitterUserId(con.getSf4twitterTwitterUserId());
			contacto.setSf4twitterFcbkUsername(con.getSf4twitterFcbkUsername());
			contacto.setSf4twitterFcbkUserId(con.getSf4twitterFcbkUserId());
			contacto.setTipoContacto(con.getTipoContacto());
			contacto.setCasosReiterados(con.getCasosReiterados());
			contacto.setTipoCuentaAsociado(con.getTipoCuentaAsociado());
			
			listOfContactsTable.add(contacto);
					
		}		
		return listOfContactsTable;		
	}



}