package com.casosemergencias.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.casosemergencias.dao.vo.CaseHistoryVO;

@Repository
public class CaseHistoryDAO {
	
	final static Logger logger = Logger.getLogger(CaseHistoryDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Devuelve una lista con todas los CaseHistory de un caseId
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CaseHistoryVO> readCaseHistoryByCaseId(String caseId) {
		logger.debug("--- Inicio -- readCaseHistoryByCaseId ---");
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from CaseHistoryVO as caseHistory WHERE caseHistory.caseid = :caseId");
			query.setString("caseId", caseId);
			
			List<CaseHistoryVO> caseHistoryList = query.list(); 

			logger.debug("--- Fin -- readCaseHistoryByCaseId ---");
			
			return caseHistoryList;
			
	    } catch (HibernateException e) {
	    	logger.error("--- readCaseHistoryByCaseId ", e); 
	    	logger.error("--- Fin -- readCaseHistoryByCaseId ---");
	    } finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	
	/**
	 * Devuelve una lista con todas los CaseHistory de BBDD
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CaseHistoryVO> readAllCaseHistory() {
		logger.debug("--- Inicio -- readAllCaseHistory ---");
		Session session = sessionFactory.openSession();
				
		try {
			Query query = session.createQuery("from CaseHistoryVO");
			List<CaseHistoryVO> caseHistoryList = query.list(); 

			logger.debug("--- Fin -- readAllCaseHistory ---");
			
			return caseHistoryList;
			
	    } catch (HibernateException e) {
	    	logger.error("--- readAllCaseHistory ", e); 
	    	logger.error("--- Fin -- readAllCaseHistory ---");
	    } finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	/**
	 * Devuelve el CaseHistory que tiene como id el pasado por parametro al metodo
	 * 
	 * @param id - id de un CaseHistory
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public CaseHistoryVO readCaseHistoryById(Integer id) {
		
		logger.debug("--- Inicio -- readCaseHistoryById ---");
		
		Session session = sessionFactory.openSession();
			
		try {
			Query query = session.createQuery("from CaseHistoryVO as caseHistory WHERE caseHistory.id = :id");
			query.setInteger("id", id);
			
			List<CaseHistoryVO> caseHistoryList = query.list(); 

			if(caseHistoryList != null && !caseHistoryList.isEmpty()){
				return caseHistoryList.get(0);
			}			
			
			logger.debug("--- Fin -- readCaseHistoryById ---");
			
	    } catch (HibernateException e) {
	    	logger.error("--- readCaseHistoryById ", e); 
	    	logger.error("--- Fin -- readCaseHistoryById ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	/**
	 * Devuelve una CaseHistory que tiene como id. el pasado por parámetro al método.
	 * 
	 * @param sfid Id. del CaseHistory.
	 * @return CaseHistoryVO
	 */
	@SuppressWarnings("unchecked")
	public CaseHistoryVO readCaseHistoryBySfid(String sfid) {
		logger.debug("--- Inicio -- readCaseHistoryBySfid ---");
		Session session = sessionFactory.openSession();
		
		try {
			Query query = session.createQuery("from CaseHistoryVO caseHistory WHERE caseHistory.sfid = :sfid ");
			query.setString("sfid", sfid);
			List<CaseHistoryVO> caseHistoryList = query.list(); 
			
			if (caseHistoryList != null && !caseHistoryList.isEmpty()) {
				return caseHistoryList.get(0);
			}
			
			logger.debug("--- Fin -- readCaseHistoryBySfid ---");
	    } catch (HibernateException e) {
	    	logger.error("--- readCaseHistoryBySfid ", e); 
	    	logger.error("--- Fin -- readCaseHistoryBySfid ---");
	    } finally {
	    	session.close(); 
	    }
	    return null;
	}
}
