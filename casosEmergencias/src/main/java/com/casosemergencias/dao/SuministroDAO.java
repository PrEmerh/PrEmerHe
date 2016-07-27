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
public class SuministroDAO {

	final static Logger logger = Logger.getLogger(SuministroDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	/**
	 * Devuelve una lista con todos los Suministro de BBDD
	 * 
	 * @return
	 */
	public List<SuministroVO> readAllSuministro(){
				
		logger.debug("--- Inicio -- readAllSuministro ---");
		
		Session session = sessionFactory.openSession();
				
		try{
			Query query = session.createQuery("from Suministro");
			
			List<SuministroVO> suministroList = query.list(); 

			logger.debug("--- Fin -- readAllSuministro ---");
			
			return suministroList;
			
	    }catch (HibernateException e) {
	    	logger.error("--- readAllSuministro "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- readAllSuministro ---");
	    }finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	
	/**
	 * Devuelve el Suministro que tiene como id el pasado por parametro al metodo
	 * 
	 * @param id - id de un Suministro
	 * @return
	 */
	public SuministroVO readSuministroById(Integer id){
		
		logger.debug("--- Inicio -- readSuministroById ---");
		
		Session session = sessionFactory.openSession();
				
		try{
			Query query = session.createQuery("from Suministro as suministro WHERE suministro.id = :id");
			query.setInteger("id", id);
			
			List<SuministroVO> suministroList = query.list(); 

			if(suministroList != null){
				return suministroList.get(0);
			}			
			
			logger.debug("--- Fin -- readSuministroById ---");
			
	    }catch (HibernateException e) {
	    	logger.error("--- readSuministroById "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- readSuministroById ---");
	    }finally {
	    	session.close(); 
	    }
		
	    return null;
	    
	}
	
	/**
	 * Devuelve el Suministro que tiene como sfid el pasado por parametro al metodo
	 * 
	 * @param sfid - id de un Suministro
	 * @return
	 */
	public SuministroVO readSuministroBySfid(String sfid){
		
		logger.debug("--- Inicio -- readSuministroBySfid ---");
		
		Session session = sessionFactory.openSession();
				
		try{
			Query query = session.createQuery("from Suministro as suministro WHERE suministro.sfid = :sfid");
			query.setString("sfid", sfid);
			
			List<SuministroVO> suministroList = query.list(); 

			if(suministroList != null){
				return suministroList.get(0);
			}			
			
			logger.debug("--- Fin -- readSuministroBySfid ---");
			
	    }catch (HibernateException e) {
	    	logger.error("--- readSuministroBySfid "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- readSuministroBySfid ---");
	    }finally {
	    	session.close(); 
	    }
		
	    return null;
	    
	}
	

	/**
	 * Dado un Suministro, recupera una lista de Suministro con los mismos datos que Suministro
	 * 
	 * @param SuministroVO
	 * @return
	 */
	public List<SuministroVO> readSuministro(SuministroVO suministro){
		
		logger.debug("--- Inicio -- readSuministro ---");
		
		Session session = sessionFactory.openSession();
		boolean isFirst = true;
	
	    try{
	    	//preparamos la query
	    	StringBuilder query = new StringBuilder("from Suministro as suministro");
			if(suministro.getId()!= null){
				if(isFirst){
					query.append(" WHERE suministro.id = :id");
					isFirst = false;
				}else{
					query.append(" AND suministro.id = :id");
				}
			}
			if(suministro.getName()!= null){
				if(isFirst){
					query.append(" WHERE suministro.name = :name");
					isFirst = false;
				}else{
					query.append(" AND suministro.name = :name");
				}
			}			
			//Campo username no es case sensitive, lo convertimos a mayusculas para la condicion
			if(suministro.getFullElectric()!= null){
				if(isFirst){
					query.append(" WHERE UPPER(suministro.fullElectric) = UPPER(:fullElectric)");
					isFirst = false;
				}else{
					query.append(" AND UPPER(suministro.fullElectric) = UPPER(:fullElectric)");
				}
			}
			if(suministro.getCasosAbiertos()!= null){
				if(isFirst){
					query.append(" WHERE suministro.casosAbiertos = :casosAbiertos");
					isFirst = false;
				}else{
					query.append(" AND suministro.casosAbiertos = :casosAbiertos");
				}
			}
			if(suministro.getTipoTransformador()!= null){
				if(isFirst){
					query.append(" WHERE suministro.tipoTransformador = :tipoTransformador");
					isFirst = false;
				}else{
					query.append(" AND suministro.tipoTransformador = :tipoTransformador");
				}
			}
			if(suministro.getCreatedbyid()!= null){
				if(isFirst){
					query.append(" WHERE suministro.createdbyid = :createdbyid");
					isFirst = false;
				}else{
					query.append(" AND suministro.createdbyid = :createdbyid");
				}
			}
			if(suministro.getCortePorDeuda()!= null){
				if(isFirst){
					query.append(" WHERE suministro.cortePorDeuda = :cortePorDeuda");
					isFirst = false;
				}else{
					query.append(" AND suministro.cortePorDeuda = :cortePorDeuda");
				}
			}
			if(suministro.getSfid()!= null){
				if(isFirst){
					query.append(" WHERE suministro.sfid = :sfid");
					isFirst = false;
				}else{
					query.append(" AND suministro.sfid = :sfid");
				}
			}
			if(suministro.getHcError()!= null){
				if(isFirst){
					query.append(" WHERE suministro.hcError = :hcError");
					isFirst = false;
				}else{
					query.append(" AND suministro.hcError = :hcError");
				}
			}
			if(suministro.getHcLastop()!= null){
				if(isFirst){
					query.append(" WHERE suministro.hcLastop = :hcLastop");
					isFirst = false;
				}else{
					query.append(" AND suministro.hcLastop = :hcLastop");
				}
			}
			if(suministro.getIsDeleted()!= null){
				if(isFirst){
					query.append(" WHERE suministro.isDeleted = :isDeleted");
					isFirst = false;
				}else{
					query.append(" AND suministro.isDeleted = :isDeleted");
				}
			}
			if(suministro.getTipoLectura()!= null){
				if(isFirst){
					query.append(" WHERE suministro.tipoLectura = :tipoLectura");
					isFirst = false;
				}else{
					query.append(" AND suministro.tipoLectura = :tipoLectura");
				}
			}
			if(suministro.getEstadoConexion()!= null){
				if(isFirst){
					query.append(" WHERE suministro.estadoConexion = :estadoConexion");
					isFirst = false;
				}else{
					query.append(" AND suministro.estadoConexion = :estadoConexion");
				}
			}if(suministro.getClasificacionCliente()!= null){
				if(isFirst){
					query.append(" WHERE suministro.clasificacionCliente = :clasificacionCliente");
					isFirst = false;
				}else{
					query.append(" AND suministro.clasificacionCliente = :clasificacionCliente");
				}
			}
			if(suministro.getVip()!= null){
				if(isFirst){
					query.append(" WHERE suministro.vip = :vip");
					isFirst = false;
				}else{
					query.append(" AND suministro.vip = :vip");
				}
			}if(suministro.getTipoMedida()!= null){
				if(isFirst){
					query.append(" WHERE suministro.tipoMedida = :tipoMedida");
					isFirst = false;
				}else{
					query.append(" AND suministro.tipoMedida = :tipoMedida");
				}
			}
			if(suministro.getComunaReparto()!= null){
				if(isFirst){
					query.append(" WHERE suministro.comunaReparto = :comunaReparto");
					isFirst = false;
				}else{
					query.append(" AND suministro.comunaReparto = :comunaReparto");
				}
			}if(suministro.getComuna()!= null){
				if(isFirst){
					query.append(" WHERE suministro.comuna = :comuna");
					isFirst = false;
				}else{
					query.append(" AND suministro.comuna = :comuna");
				}
			}
			if(suministro.getNumeroMedidor()!= null){
				if(isFirst){
					query.append(" WHERE suministro.numeroMedidor = :numeroMedidor");
					isFirst = false;
				}else{
					query.append(" AND suministro.numeroMedidor = :numeroMedidor");
				}
			}
			if(suministro.getDvNumeroSuministro()!= null){
				if(isFirst){
					query.append(" WHERE suministro.dvNumeroSuministro = :dvNumeroSuministro");
					isFirst = false;
				}else{
					query.append(" AND suministro.dvNumeroSuministro = :dvNumeroSuministro");
				}
			}
			if(suministro.getDatosClientesConDisciplina()!= null){
				if(isFirst){
					query.append(" WHERE suministro.datosClientesConDisciplina = :datosClientesConDisciplina");
					isFirst = false;
				}else{
					query.append(" AND suministro.datosClientesConDisciplina = :datosClientesConDisciplina");
				}
			}
			if(suministro.getModeloMedidor()!= null){
				if(isFirst){
					query.append(" WHERE suministro.modeloMedidor = :modeloMedidor");
					isFirst = false;
				}else{
					query.append(" AND suministro.modeloMedidor = :modeloMedidor");
				}
			}
			if(suministro.getNumeroSuministro()!= null){
				if(isFirst){
					query.append(" WHERE suministro.numeroSuministro = :numeroSuministro");
					isFirst = false;
				}else{
					query.append(" AND suministro.numeroSuministro = :numeroSuministro");
				}
			}
			if(suministro.getNumeroTransformador()!= null){
				if(isFirst){
					query.append(" WHERE suministro.numeroTransformador = :numeroTransformador");
					isFirst = false;
				}else{
					query.append(" AND suministro.numeroTransformador = :numeroTransformador");
				}
			}
			if(suministro.getCondominioSector()!= null){
				if(isFirst){
					query.append(" WHERE suministro.condominioSector = :condominioSector");
					isFirst = false;
				}else{
					query.append(" AND suministro.condominioSector = :condominioSector");
				}
			}
			if(suministro.getProcesoLectura()!= null){
				if(isFirst){
					query.append(" WHERE suministro.procesoLectura = :procesoLectura");
					isFirst = false;
				}else{
					query.append(" AND suministro.procesoLectura = :procesoLectura");
				}
			}
			if(suministro.getOwnerid()!= null){
				if(isFirst){
					query.append(" WHERE suministro.ownerid = :ownerid");
					isFirst = false;
				}else{
					query.append(" AND suministro.ownerid = :ownerid");
				}
			}
			if(suministro.getNombreTransformador()!= null){
				if(isFirst){
					query.append(" WHERE suministro.nombreTransformador = :nombreTransformador");
					isFirst = false;
				}else{
					query.append(" AND suministro.nombreTransformador = :nombreTransformador");
				}
			}
			if(suministro.getEstadoSuministro()!= null){
				if(isFirst){
					query.append(" WHERE suministro.estadoSuministro = :estadoSuministro");
					isFirst = false;
				}else{
					query.append(" AND suministro.estadoSuministro = :estadoSuministro");
				}
			}
			if(suministro.getMarcaMedidor()!= null){
				if(isFirst){
					query.append(" WHERE suministro.marcaMedidor = :marcaMedidor");
					isFirst = false;
				}else{
					query.append(" AND suministro.marcaMedidor = :marcaMedidor");
				}
			}
			if(suministro.getFechaCorte()!= null){
				if(isFirst){
					query.append(" WHERE suministro.fechaCorte = :fechaCorte");
					isFirst = false;
				}else{
					query.append(" AND suministro.fechaCorte = :fechaCorte");
				}
			}
			if(suministro.getPropiedadMedidor()!= null){
				if(isFirst){
					query.append(" WHERE suministro.propiedadMedidor = :propiedadMedidor");
					isFirst = false;
				}else{
					query.append(" AND suministro.propiedadMedidor = :propiedadMedidor");
				}
			}
			if(suministro.getLastmodifiedbyid()!= null){
				if(isFirst){
					query.append(" WHERE suministro.lastmodifiedbyid = :lastmodifiedbyid");
					isFirst = false;
				}else{
					query.append(" AND suministro.lastmodifiedbyid = :lastmodifiedbyid");
				}
			}
			if(suministro.getIdEmpresa()!= null){
				if(isFirst){
					query.append(" WHERE suministro.idEmpresa = :idEmpresa");
					isFirst = false;
				}else{
					query.append(" AND suministro.idEmpresa = :idEmpresa");
				}
			}
			if(suministro.getDireccion()!= null){
				if(isFirst){
					query.append(" WHERE suministro.direccion = :direccion");
					isFirst = false;
				}else{
					query.append(" AND suministro.direccion = :direccion");
				}
			}
			if(suministro.getItemContrato()!= null){
				if(isFirst){
					query.append(" WHERE suministro.itemContrato = :itemContrato");
					isFirst = false;
				}else{
					query.append(" AND suministro.itemContrato = :itemContrato");
				}
			}
			if(suministro.getRunRut()!= null){
				if(isFirst){
					query.append(" WHERE suministro.runRut = :runRut");
					isFirst = false;
				}else{
					query.append(" AND suministro.runRut = :runRut");
				}
			}
			if(suministro.getPagoEnProceso()!= null){
				if(isFirst){
					query.append(" WHERE suministro.pagoEnProceso = :pagoEnProceso");
					isFirst = false;
				}else{
					query.append(" AND suministro.pagoEnProceso = :pagoEnProceso");
				}
			}
			if(suministro.getNombreDuenoBoleta()!= null){
				if(isFirst){
					query.append(" WHERE suministro.nombreDuenoBoleta = :nombreDuenoBoleta");
					isFirst = false;
				}else{
					query.append(" AND suministro.nombreDuenoBoleta = :nombreDuenoBoleta");
				}
			}
			if(suministro.getBloque()!= null){
				if(isFirst){
					query.append(" WHERE suministro.bloque = :bloque");
					isFirst = false;
				}else{
					query.append(" AND suministro.bloque = :bloque");
				}
			}
			if(suministro.getTipoConexion()!= null){
				if(isFirst){
					query.append(" WHERE suministro.tipoConexion = :tipoConexion");
					isFirst = false;
				}else{
					query.append(" AND suministro.tipoConexion = :tipoConexion");
				}
			}
			if(suministro.getPuntoConexionRed()!= null){
				if(isFirst){
					query.append(" WHERE suministro.puntoConexionRed = :puntoConexionRed");
					isFirst = false;
				}else{
					query.append(" AND suministro.puntoConexionRed = :puntoConexionRed");
				}
			}
			if(suministro.getIdcontactonavegacion()!= null){
				if(isFirst){
					query.append(" WHERE suministro.idcontactonavegacion = :idcontactonavegacion");
					isFirst = false;
				}else{
					query.append(" AND suministro.idcontactonavegacion = :idcontactonavegacion");
				}
			}
			if(suministro.getDireccionCliente()!= null){
				if(isFirst){
					query.append(" WHERE suministro.direccionCliente = :direccionCliente");
					isFirst = false;
				}else{
					query.append(" AND suministro.direccionCliente = :direccionCliente");
				}
			}
			if(suministro.getElectrodependiente()!= null){
				if(isFirst){
					query.append(" WHERE suministro.electrodependiente = :electrodependiente");
					isFirst = false;
				}else{
					query.append(" AND suministro.electrodependiente = :electrodependiente");
				}
			}
			if(suministro.getMedidaDisciplina()!= null){
				if(isFirst){
					query.append(" WHERE suministro.medidaDisciplina = :medidaDisciplina");
					isFirst = false;
				}else{
					query.append(" AND suministro.medidaDisciplina = :medidaDisciplina");
				}
			}
			if(suministro.getHorarioRacionamiento()!= null){
				if(isFirst){
					query.append(" WHERE suministro.horarioRacionamiento = :horarioRacionamiento");
					isFirst = false;
				}else{
					query.append(" AND suministro.horarioRacionamiento = :horarioRacionamiento");
				}
			}
			if(suministro.getCasosReiterados()!= null){
				if(isFirst){
					query.append(" WHERE suministro.casosReiterados = :casosReiterados");
					isFirst = false;
				}else{
					query.append(" AND suministro.casosReiterados = :casosReiterados");
				}
			}
			if(suministro.getZonaPeligrosa()!= null){
				if(isFirst){
					query.append(" WHERE suministro.zonaPeligrosa = :zonaPeligrosa");
					isFirst = false;
				}else{
					query.append(" AND suministro.zonaPeligrosa = :zonaPeligrosa");
				}
			}
			if(suministro.getTarifa()!= null){
				if(isFirst){
					query.append(" WHERE suministro.tarifa = :tarifa");
					isFirst = false;
				}else{
					query.append(" AND suministro.tarifa = :tarifa");
				}
			}
			if(suministro.getTipoVivienda()!= null){
				if(isFirst){
					query.append(" WHERE suministro.tipoVivienda = :tipoVivienda");
					isFirst = false;
				}else{
					query.append(" AND suministro.tipoVivienda = :tipoVivienda");
				}
			}
			if(suministro.getTipoAgrupacion()!= null){
				if(isFirst){
					query.append(" WHERE suministro.tipoAgrupacion = :tipoAgrupacion");
					isFirst = false;
				}else{
					query.append(" AND suministro.tipoAgrupacion = :tipoAgrupacion");
				}
			}
			if(suministro.getAlimentador()!= null){
				if(isFirst){
					query.append(" WHERE suministro.alimentador = :alimentador");
					isFirst = false;
				}else{
					query.append(" AND suministro.alimentador = :alimentador");
				}
			}
			if(suministro.getDireccionBoleta()!= null){
				if(isFirst){
					query.append(" WHERE suministro.direccionBoleta = :direccionBoleta");
					isFirst = false;
				}else{
					query.append(" AND suministro.direccionBoleta = :direccionBoleta");
				}
			}
			if(suministro.getCuenta()!= null){
				if(isFirst){
					query.append(" WHERE suministro.cuenta = :cuenta");
					isFirst = false;
				}else{
					query.append(" AND suministro.cuenta = :cuenta");
				}
			}
			if(suministro.getSubestacionElectricaConexion()!= null){
				if(isFirst){
					query.append(" WHERE suministro.subestacionElectricaConexion = :subestacionElectricaConexion");
					isFirst = false;
				}else{
					query.append(" AND suministro.subestacionElectricaConexion = :subestacionElectricaConexion");
				}
			}
			if(suministro.getRuta()!= null){
				if(isFirst){
					query.append(" WHERE suministro.ruta = :ruta");
					isFirst = false;
				}else{
					query.append(" AND suministro.ruta = :ruta");
				}
			}
			if(suministro.getDireccionconcatenada()!= null){
				if(isFirst){
					query.append(" WHERE suministro.direccionconcatenada = :direccionconcatenada");
					isFirst = false;
				}else{
					query.append(" AND suministro.direccionconcatenada = :direccionconcatenada");
				}
			}
			if(suministro.getTipoCuenta()!= null){
				if(isFirst){
					query.append(" WHERE suministro.tipoCuenta = :tipoCuenta");
					isFirst = false;
				}else{
					query.append(" AND suministro.tipoCuenta = :tipoCuenta");
				}
			}
			if(suministro.getTipoSegmento()!= null){
				if(isFirst){
					query.append(" WHERE suministro.tipoSegmento = :tipoSegmento");
					isFirst = false;
				}else{
					query.append(" AND suministro.tipoSegmento = :tipoSegmento");
				}
			}
			if(suministro.getTipoServicio()!= null){
				if(isFirst){
					query.append(" WHERE suministro.tipoServicio = :tipoServicio");
					isFirst = false;
				}else{
					query.append(" AND suministro.tipoServicio = :tipoServicio");
				}
			}
			if(suministro.getSystemDate()!= null){
				if(isFirst){
					query.append(" WHERE suministro.systemDate = :systemDate");
					isFirst = false;
				}else{
					query.append(" AND suministro.systemDate = :systemDate");
				}
			}
			if(suministro.getCreatedDate()!= null){
				if(isFirst){
					query.append(" WHERE suministro.createdDate = :createdDate");
					isFirst = false;
				}else{
					query.append(" AND suministro.createdDate = :createdDate");
				}
			}
			
			//añadimos los valores por los que filtrara la query
			Query result = session.createQuery(query.toString());

			if(suministro.getId()!= null){
				result.setInteger("id", suministro.getId());
			}
			if(suministro.getName()!= null){
				result.setString("name", suministro.getName());
			}
			if(suministro.getFullElectric()!= null){
				result.setString("fullElectric", suministro.getFullElectric());
			}
			if(suministro.getCasosAbiertos()!= null){
				result.setBoolean("casosAbiertos", suministro.getCasosAbiertos());
			}
			if(suministro.getTipoTransformador()!= null){
				result.setString("tipoTransformador", suministro.getTipoTransformador());
			}
			if(suministro.getCreatedbyid()!= null){
				result.setString("createdbyid", suministro.getCreatedbyid());
			}
			if(suministro.getCortePorDeuda()!= null){
				result.setBoolean("cortePorDeuda", suministro.getCortePorDeuda());
			}
			if(suministro.getSfid()!= null){
				result.setString("sfid", suministro.getSfid());
			}
			if(suministro.getHcError()!= null){
				result.setString("hcError", suministro.getHcError());
			}
			if(suministro.getHcLastop()!= null){
				result.setString("hcLastop", suministro.getHcLastop());
			}
			if(suministro.getIsDeleted()!= null){
				result.setBoolean("isDeleted", suministro.getIsDeleted());
			}
			if(suministro.getTipoLectura()!= null){
				result.setString("tipoLectura", suministro.getTipoLectura());
			}
			if(suministro.getEstadoConexion()!= null){
				result.setString("estadoConexion", suministro.getEstadoConexion());
			}
			if(suministro.getVip()!= null){
				result.setString("vip", suministro.getVip());
			}
			if(suministro.getTipoMedida()!= null){
				result.setString("tipoMedida", suministro.getTipoMedida());
			}
			if(suministro.getComunaReparto() != null){
				result.setString("comunaReparto", suministro.getComunaReparto());
			}
			if(suministro.getComuna()!= null){
				result.setString("comuna", suministro.getComuna());
			}
			if(suministro.getNumeroMedidor()!= null){
				result.setString("numeroMedidor", suministro.getNumeroMedidor());
			}
			if(suministro.getDvNumeroSuministro()!= null){
				result.setString("dvNumeroSuministro", suministro.getDvNumeroSuministro());
			}
			if(suministro.getDatosClientesConDisciplina()!= null){
				result.setString("datosClientesConDisciplina", suministro.getDatosClientesConDisciplina());
			}
			if(suministro.getModeloMedidor()!= null){
				result.setString("modeloMedidor", suministro.getModeloMedidor());
			}
			if(suministro.getNumeroSuministro()!= null){
				result.setString("numeroSuministro", suministro.getNumeroSuministro());
			}
			if(suministro.getNumeroTransformador()!= null){
				result.setString("numeroTransformador", suministro.getNumeroTransformador());
			}
			if(suministro.getCondominioSector()!= null){
				result.setString("condominioSector", suministro.getCondominioSector());
			}
			if(suministro.getProcesoLectura()!= null){
				result.setString("procesoLectura", suministro.getProcesoLectura());
			}
			if(suministro.getOwnerid()!= null){
				result.setString("ownerid", suministro.getOwnerid());
			}
			if(suministro.getNombreTransformador()!= null){
				result.setString("nombreTransformador", suministro.getNombreTransformador());
			}
			if(suministro.getFechaCorte()!= null){
				result.setDate("propiedadMedidor", suministro.getFechaCorte());
			}
			if(suministro.getPropiedadMedidor()!= null){
				result.setString("propiedadMedidor", suministro.getPropiedadMedidor());
			}
			if(suministro.getLastmodifiedbyid()!= null){
				result.setString("lastmodifiedbyid", suministro.getLastmodifiedbyid());
			}
			if(suministro.getIdEmpresa()!= null){
				result.setString("idEmpresa", suministro.getIdEmpresa());
			}
			if(suministro.getDireccion()!= null){
				result.setString("direccion", suministro.getDireccion());
			}
			if(suministro.getItemContrato()!= null){
				result.setString("itemContrato", suministro.getItemContrato());
			}
			if(suministro.getRunRut()!= null){
				result.setString("runRut", suministro.getRunRut());
			}
			if(suministro.getPagoEnProceso()!= null){
				result.setBoolean("pagoEnProceso", suministro.getPagoEnProceso());
			}
			if(suministro.getNombreDuenoBoleta()!= null){
				result.setString("nombreDuenoBoleta", suministro.getNombreDuenoBoleta());
			}
			if(suministro.getBloque()!= null){
				result.setString("bloque", suministro.getBloque());
			}
			if(suministro.getTipoConexion()!= null){
				result.setString("tipoConexion", suministro.getTipoConexion());
			}
			if(suministro.getPuntoConexionRed()!= null){
				result.setString("puntoConexionRed", suministro.getPuntoConexionRed());
			}
			if(suministro.getIdcontactonavegacion()!= null){
				result.setString("idcontactonavegacion", suministro.getIdcontactonavegacion());
			}
			if(suministro.getDireccionCliente()!= null){
				result.setString("direccionCliente", suministro.getDireccionCliente());
			}
			if(suministro.getElectrodependiente()!= null){
				result.setString("electrodependiente", suministro.getElectrodependiente());
			}
			if(suministro.getMedidaDisciplina()!= null){
				result.setString("medidaDisciplina", suministro.getMedidaDisciplina());
			}
			if(suministro.getHorarioRacionamiento()!= null){
				result.setString("horarioRacionamiento", suministro.getHorarioRacionamiento());
			}
			if(suministro.getCasosReiterados()!= null){
				result.setDouble("casosReiterados", suministro.getCasosReiterados());
			}
			if(suministro.getZonaPeligrosa()!= null){
				result.setBoolean("zonaPeligrosa", suministro.getZonaPeligrosa());
			}
			if(suministro.getTarifa()!= null){
				result.setString("tarifa", suministro.getTarifa());
			}
			if(suministro.getTipoVivienda()!= null){
				result.setString("tipoVivienda", suministro.getTipoVivienda());
			}
			if(suministro.getAlimentador()!= null){
				result.setString("alimentador", suministro.getAlimentador());
			}
			if(suministro.getDireccionBoleta()!= null){
				result.setString("direccionBoleta", suministro.getDireccionBoleta());
			}
			if(suministro.getCuenta()!= null){
				result.setString("cuenta", suministro.getCuenta());
			}
			if(suministro.getSubestacionElectricaConexion()!= null){
				result.setString("subestacionElectricaConexion", suministro.getSubestacionElectricaConexion());
			}
			if(suministro.getRuta()!= null){
				result.setString("ruta", suministro.getRuta());
			}
			if(suministro.getDireccionconcatenada()!= null){
				result.setString("direccionconcatenada", suministro.getDireccionconcatenada());
			}
			if(suministro.getTipoCuenta()!= null){
				result.setString("tipoCuenta", suministro.getTipoCuenta());
			}
			if(suministro.getTipoSegmento()!= null){
				result.setString("tipoSegmento", suministro.getTipoSegmento());
			}
			if(suministro.getTipoServicio()!= null){
				result.setString("tipoServicio", suministro.getTipoServicio());
			}
			if(suministro.getSystemDate()!= null){
				result.setDate("systemDate", suministro.getSystemDate());
			}
			if(suministro.getCreatedDate()!= null){
				result.setDate("createdDate", suministro.getCreatedDate());
			}
			
			List<SuministroVO> suministrosList = result.list(); 	 
			
			logger.debug("--- Fin -- readSuministro ---");
			
			return suministrosList;

	    }catch (HibernateException e) {
	    	logger.error("--- readSuministro "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- readSuministro ---"); 
	    }finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	
	/**
	 * Actualiza la fila de Suministro correspondiente al id de Suministro. Modifica todos los campos con el valor que hay en Suministro. 
	 * 
	 * @param Suministro
	 * @return
	 */
	@Transactional
    public int updateSuministro(SuministroVO Suministro){
		
		logger.debug("--- Inicio -- updateSuministro ---");
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			
			session.update(Suministro);
			tx.commit();
			
			logger.debug("--- Fin -- updateSuministro ---");			
			return 1;
			
		}catch (HibernateException e) {
			
	    	tx.rollback();
			logger.error("--- updateSuministro "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- updateSuministro ---");
	    	return 0;
	    	
	    }finally {
	    	session.close(); 
	    }

    }
	
	
	/**
	 * Inserta un Suministro en BBDD
	 * @param Suministro
	 * @return
	 */
	public int insertSuministro(SuministroVO Suministro, Session session){
		
		logger.debug("updateSuministro -- inicio");

		int numModif = 0;

		session.save(Suministro);

		return numModif;
	}
	
}
