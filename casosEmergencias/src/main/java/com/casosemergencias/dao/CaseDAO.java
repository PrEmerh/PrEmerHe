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

import com.casosemergencias.util.DataTableProperties;

@Repository
public class CaseDAO{

	final static Logger logger = Logger.getLogger(CaseDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	/**
	 * Devuelve una lista con todos los Case de BBDD
	 * 
	 * @return
	 */
	public List<CaseVO> readAllCase(){
				
		logger.debug("--- Inicio -- readAllCase ---");
		
		Session session = sessionFactory.openSession();
				
		try{
			Query query = session.createQuery("from CaseVO");
			
			List<CaseVO> casoList = query.list(); 

			logger.debug("--- Fin -- readAllCase ---");
			
			return casoList;
			
	    }catch (HibernateException e) {
	    	logger.error("--- readAllCase "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- readAllCase ---");
	    }finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	/**
	 * Devuelve una lista de casos utilizando los parametros del datatable
	 * 
	 * @return
	 */
	public List<CaseVO> readCaseDataTable(DataTableProperties propDatatable){
				
		logger.debug("--- Inicio -- readCaseDataTable ---");
		
		Session session = sessionFactory.openSession();
		String order = propDatatable.getOrderColumnName();
		String dirOrder = propDatatable.getOrderDirec();
		int numStart = propDatatable.getStart();
		int numLength = propDatatable.getLength();
		
		try{
			StringBuilder query = new StringBuilder("from CaseVO ");
//			Query query = session.createQuery
			if(order != null && !"".equals(order) && dirOrder != null && !"".equals(dirOrder)){
				query.append("ORDER BY " + order + " " + dirOrder);
			}
			
			Query result = session.createQuery(query.toString()).setFirstResult(numStart).setMaxResults(numLength);
			List<CaseVO> casoList = result.list();

			logger.debug("--- Fin -- readAllCase ---");
			
			return casoList;
			
	    }catch (HibernateException e) {
	    	logger.error("--- readCaseDataTable "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- readCaseDataTable ---");
	    }finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	/**
	 * Devuelve una lista con todos los Case de BBDD pero en los campos que son picklist, le pone la descripcion en vez del codigo
	 * 
	 * @return
	 */
	public List<CaseVO> readAllCaseDescriptionPick(){
				
		logger.debug("--- Inicio -- readAllCaseDescriptionPick ---");
		
		Session session = sessionFactory.openSession();
				
		try{
			Query query = session.createQuery("from CaseVO caso");
			//Query query = session.createQuery("from CaseVO caso left join fetch caso.estadoPickList estado ");

			
			//Query query = em.createQuery("SELECT q FROM Question q LEFT JOIN FETCH q.answers");
//			select CaseNumber, Status, Motivo_Empresa__c, sub_estado__c, estado.valor descripcionStatus, motivo.valor descripcionMotivo, subestado.valor descripcionSubestado
//			from salesforce.Case 
//			left join salesforce.picklists estado on (estado.codigo=status and estado.campo ='Status' and estado.objeto='Case') 
//			left join salesforce.picklists motivo on (motivo.codigo=Motivo_Empresa__c and motivo.campo ='Motivo_Empresa__c' and motivo.objeto='Case') 
//			left join salesforce.picklists subestado on (subestado.codigo=sub_estado__c and subestado.campo ='Sub_estado__c' and subestado.objeto='Case')

			List<CaseVO> casoList = query.list();
			logger.debug("Casos: " + casoList);
			
			logger.debug("--- Fin -- readAllCaseDescriptionPick ---");
			
			return casoList;
			
	    }catch (HibernateException e) {
	    	logger.error("--- readAllCaseDescriptionPick "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- readAllCaseDescriptionPick ---");
	    }finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	
	/**
	 * Devuelve el Case que tiene como id el pasado por parametro al metodo
	 * 
	 * @param id - id de un Case
	 * @return
	 */
	public CaseVO readCaseById(Integer id){
		
		logger.debug("--- Inicio -- readCaseById ---");
		
		Session session = sessionFactory.openSession();
				
		try{
			Query query = session.createQuery("from CaseVO as caso WHERE caso.id = :id");
			query.setInteger("id", id);
			
			List<CaseVO> casoList = query.list(); 

			if(casoList != null){
				return casoList.get(0);
			}			
			
			logger.debug("--- Fin -- readCaseById ---");
			
	    }catch (HibernateException e) {
	    	logger.error("--- readCaseById "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- readCaseById ---");
	    }finally {
	    	session.close(); 
	    }
		
	    return null;
	    
	}
	
	/**
	 * Devuelve el Case que tiene como sfid el pasado por parametro al metodo
	 * 
	 * @param sfid - id de un Case
	 * @return
	 */
	public CaseVO readCaseBySfid(String sfid){
		
		logger.debug("--- Inicio -- readCaseBySfid ---");
		
		Session session = sessionFactory.openSession();
				
		try{
			Query query = session.createQuery("from CaseVO as caso WHERE caso.sfid = :sfid");
			query.setString("sfid", sfid);
			
			List<CaseVO> casoList = query.list(); 

			if(casoList != null){
				return casoList.get(0);
			}			
			
			logger.debug("--- Fin -- readCaseBySfid ---");
			
	    }catch (HibernateException e) {
	    	logger.error("--- readCaseBySfid "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- readCaseBySfid ---");
	    }finally {
	    	session.close(); 
	    }
		
	    return null;
	    
	}
	

	/**
	 * Dado un Case, recupera una lista de Case con los mismos datos que Case
	 * 
	 * @param Case
	 * @return
	 */
	public List<CaseVO> readCase(CaseVO caso){
		
		logger.debug("--- Inicio -- readCase ---");
		
		Session session = sessionFactory.openSession();
		boolean isFirst = true;
	
	    try{
	    	//preparamos la query
	    	StringBuilder query = new StringBuilder("from CaseVO as caso");
			if(caso.getId()!= null){
				if(isFirst){
					query.append(" WHERE caso.id = :id");
					isFirst = false;
				}else{
					query.append(" AND caso.id = :id");
				}
			}
			if(caso.getSubject()!= null){
				if(isFirst){
					query.append(" WHERE caso.subject = :subject");
					isFirst = false;
				}else{
					query.append(" AND caso.subject = :subject");
				}
			}			
			//Campo username no es caso sensitive, lo convertimos a mayusculas para la condicion
			if(caso.getFechaEstimadaCierre()!= null){
				if(isFirst){
					query.append(" WHERE caso.fechaEstimadaCierre = :fechaEstimadaCierre");
					isFirst = false;
				}else{
					query.append(" AND caso.fechaEstimadaCierre = :fechaEstimadaCierre");
				}
			}
			if(caso.getAccountid()!= null){
				if(isFirst){
					query.append(" WHERE caso.accountid = :accountid");
					isFirst = false;
				}else{
					query.append(" AND caso.accountid = :accountid");
				}
			}
			if(caso.getFavorabilidadDelCaso()!= null){
				if(isFirst){
					query.append(" WHERE caso.favorabilidadDelCaso = :favorabilidadDelCaso");
					isFirst = false;
				}else{
					query.append(" AND caso.favorabilidadDelCaso = :favorabilidadDelCaso");
				}
			}
			if(caso.getFlagSec()!= null){
				if(isFirst){
					query.append(" WHERE caso.flagSec = :flagSec");
					isFirst = false;
				}else{
					query.append(" AND caso.flagSec = :flagSec");
				}
			}
			if(caso.getLastmodifiedbyid()!= null){
				if(isFirst){
					query.append(" WHERE caso.lastmodifiedbyid = :lastmodifiedbyid");
					isFirst = false;
				}else{
					query.append(" AND caso.lastmodifiedbyid = :lastmodifiedbyid");
				}
			}
			if(caso.getSfid()!= null){
				if(isFirst){
					query.append(" WHERE caso.sfid = :sfid");
					isFirst = false;
				}else{
					query.append(" AND caso.sfid = :sfid");
				}
			}
			if(caso.get_hc_err()!= null){
				if(isFirst){
					query.append(" WHERE caso._hc_err = :hcError");
					isFirst = false;
				}else{
					query.append(" AND caso._hc_err = :hcError");
				}
			}
			if(caso.get_hc_lastop()!= null){
				if(isFirst){
					query.append(" WHERE caso._hc_lastop = :hcLastop");
					isFirst = false;
				}else{
					query.append(" AND caso._hc_lastop = :hcLastop");
				}
			}
			if(caso.getIsdeleted()!= null){
				if(isFirst){
					query.append(" WHERE caso.isdeleted = :isDeleted");
					isFirst = false;
				}else{
					query.append(" AND caso.isdeleted = :isDeleted");
				}
			}
			if(caso.getProductid()!= null){
				if(isFirst){
					query.append(" WHERE caso.productid = :productid");
					isFirst = false;
				}else{
					query.append(" AND caso.productid = :productid");
				}
			}
			if(caso.getValidarElectrodependiente()!= null){
				if(isFirst){
					query.append(" WHERE caso.validarElectrodependiente = :validarElectrodependiente");
					isFirst = false;
				}else{
					query.append(" AND caso.validarElectrodependiente = :validarElectrodependiente");
				}
			}if(caso.getSf4twitterTwitterUsername()!= null){
				if(isFirst){
					query.append(" WHERE caso.sf4twitterTwitterUsername = :sf4twitterTwitterUsername");
					isFirst = false;
				}else{
					query.append(" AND caso.sf4twitterTwitterUsername = :sf4twitterTwitterUsername");
				}
			}
			if(caso.getOwnerid()!= null){
				if(isFirst){
					query.append(" WHERE caso.ownerid = :ownerid");
					isFirst = false;
				}else{
					query.append(" AND caso.ownerid = :ownerid");
				}
			}if(caso.getSlastartdate()!= null){
				if(isFirst){
					query.append(" WHERE caso.slastartdate = :slastartdate");
					isFirst = false;
				}else{
					query.append(" AND caso.slastartdate = :slastartdate");
				}
			}
			if(caso.getMotivoEmpresa()!= null){
				if(isFirst){
					query.append(" WHERE caso.motivoEmpresa = :motivoEmpresa");
					isFirst = false;
				}else{
					query.append(" AND caso.motivoEmpresa = :motivoEmpresa");
				}
			}if(caso.getCallCenter()!= null){
				if(isFirst){
					query.append(" WHERE caso.callCenter = :callCenter");
					isFirst = false;
				}else{
					query.append(" AND caso.callCenter = :callCenter");
				}
			}
			if(caso.getFalloEnvioValidacion()!= null){
				if(isFirst){
					query.append(" WHERE caso.falloEnvioValidacion = :falloEnvioValidacion");
					isFirst = false;
				}else{
					query.append(" AND caso.falloEnvioValidacion = :falloEnvioValidacion");
				}
			}
			if(caso.getLiteralComuna()!= null){
				if(isFirst){
					query.append(" WHERE caso.literalComuna = :literalComuna");
					isFirst = false;
				}else{
					query.append(" AND caso.literalComuna = :literalComuna");
				}
			}
			if(caso.getActDatosContacto()!= null){
				if(isFirst){
					query.append(" WHERE caso.actDatosContacto = :actDatosContacto");
					isFirst = false;
				}else{
					query.append(" AND caso.actDatosContacto = :actDatosContacto");
				}
			}
			if(caso.getFalloCreacionObservacion()!= null){
				if(isFirst){
					query.append(" WHERE caso.falloCreacionObservacion = :falloCreacionObservacion");
					isFirst = false;
				}else{
					query.append(" AND caso.falloCreacionObservacion = :falloCreacionObservacion");
				}
			}
			if(caso.getEstadoPreingreso()!= null){
				if(isFirst){
					query.append(" WHERE caso.estadoPreingreso = :estadoPreingreso");
					isFirst = false;
				}else{
					query.append(" AND caso.estadoPreingreso = :estadoPreingreso");
				}
			}
			if(caso.getEmailNotificacion()!= null){
				if(isFirst){
					query.append(" WHERE caso.emailNotificacion = :emailNotificacion");
					isFirst = false;
				}else{
					query.append(" AND caso.emailNotificacion = :emailNotificacion");
				}
			}
			if(caso.getHoraap()!= null){
				if(isFirst){
					query.append(" WHERE caso.horaap = :horaap");
					isFirst = false;
				}else{
					query.append(" AND caso.horaap = :horaap");
				}
			}
			if(caso.getNumeroInservice()!= null){
				if(isFirst){
					query.append(" WHERE caso.numeroInservice = :numeroInservice");
					isFirst = false;
				}else{
					query.append(" AND caso.numeroInservice = :numeroInservice");
				}
			}
			if(caso.getSuppliedphone()!= null){
				if(isFirst){
					query.append(" WHERE caso.suppliedphone = :suppliedphone");
					isFirst = false;
				}else{
					query.append(" AND caso.suppliedphone = :suppliedphone");
				}
			}
			if(caso.getNumeroMedidor()!= null){
				if(isFirst){
					query.append(" WHERE caso.numeroMedidor = :numeroMedidor");
					isFirst = false;
				}else{
					query.append(" AND caso.numeroMedidor = :numeroMedidor");
				}
			}
			if(caso.getIsstopped()!= null){
				if(isFirst){
					query.append(" WHERE caso.isstopped = :isstopped");
					isFirst = false;
				}else{
					query.append(" AND caso.isstopped = :isstopped");
				}
			}
			if(caso.getCuerpoMail()!= null){
				if(isFirst){
					query.append(" WHERE caso.cuerpoMail = :cuerpoMail");
					isFirst = false;
				}else{
					query.append(" AND caso.cuerpoMail = :cuerpoMail");
				}
			}
			if(caso.getTelefonoContacto()!= null){
				if(isFirst){
					query.append(" WHERE caso.telefonoContacto = :telefonoContacto");
					isFirst = false;
				}else{
					query.append(" AND caso.telefonoContacto = :telefonoContacto");
				}
			}
			if(caso.getQuestionid()!= null){
				if(isFirst){
					query.append(" WHERE caso.questionid = :questionid");
					isFirst = false;
				}else{
					query.append(" AND caso.questionid = :questionid");
				}
			}
			if(caso.getHasselfservicecomments()!= null){
				if(isFirst){
					query.append(" WHERE caso.hasselfservicecomments = :hasselfservicecomments");
					isFirst = false;
				}else{
					query.append(" AND caso.hasselfservicecomments = :hasselfservicecomments");
				}
			}
			if(caso.getTrazaFalloInservice()!= null){
				if(isFirst){
					query.append(" WHERE caso.trazaFalloInservice = :trazaFalloInservice");
					isFirst = false;
				}else{
					query.append(" AND caso.trazaFalloInservice = :trazaFalloInservice");
				}
			}
			if(caso.getCanalNotificacion()!= null){
				if(isFirst){
					query.append(" WHERE caso.canalNotificacion = :canalNotificacion");
					isFirst = false;
				}else{
					query.append(" AND caso.canalNotificacion = :canalNotificacion");
				}
			}
			if(caso.getCreatedbyid()!= null){
				if(isFirst){
					query.append(" WHERE caso.createdbyid = :createdbyid");
					isFirst = false;
				}else{
					query.append(" AND caso.createdbyid = :createdbyid");
				}
			}
			if(caso.getCategoria()!= null){
				if(isFirst){
					query.append(" WHERE caso.categoria = :categoria");
					isFirst = false;
				}else{
					query.append(" AND caso.categoria = :categoria");
				}
			}
			if(caso.getFlag()!= null){
				if(isFirst){
					query.append(" WHERE caso.flag = :flag");
					isFirst = false;
				}else{
					query.append(" AND caso.flag = :flag");
				}
			}
			if(caso.getObservaciones()!= null){
				if(isFirst){
					query.append(" WHERE caso.observaciones = :observaciones");
					isFirst = false;
				}else{
					query.append(" AND caso.observaciones = :observaciones");
				}
			}
			if(caso.getNumeroCaso()!= null){
				if(isFirst){
					query.append(" WHERE caso.casenumber = :casenumber");
					isFirst = false;
				}else{
					query.append(" AND caso.casenumber = :casenumber");
				}
			}
			if(caso.getUrl()!= null){
				if(isFirst){
					query.append(" WHERE caso.url = :url");
					isFirst = false;
				}else{
					query.append(" AND caso.url = :url");
				}
			}
			if(caso.getEstado()!= null){
				if(isFirst){
					query.append(" WHERE caso.status = :status");
					isFirst = false;
				}else{
					query.append(" AND caso.status = :status");
				}
			}
			if(caso.getSf4twitterTwitterid()!= null){
				if(isFirst){
					query.append(" WHERE caso.sf4twitterTwitterid = :sf4twitterTwitterid");
					isFirst = false;
				}else{
					query.append(" AND caso.sf4twitterTwitterid = :sf4twitterTwitterid");
				}
			}
			if(caso.getRespuestaAlCliente()!= null){
				if(isFirst){
					query.append(" WHERE caso.respuestaAlCliente = :respuestaAlCliente");
					isFirst = false;
				}else{
					query.append(" AND caso.respuestaAlCliente = :respuestaAlCliente");
				}
			}
			if(caso.getNumeroCasoAp()!= null){
				if(isFirst){
					query.append(" WHERE caso.numeroCasoAp = :numeroCasoAp");
					isFirst = false;
				}else{
					query.append(" AND caso.numeroCasoAp = :numeroCasoAp");
				}
			}
			if(caso.getIsescalated()!= null){
				if(isFirst){
					query.append(" WHERE caso.isescalated = :isescalated");
					isFirst = false;
				}else{
					query.append(" AND caso.isescalated = :isescalated");
				}
			}
			if(caso.getInteraccion()!= null){
				if(isFirst){
					query.append(" WHERE caso.interaccion = :interaccion");
					isFirst = false;
				}else{
					query.append(" AND caso.interaccion = :interaccion");
				}
			}
			if(caso.getTipoAtencionSec()!= null){
				if(isFirst){
					query.append(" WHERE caso.tipoAtencionSec = :tipoAtencionSec");
					isFirst = false;
				}else{
					query.append(" AND caso.tipoAtencionSec = :tipoAtencionSec");
				}
			}
			if(caso.getSubEstado()!= null){
				if(isFirst){
					query.append(" WHERE caso.subEstado = :subEstado");
					isFirst = false;
				}else{
					query.append(" AND caso.subEstado = :subEstado");
				}
			}
			if(caso.getIsvisibleinselfservice()!= null){
				if(isFirst){
					query.append(" WHERE caso.isvisibleinselfservice = :isvisibleinselfservice");
					isFirst = false;
				}else{
					query.append(" AND caso.isvisibleinselfservice = :isvisibleinselfservice");
				}
			}
			if(caso.getTipoAtencionInterna()!= null){
				if(isFirst){
					query.append(" WHERE caso.tipoAtencionInterna = :tipoAtencionInterna");
					isFirst = false;
				}else{
					query.append(" AND caso.tipoAtencionInterna = :tipoAtencionInterna");
				}
			}
			if(caso.getHoraSec()!= null){
				if(isFirst){
					query.append(" WHERE caso.horaSec = :horaSec");
					isFirst = false;
				}else{
					query.append(" AND caso.horaSec = :horaSec");
				}
			}
			if(caso.getPendienteValidacionCondagr()!= null){
				if(isFirst){
					query.append(" WHERE caso.pendienteValidacionCondagr = :pendienteValidacionCondagr");
					isFirst = false;
				}else{
					query.append(" AND caso.pendienteValidacionCondagr = :pendienteValidacionCondagr");
				}
			}
			if(caso.getEjecutivoAnterior()!= null){
				if(isFirst){
					query.append(" WHERE caso.ejecutivoAnterior = :ejecutivoAnterior");
					isFirst = false;
				}else{
					query.append(" AND caso.ejecutivoAnterior = :ejecutivoAnterior");
				}
			}
			if(caso.getEntitlementid()!= null){
				if(isFirst){
					query.append(" WHERE caso.entitlementid = :entitlementid");
					isFirst = false;
				}else{
					query.append(" AND caso.entitlementid = :entitlementid");
				}
			}
			if(caso.getAssetid()!= null){
				if(isFirst){
					query.append(" WHERE caso.assetid = :assetid");
					isFirst = false;
				}else{
					query.append(" AND caso.assetid = :assetid");
				}
			}
			if(caso.getStopstartDate()!= null){
				if(isFirst){
					query.append(" WHERE caso.stopstartDate = :stopstartDate");
					isFirst = false;
				}else{
					query.append(" AND caso.stopstartDate = :stopstartDate");
				}
			}
			if(caso.getSuppliedCompany()!= null){
				if(isFirst){
					query.append(" WHERE caso.suppliedCompany = :suppliedCompany");
					isFirst = false;
				}else{
					query.append(" AND caso.suppliedCompany = :suppliedCompany");
				}
			}
			if(caso.getIsClosedonCreate()!= null){
				if(isFirst){
					query.append(" WHERE caso.isClosedonCreate = :isClosedonCreate");
					isFirst = false;
				}else{
					query.append(" AND caso.isClosedonCreate = :isClosedonCreate");
				}
			}
			if(caso.getEstadoCondicionAgravante()!= null){
				if(isFirst){
					query.append(" WHERE caso.estadoCondicionAgravante = :estadoCondicionAgravante");
					isFirst = false;
				}else{
					query.append(" AND caso.estadoCondicionAgravante = :estadoCondicionAgravante");
				}
			}
			if(caso.getHoraCancelado()!= null){
				if(isFirst){
					query.append(" WHERE caso.horaCancelado = :horaCancelado");
					isFirst = false;
				}else{
					query.append(" AND caso.horaCancelado = :horaCancelado");
				}
			}
			if(caso.getSuministro()!= null){
				if(isFirst){
					query.append(" WHERE caso.suministro = :suministro");
					isFirst = false;
				}else{
					query.append(" AND caso.suministro = :suministro");
				}
			}
			if(caso.getIsSelfserviceClosed()!= null){
				if(isFirst){
					query.append(" WHERE caso.isSelfserviceClosed = :isSelfserviceClosed");
					isFirst = false;
				}else{
					query.append(" AND caso.isSelfserviceClosed = :isSelfserviceClosed");
				}
			}
			if(caso.getUi()!= null){
				if(isFirst){
					query.append(" WHERE caso.ui = :ui");
					isFirst = false;
				}else{
					query.append(" AND caso.ui = :ui");
				}
			}
			if(caso.getNumSum()!= null){
				if(isFirst){
					query.append(" WHERE caso.numSum = :numSum");
					isFirst = false;
				}else{
					query.append(" AND caso.numSum = :numSum");
				}
			}
			if(caso.getTwitter()!= null){
				if(isFirst){
					query.append(" WHERE caso.twitter = :twitter");
					isFirst = false;
				}else{
					query.append(" AND caso.twitter = :twitter");
				}
			}
			if(caso.getSuppliedName()!= null){
				if(isFirst){
					query.append(" WHERE caso.suppliedName = :suppliedName");
					isFirst = false;
				}else{
					query.append(" AND caso.suppliedName = :suppliedName");
				}
			}
			if(caso.getClosedDate()!= null){
				if(isFirst){
					query.append(" WHERE caso.closedDate = :closedDate");
					isFirst = false;
				}else{
					query.append(" AND caso.closedDate = :closedDate");
				}
			}
			if(caso.getFalloEnvioInservice()!= null){
				if(isFirst){
					query.append(" WHERE caso.falloEnvioInservice = :falloEnvioInservice");
					isFirst = false;
				}else{
					query.append(" AND caso.falloEnvioInservice = :falloEnvioInservice");
				}
			}
			if(caso.getDescription()!= null){
				if(isFirst){
					query.append(" WHERE caso.description = :description");
					isFirst = false;
				}else{
					query.append(" AND caso.description = :description");
				}
			}
			if(caso.getHoraArribado()!= null){
				if(isFirst){
					query.append(" WHERE caso.horaArribado = :horaArribado");
					isFirst = false;
				}else{
					query.append(" AND caso.horaArribado = :horaArribado");
				}
			}
			if(caso.getSlaexitDate()!= null){
				if(isFirst){
					query.append(" WHERE caso.slaexitDate = :slaexitDate");
					isFirst = false;
				}else{
					query.append(" AND caso.slaexitDate = :slaexitDate");
				}
			}
			if(caso.getOrigin()!= null){
				if(isFirst){
					query.append(" WHERE caso.origin = :origin");
					isFirst = false;
				}else{
					query.append(" AND caso.origin = :origin");
				}
			}
			if(caso.getDescripcionEstado()!= null){
				if(isFirst){
					query.append(" WHERE caso.descripcionEstado = :descripcionEstado");
					isFirst = false;
				}else{
					query.append(" AND caso.descripcionEstado = :descripcionEstado");
				}
			}
			if(caso.getBusinessHoursId()!= null){
				if(isFirst){
					query.append(" WHERE caso.businessHoursId = :businessHoursId");
					isFirst = false;
				}else{
					query.append(" AND caso.businessHoursId = :businessHoursId");
				}
			}
			if(caso.getSf4twitterAuthorExternalId()!= null){
				if(isFirst){
					query.append(" WHERE caso.sf4twitterAuthorExternalId = :sf4twitterAuthorExternalId");
					isFirst = false;
				}else{
					query.append(" AND caso.sf4twitterAuthorExternalId = :sf4twitterAuthorExternalId");
				}
			}
			if(caso.getHasCommentSunReadByOwner()!= null){
				if(isFirst){
					query.append(" WHERE caso.hasCommentSunReadByOwner = :hasCommentSunReadByOwner");
					isFirst = false;
				}else{
					query.append(" AND caso.hasCommentSunReadByOwner = :hasCommentSunReadByOwner");
				}
			}
			if(caso.getHoraCerrado()!= null){
				if(isFirst){
					query.append(" WHERE caso.horaCerrado = :horaCerrado");
					isFirst = false;
				}else{
					query.append(" AND caso.horaCerrado = :horaCerrado");
				}
			}
			if(caso.getLiteralCondicionAgravante()!= null){
				if(isFirst){
					query.append(" WHERE caso.literalCondicionAgravante = :literalCondicionAgravante");
					isFirst = false;
				}else{
					query.append(" AND caso.literalCondicionAgravante = :literalCondicionAgravante");
				}
			}
			if(caso.getType()!= null){
				if(isFirst){
					query.append(" WHERE caso.type = :type");
					isFirst = false;
				}else{
					query.append(" AND caso.type = :type");
				}
			}
			if(caso.getDireccionSuministro()!= null){
				if(isFirst){
					query.append(" WHERE caso.direccionSuministro = :direccionSuministro");
					isFirst = false;
				}else{
					query.append(" AND caso.direccionSuministro = :direccionSuministro");
				}
			}
			if(caso.getHoraPendiente()!= null){
				if(isFirst){
					query.append(" WHERE caso.horaPendiente = :horaPendiente");
					isFirst = false;
				}else{
					query.append(" AND caso.horaPendiente = :horaPendiente");
				}
			}
			if(caso.getAni()!= null){
				if(isFirst){
					query.append(" WHERE caso.ani = :ani");
					isFirst = false;
				}else{
					query.append(" AND caso.ani = :ani");
				}
			}
			if(caso.getFacebook()!= null){
				if(isFirst){
					query.append(" WHERE caso.facebook = :facebook");
					isFirst = false;
				}else{
					query.append(" AND caso.facebook = :facebook");
				}
			}
			if(caso.getPeticion()!= null){
				if(isFirst){
					query.append(" WHERE caso.peticion = :peticion");
					isFirst = false;
				}else{
					query.append(" AND caso.peticion = :peticion");
				}
			}
			if(caso.getCommunityId()!= null){
				if(isFirst){
					query.append(" WHERE caso.communityId = :communityId");
					isFirst = false;
				}else{
					query.append(" AND caso.communityId = :communityId");
				}
			}
			if(caso.getDireccion()!= null){
				if(isFirst){
					query.append(" WHERE caso.direccion = :direccion");
					isFirst = false;
				}else{
					query.append(" AND caso.direccion = :direccion");
				}
			}
			if(caso.getHoraAsignado()!= null){
				if(isFirst){
					query.append(" WHERE caso.horaAsignado = :horaAsignado");
					isFirst = false;
				}else{
					query.append(" AND caso.horaAsignado = :horaAsignado");
				}
			}
			if(caso.getMilestoneStatus()!= null){
				if(isFirst){
					query.append(" WHERE caso.milestoneStatus = :milestoneStatus");
					isFirst = false;
				}else{
					query.append(" AND caso.milestoneStatus = :milestoneStatus");
				}
			}
			if(caso.getContactId()!= null){
				if(isFirst){
					query.append(" WHERE caso.contactId = :contactId");
					isFirst = false;
				}else{
					query.append(" AND caso.contactId = :contactId");
				}
			}
			if(caso.getHoraPredespacho()!= null){
				if(isFirst){
					query.append(" WHERE caso.horaPredespacho = :horaPredespacho");
					isFirst = false;
				}else{
					query.append(" AND caso.horaPredespacho = :horaPredespacho");
				}
			}
			if(caso.getHoraEnruta()!= null){
				if(isFirst){
					query.append(" WHERE caso.horaEnruta = :horaEnruta");
					isFirst = false;
				}else{
					query.append(" AND caso.horaEnruta = :horaEnruta");
				}
			}
			if(caso.getReason()!= null){
				if(isFirst){
					query.append(" WHERE caso.reason = :reason");
					isFirst = false;
				}else{
					query.append(" AND caso.reason = :reason");
				}
			}
			if(caso.getIdEmpresa()!= null){
				if(isFirst){
					query.append(" WHERE caso.idEmpresa = :idEmpresa");
					isFirst = false;
				}else{
					query.append(" AND caso.idEmpresa = :idEmpresa");
				}
			}
			if(caso.getHoraProgramado()!= null){
				if(isFirst){
					query.append(" WHERE caso.horaProgramado = :horaProgramado");
					isFirst = false;
				}else{
					query.append(" AND caso.horaProgramado = :horaProgramado");
				}
			}
			if(caso.getNumeroSeguidoresDel()!= null){
				if(isFirst){
					query.append(" WHERE caso.numeroSeguidoresDel = :numeroSeguidoresDel");
					isFirst = false;
				}else{
					query.append(" AND caso.numeroSeguidoresDel = :numeroSeguidoresDel");
				}
			}
			if(caso.getLiteralCategorias()!= null){
				if(isFirst){
					query.append(" WHERE caso.literalCategorias = :literalCategorias");
					isFirst = false;
				}else{
					query.append(" AND caso.literalCategorias = :literalCategorias");
				}
			}
			if(caso.getComunaF()!= null){
				if(isFirst){
					query.append(" WHERE caso.comunaF = :comunaF");
					isFirst = false;
				}else{
					query.append(" AND caso.comunaF = :comunaF");
				}
			}
			if(caso.getPrioridad()!= null){
				if(isFirst){
					query.append(" WHERE caso.prioridad = :prioridad");
					isFirst = false;
				}else{
					query.append(" AND caso.prioridad = :prioridad");
				}
			}
			if(caso.getValorSubestadoins()!= null){
				if(isFirst){
					query.append(" WHERE caso.valorSubestadoins = :valorSubestadoins");
					isFirst = false;
				}else{
					query.append(" AND caso.valorSubestadoins = :valorSubestadoins");
				}
			}
			if(caso.getControlElectrodependiente()!= null){
				if(isFirst){
					query.append(" WHERE caso.controlElectrodependiente = :controlElectrodependiente");
					isFirst = false;
				}else{
					query.append(" AND caso.controlElectrodependiente = :controlElectrodependiente");
				}
			}
			if(caso.getCancelar()!= null){
				if(isFirst){
					query.append(" WHERE caso.cancelar = :cancelar");
					isFirst = false;
				}else{
					query.append(" AND caso.cancelar = :cancelar");
				}
			}
			if(caso.getCondicionAgravante()!= null){
				if(isFirst){
					query.append(" WHERE caso.condicionAgravante = :condicionAgravante");
					isFirst = false;
				}else{
					query.append(" AND caso.condicionAgravante = :condicionAgravante");
				}
			}
			if(caso.getSystemmodstamp()!= null){
				if(isFirst){
					query.append(" WHERE caso.createdDate = :createdDate");
					isFirst = false;
				}else{
					query.append(" AND caso.createdDate = :createdDate");
				}
			}
			if(caso.getSystemmodstamp()!= null){
				if(isFirst){
					query.append(" WHERE caso.systemmodstamp = :systemmodstamp");
					isFirst = false;
				}else{
					query.append(" AND caso.systemmodstamp = :systemmodstamp");
				}
			}
			
			//añadimos los valores por los que filtrara la query
			Query result = session.createQuery(query.toString());

			if(caso.getId()!= null){
				result.setInteger("id", caso.getId());
			}
			if(caso.getSubject()!= null){
				result.setString("subject", caso.getSubject());
			}
			if(caso.getFechaEstimadaCierre()!= null){
				result.setDate("fechaEstimadaCierre", caso.getFechaEstimadaCierre());
			}
			if(caso.getAccountid()!= null){
				result.setString("accountid", caso.getAccountid());
			}
			if(caso.getFavorabilidadDelCaso()!= null){
				result.setString("favorabilidadDelCaso", caso.getFavorabilidadDelCaso());
			}
			if(caso.getFlagSec()!= null){
				result.setString("flagSec", caso.getFlagSec());
			}
			if(caso.getSfid()!= null){
				result.setString("sfid", caso.getSfid());
			}
			if(caso.get_hc_err()!= null){
				result.setString("hcError", caso.get_hc_err());
			}
			if(caso.get_hc_lastop()!= null){
				result.setString("hcLastop", caso.get_hc_lastop());
			}
			if(caso.getIsdeleted()!= null){
				result.setBoolean("isDeleted", caso.getIsdeleted());
			}
			if(caso.getProductid()!= null){
				result.setString("productid", caso.getProductid());
			}
			if(caso.getValidarElectrodependiente()!= null){
				result.setBoolean("validarElectrodependiente", caso.getValidarElectrodependiente());
			}
			if(caso.getSf4twitterTwitterUsername()!= null){
				result.setString("sf4twitterTwitterUsername", caso.getSf4twitterTwitterUsername());
			}
			if(caso.getOwnerid()!= null){
				result.setString("ownerid", caso.getOwnerid());
			}
			if(caso.getSlastartdate()!= null){
				result.setDate("slastartdate", caso.getSlastartdate());
			}
			if(caso.getMotivoEmpresa() != null){
				result.setString("motivoEmpresa", caso.getMotivoEmpresa());
			}
			if(caso.getCallCenter()!= null){
				result.setString("callCenter", caso.getCallCenter());
			}
			if(caso.getNumeroMedidor()!= null){
				result.setString("numeroMedidor", caso.getNumeroMedidor());
			}
			if(caso.getFalloEnvioValidacion()!= null){
				result.setBoolean("falloEnvioValidacion", caso.getFalloEnvioValidacion());
			}
			if(caso.getLiteralComuna()!= null){
				result.setString("literalComuna", caso.getLiteralComuna());
			}
			if(caso.getActDatosContacto()!= null){
				result.setBoolean("actDatosContacto", caso.getActDatosContacto());
			}
			if(caso.getFalloCreacionObservacion()!= null){
				result.setString("falloCreacionObservacion", caso.getFalloCreacionObservacion());
			}
			if(caso.getEstadoPreingreso()!= null){
				result.setBoolean("sfidestadoPreingreso", caso.getEstadoPreingreso());
			}
			if(caso.getEmailNotificacion()!= null){
				result.setString("emailNotificacion", caso.getEmailNotificacion());
			}
			if(caso.getHoraap()!= null){
				result.setDouble("horaap", caso.getHoraap());
			}
			if(caso.getNumeroInservice()!= null){
				result.setString("numeroInservice", caso.getNumeroInservice());
			}
			if(caso.getSuppliedphone()!= null){
				result.setString("suppliedphone", caso.getSuppliedphone());
			}
			if(caso.getNumeroMedidor()!= null){
				result.setString("numeroMedidor", caso.getNumeroMedidor());
			}
			if(caso.getIsstopped()!= null){
				result.setBoolean("isstopped", caso.getIsstopped());
			}
			if(caso.getCuerpoMail()!= null){
				result.setString("cuerpoMail", caso.getCuerpoMail());
			}
			if(caso.getTelefonoContacto()!= null){
				result.setString("telefonoContacto", caso.getTelefonoContacto());
			}
			if(caso.getQuestionid()!= null){
				result.setString("questionid", caso.getQuestionid());
			}
			if(caso.getHasselfservicecomments()!= null){
				result.setBoolean("hasselfservicecomments", caso.getHasselfservicecomments());
			}
			if(caso.getTrazaFalloInservice()!= null){
				result.setString("trazaFalloInservice", caso.getTrazaFalloInservice());
			}
			if(caso.getCanalNotificacion()!= null){
				result.setString("canalNotificacion", caso.getCanalNotificacion());
			}
			if(caso.getCreatedbyid()!= null){
				result.setString("createdbyid", caso.getCreatedbyid());
			}
			if(caso.getCategoria()!= null){
				result.setString("categoria", caso.getCategoria());
			}
			if(caso.getFlag()!= null){
				result.setString("flag", caso.getFlag());
			}
			if(caso.getObservaciones()!= null){
				result.setString("observaciones", caso.getObservaciones());
			}
			if(caso.getNumeroCaso()!= null){
				result.setString("casenumber", caso.getNumeroCaso());
			}
			if(caso.getUrl()!= null){
				result.setString("url", caso.getUrl());
			}
			if(caso.getEstado()!= null){
				result.setString("status", caso.getEstado());
			}
			if(caso.getSf4twitterTwitterid()!= null){
				result.setString("sf4twitterTwitterid", caso.getSf4twitterTwitterid());
			}
			if(caso.getRespuestaAlCliente()!= null){
				result.setString("respuestaAlCliente", caso.getRespuestaAlCliente());
			}
			if(caso.getNumeroCasoAp()!= null){
				result.setString("numeroCasoAp", caso.getNumeroCasoAp());
			}
			if(caso.getIsescalated()!= null){
				result.setBoolean("isescalated", caso.getIsescalated());
			}
			if(caso.getInteraccion()!= null){
				result.setString("interaccion", caso.getInteraccion());
			}
			if(caso.getTipoAtencionSec()!= null){
				result.setString("tipoAtencionSec", caso.getTipoAtencionSec());
			}
			if(caso.getSubEstado()!= null){
				result.setString("subEstado", caso.getSubEstado());
			}
			if(caso.getIsvisibleinselfservice()!= null){
				result.setBoolean("isvisibleinselfservice", caso.getIsvisibleinselfservice());
			}
			if(caso.getTipoAtencionInterna()!= null){
				result.setString("tipoAtencionInterna", caso.getTipoAtencionInterna());
			}
			if(caso.getHoraSec()!= null){
				result.setDate("horaSec", caso.getHoraSec());
			}
			if(caso.getPendienteValidacionCondagr()!= null){
				result.setBoolean("pendienteValidacionCondagr", caso.getPendienteValidacionCondagr());
			}
			if(caso.getEjecutivoAnterior()!= null){
				result.setString("ejecutivoAnterior", caso.getEjecutivoAnterior());
			}
			if(caso.getEntitlementid()!= null){
				result.setString("entitlementid", caso.getEntitlementid());
			}
			if(caso.getAssetid()!= null){
				result.setString("assetid", caso.getAssetid());
			}
			if(caso.getStopstartDate()!= null){
				result.setDate("stopstartDate", caso.getStopstartDate());
			}
			if(caso.getSuppliedCompany()!= null){
				result.setString("suppliedCompany", caso.getSuppliedCompany());
			}
			if(caso.getIsClosedonCreate()!= null){
				result.setBoolean("isClosedonCreate", caso.getIsClosedonCreate());
			}
			if(caso.getEstadoCondicionAgravante()!= null){
				result.setString("estadoCondicionAgravante", caso.getEstadoCondicionAgravante());
			}
			if(caso.getHoraCancelado()!= null){
				result.setDate("horaCancelado", caso.getHoraCancelado());
			}
			if(caso.getSuministro()!= null){
				result.setString("suministro", caso.getSuministro());
			}
			if(caso.getIsSelfserviceClosed()!= null){
				result.setBoolean("isSelfserviceClosed", caso.getIsSelfserviceClosed());
			}
			if(caso.getParentid()!= null){
				result.setString("parentid", caso.getParentid());
			}
			if(caso.getUi()!= null){
				result.setBoolean("ui", caso.getUi());
			}
			if(caso.getNumSum()!= null){
				result.setString("numSum", caso.getNumSum());
			}
			if(caso.getTwitter()!= null){
				result.setString("twitter", caso.getTwitter());
			}
			if(caso.getSuppliedName()!= null){
				result.setString("suppliedName", caso.getSuppliedName());
			}
			if(caso.getClosedDate()!= null){
				result.setDate("closedDate", caso.getClosedDate());
			}
			if(caso.getFalloEnvioInservice()!= null){
				result.setBoolean("falloEnvioInservice", caso.getFalloEnvioInservice());
			}
			if(caso.getDescription()!= null){
				result.setString("description", caso.getDescription());
			}
			if(caso.getHoraArribado()!= null){
				result.setDate("horaArribado", caso.getHoraArribado());
			}
			if(caso.getSlaexitDate()!= null){
				result.setDate("slaexitDate", caso.getSlaexitDate());
			}
			if(caso.getOrigin()!= null){
				result.setString("origin", caso.getOrigin());
			}
			if(caso.getDescripcionEstado()!= null){
				result.setString("descripcionEstado", caso.getDescripcionEstado());
			}
			if(caso.getBusinessHoursId()!= null){
				result.setString("businessHoursId", caso.getBusinessHoursId());
			}
			if(caso.getSf4twitterAuthorExternalId()!= null){
				result.setString("sf4twitterAuthorExternalId", caso.getSf4twitterAuthorExternalId());
			}
			if(caso.getHasCommentSunReadByOwner()!= null){
				result.setBoolean("hasCommentSunReadByOwner", caso.getHasCommentSunReadByOwner());
			}
			if(caso.getHoraCerrado()!= null){
				result.setDate("horaCerrado", caso.getHoraCerrado());
			}
			if(caso.getLiteralCondicionAgravante()!= null){
				result.setString("literalCondicionAgravante", caso.getLiteralCondicionAgravante());
			}
			if(caso.getType()!= null){
				result.setString("type", caso.getType());
			}
			if(caso.getDireccionSuministro()!= null){
				result.setString("direccionSuministro", caso.getDireccionSuministro());
			}
			if(caso.getHoraPendiente()!= null){
				result.setDate("horaPendiente", caso.getHoraPendiente());
			}
			if(caso.getAni()!= null){
				result.setString("ani", caso.getAni());
			}
			if(caso.getFacebook()!= null){
				result.setString("facebook", caso.getFacebook());
			}
			if(caso.getPeticion()!= null){
				result.setString("peticion", caso.getPeticion());
			}
			if(caso.getCommunityId()!= null){
				result.setString("communityId", caso.getCommunityId());
			}
			if(caso.getDireccion()!= null){
				result.setString("direccion", caso.getDireccion());
			}
			if(caso.getHoraAsignado()!= null){
				result.setDate("horaAsignado", caso.getHoraAsignado());
			}
			if(caso.getMilestoneStatus()!= null){
				result.setString("milestoneStatus", caso.getMilestoneStatus());
			}
			if(caso.getContactId()!= null){
				result.setString("contactId", caso.getContactId());
			}
			if(caso.getHoraPredespacho()!= null){
				result.setDate("horaPredespacho", caso.getHoraPredespacho());
			}
			if(caso.getHoraEnruta()!= null){
				result.setDate("horaEnruta", caso.getHoraEnruta());
			}
			if(caso.getReason()!= null){
				result.setString("reason", caso.getReason());
			}
			if(caso.getIdEmpresa()!= null){
				result.setString("idEmpresa", caso.getIdEmpresa());
			}
			if(caso.getHoraProgramado()!= null){
				result.setDate("horaProgramado", caso.getHoraProgramado());
			}
			if(caso.getNumeroSeguidoresDel()!= null){
				result.setDouble("numeroSeguidoresDel", caso.getNumeroSeguidoresDel());
			}
			if(caso.getLiteralCategorias()!= null){
				result.setString("literalCategorias", caso.getLiteralCategorias());
			}
			if(caso.getRecordtypeId()!= null){
				result.setString("recordtypeId", caso.getRecordtypeId());
			}
			if(caso.getComunaF()!= null){
				result.setString("comunaF", caso.getComunaF());
			}
			if(caso.getPrioridad()!= null){
				result.setString("prioridad", caso.getPrioridad());
			}
			if(caso.getValorSubestadoins()!= null){
				result.setString("valorSubestadoins", caso.getValorSubestadoins());
			}
			if(caso.getControlElectrodependiente()!= null){
				result.setBoolean("controlElectrodependiente", caso.getControlElectrodependiente());
			}
			if(caso.getCancelar()!= null){
				result.setBoolean("cancelar", caso.getCancelar());
			}
			if(caso.getCondicionAgravante()!= null){
				result.setString("condicionAgravante", caso.getCondicionAgravante());
			}			
			if(caso.getCreatedDate()!= null){
				result.setDate("createdDate", caso.getCreatedDate());
			}
			if(caso.getSystemmodstamp()!= null){
				result.setDate("systemmodstamp", caso.getSystemmodstamp());
			}
			
			List<CaseVO> casosList = result.list(); 	 
			
			logger.debug("--- Fin -- readCase ---");
			
			return casosList;

	    }catch (HibernateException e) {
	    	logger.error("--- readCase "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- readCase ---"); 
	    }finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	
	/**
	 * Actualiza la fila de Case correspondiente al id de Case. Modifica todos los campos con el valor que hay en Case. 
	 * 
	 * @param Case
	 * @return
	 */
	@Transactional
    public int updateCase(CaseVO Case){
		
		logger.debug("--- Inicio -- updateCase ---");
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			
			session.update(Case);
			tx.commit();
			
			logger.debug("--- Fin -- updateCase ---");			
			return 1;
			
		}catch (HibernateException e) {
			
	    	tx.rollback();
			logger.error("--- updateCase "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- updateCase ---");
	    	return 0;
	    	
	    }finally {
	    	session.close(); 
	    }

		
    }
	/**
	 * Devuelve el numero de casos que hay en la tala Case
	 * 
	 * @return
	 */
	public Integer countCase(){
				
		logger.debug("--- Inicio -- countCase ---");
		
		Session session = sessionFactory.openSession();
				
		try{
			Query query = session.createQuery("select count(id) from CaseVO");
			
			Long count = (Long) query.uniqueResult();

			logger.debug("--- Fin -- readAllCase ---");
			
			return count.intValue();
			
	    }catch (HibernateException e) {
	    	logger.error("--- countCase "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- countCase ---");
	    }finally {
	    	session.close(); 
	    }
	      return 0;
	}
	
}
