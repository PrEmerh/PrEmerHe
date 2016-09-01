package com.casosemergencias.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.casosemergencias.dao.vo.RelacionActivoContactoVO;

@Repository
public class RelacionActivoContactoDAO {
	
	final static Logger logger = Logger.getLogger(RelacionActivoContactoDAO.class);
		
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Devuelve una lista con todos las relaciones de activos de BBDD
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<RelacionActivoContactoVO> getSuministrosRelacionesPorContacto(String idContacto){
				
		logger.debug("--- Inicio -- getSuministrosRelacionesPorContacto ---");
		
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from RelacionActivoContactoVO rel where rel.contactoId = :idContacto");
			query.setString("idContacto", idContacto);

			List<RelacionActivoContactoVO> relacionList = query.list(); 

			logger.debug("--- Fin -- getSuministrosRelacionesPorContacto ---");
			return relacionList;
			
	    } catch (HibernateException e) {
	    	logger.error("--- getSuministrosRelacionesPorContacto ", e); 
	    	logger.error("--- Fin -- getSuministrosRelacionesPorContacto ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<RelacionActivoContactoVO> getContactosRelacionadosPorSuministro(String idSuministro){
				
		logger.debug("--- Inicio -- getContactosRelacionadosPorSuministro ---");
		
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from RelacionActivoContactoVO rel where rel.activo.suministroid = :idSuministro");
			query.setString("idSuministro", idSuministro);

			List<RelacionActivoContactoVO> relacionList = query.list(); 

			logger.debug("--- Fin -- getRelacionesPorContacto ---");
			return relacionList;
			
	    } catch (HibernateException e) {
	    	logger.error("--- getRelacionesPorContacto ", e); 
	    	logger.error("--- Fin -- getRelacionesPorContacto ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
}