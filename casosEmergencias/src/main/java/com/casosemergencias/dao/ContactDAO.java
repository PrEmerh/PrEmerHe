package com.casosemergencias.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ContactDAO {

	final static Logger logger = Logger.getLogger(ContactDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	/**
	 * Devuelve una lista con todos los Suministro de BBDD
	 * 
	 * @return
	 */
	public List<ContactVO> readAllContact(){
				
		logger.debug("--- Inicio -- readAllContact ---");
		
		Session session = sessionFactory.openSession();
				
		try{
			Query query = session.createQuery("from Contact");
			
			List<ContactVO> contactList = query.list(); 

			logger.debug("--- Fin -- readAllContact ---");
			
			return contactList;
			
	    }catch (HibernateException e) {
	    	logger.error("--- readAllContact "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- readAllContact ---");
	    }finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	
	/**
	 * Devuelve el Contacto que tiene como id el pasado por parametro al metodo
	 * 
	 * @param id - id de un Contacto
	 * @return
	 */
	public ContactVO readContactById(Integer id){
		
		logger.debug("--- Inicio -- readContactById ---");
		
		Session session = sessionFactory.openSession();
				
		try{
			Query query = session.createQuery("from Contact as contact WHERE contact.id = :id");
			query.setInteger("id", id);
			
			List<ContactVO> contactList = query.list(); 

			if(contactList != null){
				return contactList.get(0);
			}			
			
			logger.debug("--- Fin -- readContactById ---");
			
	    }catch (HibernateException e) {
	    	logger.error("--- readContactById "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- readContactById ---");
	    }finally {
	    	session.close(); 
	    }
		
	    return null;
	    
	}
	
	
	/**
	 * Devuelve el Contact que tiene como sfid el pasado por parametro al metodo
	 * 
	 * @param sfid - id de un Contact
	 * @return
	 */
	public ContactVO readContactBySfid(String sfid){
		
		logger.debug("--- Inicio -- readContactBySfid ---");
		
		Session session = sessionFactory.openSession();
				
		try{
			Query query = session.createQuery("from Contact as contact WHERE contact.sfid = :sfid");
			query.setString("sfid", sfid);
			
			List<ContactVO> contactList = query.list(); 

			if(contactList != null){
				return contactList.get(0);
			}			
			
			logger.debug("--- Fin -- readContactBySfid ---");
			
	    }catch (HibernateException e) {
	    	logger.error("--- readContactBySfid "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- readContactBySfid ---");
	    }finally {
	    	session.close(); 
	    }
		
	    return null;
	    
	}
	

	/**
	 * Dado un Contact, recupera una lista de Contact con los mismos datos que Contact
	 * 
	 * @param Contacto
	 * @return
	 */
	public List<ContactVO> readContact(ContactVO contact){
		
		logger.debug("--- Inicio -- readContact ---");
		
		Session session = sessionFactory.openSession();
		boolean isFirst = true;
	
	    try{
	    	//preparamos la query
	    	StringBuilder query = new StringBuilder("from Contact as contact");
			if(contact.getId()!= null){
				if(isFirst){
					query.append(" WHERE contact.id = :id");
					isFirst = false;
				}else{
					query.append(" AND contact.id = :id");
				}
			}
			if(contact.getName()!= null){
				if(isFirst){
					query.append(" WHERE contact.name = :name");
					isFirst = false;
				}else{
					query.append(" AND contact.name = :name");
				}
			}			
			//Campo username no es case sensitive, lo convertimos a mayusculas para la condicion
			if(contact.getParentRutEmpresa()!= null){
				if(isFirst){
					query.append(" WHERE UPPER(contact.parentRutEmpresa) = UPPER(:parentRutEmpresa)");
					isFirst = false;
				}else{
					query.append(" AND UPPER(contact.parentRutEmpresa) = UPPER(:fechaNacimiento)");
				}
			}
			if(contact.getFechaNacimiento()!= null){
				if(isFirst){
					query.append(" WHERE contact.fechaNacimiento = :fechaNacimiento");
					isFirst = false;
				}else{
					query.append(" AND contact.fechaNacimiento = :fechaNacimiento");
				}
			}
			if(contact.getNombreConcatenado()!= null){
				if(isFirst){
					query.append(" WHERE contact.nombreConcatenado = :nombreConcatenado");
					isFirst = false;
				}else{
					query.append(" AND contact.nombreConcatenado = :nombreConcatenado");
				}
			}
			if(contact.getRutEmpresaLaboral()!= null){
				if(isFirst){
					query.append(" WHERE contact.rutEmpresaLaboral = :rutEmpresaLaboral");
					isFirst = false;
				}else{
					query.append(" AND contact.rutEmpresaLaboral = :rutEmpresaLaboral");
				}
			}
			if(contact.getBirthdate()!= null){
				if(isFirst){
					query.append(" WHERE contact.birthdate = :birthdate");
					isFirst = false;
				}else{
					query.append(" AND contact.birthdate = :birthdate");
				}
			}
			if(contact.getDetalleRelacion()!= null){
				if(isFirst){
					query.append(" WHERE contact.detalleRelacion = :detalleRelacion");
					isFirst = false;
				}else{
					query.append(" AND contact.detalleRelacion = :detalleRelacion");
				}
			}
			if(contact.getSf4twitterContactSource()!= null){
				if(isFirst){
					query.append(" WHERE contact.sf4twitterContactSource = :sf4twitterContactSource");
					isFirst = false;
				}else{
					query.append(" AND contact.sf4twitterContactSource = :sf4twitterContactSource");
				}
			}
			if(contact.getMobilePhone()!= null){
				if(isFirst){
					query.append(" WHERE contact.mobilePhone = :mobilePhone");
					isFirst = false;
				}else{
					query.append(" AND contact.mobilePhone = :mobilePhone");
				}
			}
			if(contact.getMasterRecordId()!= null){
				if(isFirst){
					query.append(" WHERE contact.masterRecordId = :masterRecordId");
					isFirst = false;
				}else{
					query.append(" AND contact.masterRecordId = :masterRecordId");
				}
			}
			if(contact.getEmailLaboral()!= null){
				if(isFirst){
					query.append(" WHERE contact.emailLaboral = :emailLaboral");
					isFirst = false;
				}else{
					query.append(" AND contact.emailLaboral = :emailLaboral");
				}
			}
			if(contact.getReportstoId()!= null){
				if(isFirst){
					query.append(" WHERE contact.reportstoId = :reportstoId");
					isFirst = false;
				}else{
					query.append(" AND contact.reportstoId = :reportstoId");
				}
			}if(contact.getAccountId()!= null){
				if(isFirst){
					query.append(" WHERE contact.accountId = :accountId");
					isFirst = false;
				}else{
					query.append(" AND contact.accountId = :accountId");
				}
			}
			if(contact.getVip()!= null){
				if(isFirst){
					query.append(" WHERE contact.vip = :vip");
					isFirst = false;
				}else{
					query.append(" AND contact.vip = :vip");
				}
			}if(contact.getHomePhone()!= null){
				if(isFirst){
					query.append(" WHERE contact.homephone = :homephone");
					isFirst = false;
				}else{
					query.append(" AND contact.homephone = :homephone");
				}
			}
			if(contact.getCanalPreferenteContacto()!= null){
				if(isFirst){
					query.append(" WHERE contact.canalPreferenteContacto = :canalPreferenteContacto");
					isFirst = false;
				}else{
					query.append(" AND contact.canalPreferenteContacto = :canalPreferenteContacto");
				}
			}if(contact.getTipoCuentaAsociado()!= null){
				if(isFirst){
					query.append(" WHERE contact.tipoCuentaAsociado = :tipoCuentaAsociado");
					isFirst = false;
				}else{
					query.append(" AND contact.tipoCuentaAsociado = :tipoCuentaAsociado");
				}
			}
			if(contact.getApellidoMaterno()!= null){
				if(isFirst){
					query.append(" WHERE contact.apellidoMaterno = :apellidoMaterno");
					isFirst = false;
				}else{
					query.append(" AND contact.apellidoMaterno = :apellidoMaterno");
				}
			}
			if(contact.getSf4twitterOrigin()!= null){
				if(isFirst){
					query.append(" WHERE contact.sf4twitterOrigin = :sf4twitterOrigin");
					isFirst = false;
				}else{
					query.append(" AND contact.sf4twitterOrigin = :sf4twitterOrigin");
				}
			}
			if(contact.getTipoIdentidad()!= null){
				if(isFirst){
					query.append(" WHERE contact.tipoIdentidad = :tipoIdentidad");
					isFirst = false;
				}else{
					query.append(" AND contact.tipoIdentidad = :tipoIdentidad");
				}
			}
			if(contact.getTelefonoSecundario()!= null){
				if(isFirst){
					query.append(" WHERE contact.telefonoSecundario = :telefonoSecundario");
					isFirst = false;
				}else{
					query.append(" AND contact.telefonoSecundario = :telefonoSecundario");
				}
			}
			if(contact.getOwnerid()!= null){
				if(isFirst){
					query.append(" WHERE contact.ownerid = :ownerid");
					isFirst = false;
				}else{
					query.append(" AND contact.ownerid = :ownerid");
				}
			}
			if(contact.getEmailSecundario()!= null){
				if(isFirst){
					query.append(" WHERE contact.emailSecundario = :emailSecundario");
					isFirst = false;
				}else{
					query.append(" AND contact.emailSecundario = :emailSecundario");
				}
			}
			if(contact.getLastModifiedById()!= null){
				if(isFirst){
					query.append(" WHERE contact.lastModifiedById = :lastModifiedById");
					isFirst = false;
				}else{
					query.append(" AND contact.lastModifiedById = :lastModifiedById");
				}
			}
			if(contact.getTelefonoAdicional()!= null){
				if(isFirst){
					query.append(" WHERE contact.telefonoAdicional = :telefonoAdicional");
					isFirst = false;
				}else{
					query.append(" AND contact.telefonoAdicional = :telefonoAdicional");
				}
			}
			if(contact.getAssistantName()!= null){
				if(isFirst){
					query.append(" WHERE contact.assistantName = :assistantName");
					isFirst = false;
				}else{
					query.append(" AND contact.assistantName = :assistantName");
				}
			}
			if(contact.getSf4twitterFcbkUsername()!= null){
				if(isFirst){
					query.append(" WHERE contact.sf4twitterFcbkUsername = :sf4twitterFcbkUsername");
					isFirst = false;
				}else{
					query.append(" AND contact.sf4twitterFcbkUsername = :sf4twitterFcbkUsername");
				}
			}
			if(contact.getDireccion()!= null){
				if(isFirst){
					query.append(" WHERE contact.direccion = :direccion");
					isFirst = false;
				}else{
					query.append(" AND contact.direccion = :direccion");
				}
			}
			if(contact.getCasosReiterados()!= null){
				if(isFirst){
					query.append(" WHERE contact.casosReiterados = :casosReiterados");
					isFirst = false;
				}else{
					query.append(" AND contact.casosReiterados = :casosReiterados");
				}
			}
			if(contact.getReportstoPruebaTwitter()!= null){
				if(isFirst){
					query.append(" WHERE contact.reportstoPruebaTwitter = :reportstoPruebaTwitter");
					isFirst = false;
				}else{
					query.append(" AND contact.reportstoPruebaTwitter = :reportstoPruebaTwitter");
				}
			}
			if(contact.getIdEmpresa()!= null){
				if(isFirst){
					query.append(" WHERE contact.idEmpresa = :idEmpresa");
					isFirst = false;
				}else{
					query.append(" AND contact.idEmpresa = :idEmpresa");
				}
			}
			if(contact.getEmail()!= null){
				if(isFirst){
					query.append(" WHERE contact.email = :email");
					isFirst = false;
				}else{
					query.append(" AND contact.email = :email");
				}
			}
			if(contact.getOtherPhone()!= null){
				if(isFirst){
					query.append(" WHERE contact.otherPhone = :otherPhone");
					isFirst = false;
				}else{
					query.append(" AND contact.otherPhone = :otherPhone");
				}
			}
			if(contact.getDepartment()!= null){
				if(isFirst){
					query.append(" WHERE contact.department = :department");
					isFirst = false;
				}else{
					query.append(" AND contact.department = :department");
				}
			}
			if(contact.getAccountRun()!= null){
				if(isFirst){
					query.append(" WHERE contact.accountRun = :accountRun");
					isFirst = false;
				}else{
					query.append(" AND contact.accountRun = :accountRun");
				}
			}
			if(contact.getLongtel2()!= null){
				if(isFirst){
					query.append(" WHERE contact.longtel2 = :longtel2");
					isFirst = false;
				}else{
					query.append(" AND contact.longtel2 = :longtel2");
				}
			}
			if(contact.getNombreCompleto()!= null){
				if(isFirst){
					query.append(" WHERE contact.nombreCompleto = :nombreCompleto");
					isFirst = false;
				}else{
					query.append(" AND contact.nombreCompleto = :nombreCompleto");
				}
			}
			if(contact.getDirContacto()!= null){
				if(isFirst){
					query.append(" WHERE contact.dirContacto = :dirContacto");
					isFirst = false;
				}else{
					query.append(" AND contact.dirContacto = :dirContacto");
				}
			}
			if(contact.getSf4twitterTwitterUserId()!= null){
				if(isFirst){
					query.append(" WHERE contact.sf4twitterTwitterUserId = :sf4twitterTwitterUserId");
					isFirst = false;
				}else{
					query.append(" AND contact.sf4twitterTwitterUserId = :sf4twitterTwitterUserId");
				}
			}
			if(contact.getNumeroSerieCedulaIdentidad()!= null){
				if(isFirst){
					query.append(" WHERE contact.numeroSerieCedulaIdentidad = :numeroSerieCedulaIdentidad");
					isFirst = false;
				}else{
					query.append(" AND contact.numeroSerieCedulaIdentidad = :numeroSerieCedulaIdentidad");
				}
			}
			if(contact.getMasterRecordPruebaTwitter()!= null){
				if(isFirst){
					query.append(" WHERE contact.masterRecordPruebaTwitter = :masterRecordPruebaTwitter");
					isFirst = false;
				}else{
					query.append(" AND contact.masterRecordPruebaTwitter = :masterRecordPruebaTwitter");
				}
			}
			if(contact.getDescription()!= null){
				if(isFirst){
					query.append(" WHERE contact.description = :description");
					isFirst = false;
				}else{
					query.append(" AND contact.description = :description");
				}
			}
			if(contact.getSf4twitterFcbkUserId()!= null){
				if(isFirst){
					query.append(" WHERE contact.sf4twitterFcbkUserId = :sf4twitterFcbkUserId");
					isFirst = false;
				}else{
					query.append(" AND contact.sf4twitterFcbkUserId = :sf4twitterFcbkUserId");
				}
			}
			if(contact.getSf4twitterTwitterUsername()!= null){
				if(isFirst){
					query.append(" WHERE contact.sf4twitterTwitterUsername = :sf4twitterTwitterUsername");
					isFirst = false;
				}else{
					query.append(" AND contact.sf4twitterTwitterUsername = :sf4twitterTwitterUsername");
				}
			}
			if(contact.getTipoRelacionSuministro()!= null){
				if(isFirst){
					query.append(" WHERE contact.tipoRelacionSuministro = :tipoRelacionSuministro");
					isFirst = false;
				}else{
					query.append(" AND contact.tipoRelacionSuministro = :tipoRelacionSuministro");
				}
			}
			if(contact.getTipoContacto()!= null){
				if(isFirst){
					query.append(" WHERE contact.tipoContacto = :tipoContacto");
					isFirst = false;
				}else{
					query.append(" AND contact.tipoContacto = :tipoContacto");
				}
			}
			if(contact.getPhone()!= null){
				if(isFirst){
					query.append(" WHERE contact.phone = :phone");
					isFirst = false;
				}else{
					query.append(" AND contact.phone = :phone");
				}
			}
			if(contact.getSegmentoPersona()!= null){
				if(isFirst){
					query.append(" WHERE contact.segmentoPersona = :segmentoPersona");
					isFirst = false;
				}else{
					query.append(" AND contact.segmentoPersona = :segmentoPersona");
				}
			}
			if(contact.getCreatedById()!= null){
				if(isFirst){
					query.append(" WHERE contact.createdById = :createdById");
					isFirst = false;
				}else{
					query.append(" AND contact.createdById = :createdById");
				}
			}
			if(contact.getApellidoPaterno()!= null){
				if(isFirst){
					query.append(" WHERE contact.apellidoPaterno = :apellidoPaterno");
					isFirst = false;
				}else{
					query.append(" AND contact.apellidoPaterno = :apellidoPaterno");
				}
			}

			//añadimos los valores por los que filtrara la query
			
			Query result = session.createQuery(query.toString());
			if(contact.getSfid()!= null){
				result.setString("sfid", contact.getSfid());
			}
			if(contact.getHcError()!= null){
				result.setString("hcError", contact.getHcError());
			}
			if(contact.getHcLastop()!= null){
				result.setString("hcLastop", contact.getHcLastop());
			}
			if(contact.getIsDeleted()!= null){
				result.setBoolean("isDeleted", contact.getIsDeleted());
			}
			if(contact.getId()!= null){
				result.setInteger("id", contact.getId());
			}
			if(contact.getName()!= null){
				result.setString("name", contact.getName());
			}
			if(contact.getParentRutEmpresa()!= null){
				result.setString("parentRutEmpresa", contact.getParentRutEmpresa());
			}
			if(contact.getFechaNacimiento()!= null){
				result.setDate("fechaNacimiento", contact.getFechaNacimiento());
			}
			if(contact.getNombreConcatenado()!= null){
				result.setString("nombreConcatenado", contact.getNombreConcatenado());
			}
			if(contact.getRutEmpresaLaboral()!= null){
				result.setString("rutEmpresaLaboral", contact.getRutEmpresaLaboral());
			}
			if(contact.getBirthdate()!= null){
				result.setDate("birthdate", contact.getBirthdate());
			}
			if(contact.getDetalleRelacion()!= null){
				result.setString("detalleRelacion", contact.getDetalleRelacion());
			}
			if(contact.getSf4twitterContactSource()!= null){
				result.setString("sf4twitterContactSource", contact.getSf4twitterContactSource());
			}
			if(contact.getMobilePhone()!= null){
				result.setString("mobilePhone", contact.getMobilePhone());
			}
			if(contact.getMasterRecordId()!= null){
				result.setString("masterRecordId", contact.getMasterRecordId());
			}
			if(contact.getEmailLaboral() != null){
				result.setString("emailLaboral", contact.getEmailLaboral());
			}
			if(contact.getReportstoId()!= null){
				result.setString("reportstoId", contact.getReportstoId());
			}
			if(contact.getAccountId()!= null){
				result.setString("accountId", contact.getAccountId());
			}
			if(contact.getVip()!= null){
				result.setBoolean("vip", contact.getVip());
			}
			if(contact.getHomePhone()!= null){
				result.setString("homePhone", contact.getHomePhone());
			}
			if(contact.getCanalPreferenteContacto()!= null){
				result.setString("canalPreferenteContacto", contact.getCanalPreferenteContacto());
			}
			if(contact.getTipoCuentaAsociado()!= null){
				result.setString("tipoCuentaAsociado", contact.getTipoCuentaAsociado());
			}
			if(contact.getApellidoMaterno()!= null){
				result.setString("apellidoMaterno", contact.getApellidoMaterno());
			}
			if(contact.getSf4twitterOrigin()!= null){
				result.setString("sf4twitterOrigin", contact.getSf4twitterOrigin());
			}
			if(contact.getTipoIdentidad()!= null){
				result.setString("tipoIdentidad", contact.getTipoIdentidad());
			}
			if(contact.getTelefonoSecundario()!= null){
				result.setString("telefonoSecundario", contact.getTelefonoSecundario());
			}
			if(contact.getOwnerid()!= null){
				result.setString("ownerid", contact.getOwnerid());
			}
			if(contact.getEmailSecundario()!= null){
				result.setString("emailSecundario", contact.getEmailSecundario());
			}
			if(contact.getLastModifiedById()!= null){
				result.setString("lastModifiedById", contact.getLastModifiedById());
			}
			if(contact.getTelefonoAdicional()!= null){
				result.setString("telefonoAdicional", contact.getTelefonoAdicional());
			}
			if(contact.getAssistantName()!= null){
				result.setString("assistantName", contact.getAssistantName());
			}
			if(contact.getSf4twitterFcbkUsername()!= null){
				result.setString("sf4twitterFcbkUsername", contact.getSf4twitterFcbkUsername());
			}
			if(contact.getDireccion()!= null){
				result.setString("direccion", contact.getDireccion());
			}
			if(contact.getCasosReiterados()!= null){
				result.setBoolean("casosReiterados", contact.getCasosReiterados());
			}
			if(contact.getIdEmpresa()!= null){
				result.setString("idEmpresa", contact.getIdEmpresa());
			}
			if(contact.getEmail()!= null){
				result.setString("email", contact.getEmail());
			}
			if(contact.getOtherPhone()!= null){
				result.setString("otherPhone", contact.getOtherPhone());
			}
			if(contact.getDepartment()!= null){
				result.setString("department", contact.getDepartment());
			}
			if(contact.getAccountRun()!= null){
				result.setString("accountRun", contact.getAccountRun());
			}
			if(contact.getLongtel2()!= null){
				result.setDouble("longtel2", contact.getLongtel2());
			}
			if(contact.getNombreCompleto()!= null){
				result.setString("nombreCompleto", contact.getNombreCompleto());
			}
			if(contact.getDirContacto()!= null){
				result.setString("dirContacto", contact.getDirContacto());
			}
			if(contact.getSf4twitterTwitterUserId()!= null){
				result.setString("sf4twitterTwitterUserId", contact.getSf4twitterTwitterUserId());
			}
			if(contact.getNumeroSerieCedulaIdentidad()!= null){
				result.setDouble("numeroSerieCedulaIdentidad", contact.getNumeroSerieCedulaIdentidad());
			}
			if(contact.getMasterRecordPruebaTwitter()!= null){
				result.setString("masterRecordPruebaTwitter", contact.getMasterRecordPruebaTwitter());
			}
			if(contact.getDescription()!= null){
				result.setString("description", contact.getDescription());
			}
			if(contact.getSf4twitterFcbkUserId()!= null){
				result.setString("sf4twitterFcbkUserId", contact.getSf4twitterFcbkUserId());
			}
			if(contact.getSf4twitterTwitterUsername()!= null){
				result.setString("sf4twitterTwitterUsername", contact.getSf4twitterTwitterUsername());
			}
			if(contact.getTipoRelacionSuministro()!= null){
				result.setString("tipoRelacionSuministro", contact.getTipoRelacionSuministro());
			}
			if(contact.getTipoContacto()!= null){
				result.setString("tipoContacto", contact.getTipoContacto());
			}
			if(contact.getPhone()!= null){
				result.setString("phone", contact.getPhone());
			}
			if(contact.getSegmentoPersona()!= null){
				result.setString("segmentoPersona", contact.getSegmentoPersona());
			}
			if(contact.getCreatedById()!= null){
				result.setString("createdById", contact.getCreatedById());
			}
			if(contact.getApellidoPaterno()!= null){
				result.setString("apellidoPaterno", contact.getApellidoPaterno());
			}

			
			List<ContactVO> contactsList = result.list(); 	 
			
			logger.debug("--- Fin -- readContact ---");
			
			return contactsList;

	    }catch (HibernateException e) {
	    	logger.error("--- readContact "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- readContact ---"); 
	    }finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	
	/**
	 * Actualiza la fila de Contact correspondiente al id de Contact. Modifica todos los campos con el valor que hay en Contact. 
	 * 
	 * @param Contact
	 * @return
	 */
	@Transactional
    public int updateContact(ContactVO Contact){
		
		logger.debug("--- Inicio -- updateContact ---");
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			
			session.update(Contact);
			tx.commit();
			
			logger.debug("--- Fin -- updateContact ---");			
			return 1;
			
		}catch (HibernateException e) {
			
	    	tx.rollback();
			logger.error("--- updateContact "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- updateContact ---");
	    	return 0;
	    	
	    }finally {
	    	session.close(); 
	    }

    }
	
	
	/**
	 * Inserta un Contact en BBDD
	 * @param Contact
	 * @return
	 */
	public int insertContact(ContactVO Contact, Session session){
		
		logger.debug("updateContact -- inicio");

		int numModif = 0;

		session.save(Contact);

		return numModif;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	