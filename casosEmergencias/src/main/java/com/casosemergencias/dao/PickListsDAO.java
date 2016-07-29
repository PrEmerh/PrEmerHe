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
public class PickListsDAO {
	
	final static Logger logger = Logger.getLogger(PickListsDAO.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Devuelve una lista con todos los PickLists de BBDD
	 * 
	 * @return
	 */
	public List<PickListsVO> readAllPickLists(){
				
		logger.debug("--- Inicio -- readAllPickLists ---");
		
		Session session = sessionFactory.openSession();
				
		try{
			Query query = session.createQuery("from PickListsVO");
			
			List<PickListsVO> pickList = query.list(); 

			logger.debug("--- Fin -- readAllPickLists ---");
			
			return pickList;
			
	    }catch (HibernateException e) {
	    	logger.error("--- readAllPickLists "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- readAllPickLists ---");
	    }finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	
	/**
	 * Devuelve el PickLists que tiene como id el pasado por parametro al metodo
	 * 
	 * @param id - id de un PickLists
	 * @return
	 */
	public PickListsVO readPickListsById(Integer id){
		
		logger.debug("--- Inicio -- readPickListsById ---");
		
		Session session = sessionFactory.openSession();
				
		try{
			Query query = session.createQuery("from PickListsVO as pickList WHERE pickList.id = :id");
			query.setInteger("id", id);
			
			List<PickListsVO> pickList = query.list(); 

			if(pickList != null){
				return pickList.get(0);
			}			
			
			logger.debug("--- Fin -- readPickListsById ---");
			
	    }catch (HibernateException e) {
	    	logger.error("--- readPickListsById "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- readPickListsById ---");
	    }finally {
	    	session.close(); 
	    }
		
	    return null;
	    
	}
	

	/**
	 * Dado un PickLists, recupera una lista de HerokuUser con los mismos datos que PickLists
	 * 
	 * @param pickList
	 * @return
	 */
	public List<PickListsVO> readPickListsUser(PickListsVO pickListVo){
		
		logger.debug("--- Inicio -- readPickListsUser ---");
		
		Session session = sessionFactory.openSession();
		boolean isFirst = true;
	
	    try{
	    	//preparamos la query
	    	StringBuilder query = new StringBuilder("from PickListsVO as pickList");
			if(pickListVo.getId()!= null){
				if(isFirst){
					query.append(" WHERE pickList.id = :id");
					isFirst = false;
				}else{
					query.append(" AND pickList.id = :id");
				}
			}
			if(pickListVo.getObjeto()!= null){
				if(isFirst){
					query.append(" WHERE pickList.objeto = :objeto");
					isFirst = false;
				}else{
					query.append(" AND pickList.objeto = :objeto");
				}
			}	
			if(pickListVo.getCampo()!= null){
				if(isFirst){
					query.append(" WHERE pickList.campo = :campo");
					isFirst = false;
				}else{
					query.append(" AND pickList.campo = :campo");
				}
			}
			if(pickListVo.getCodigo()!= null){
				if(isFirst){
					query.append(" WHERE pickList.codigo = :codigo");
					isFirst = false;
				}else{
					query.append(" AND pickList.codigo = :codigo");
				}
			}
			if(pickListVo.getValor()!= null){
				if(isFirst){
					query.append(" WHERE pickList.valor = :valor");
					isFirst = false;
				}else{
					query.append(" AND pickList.valor = :valor");
				}
			}
			
			//añadimos los valores por los que filtrara la query
			Query result = session.createQuery(query.toString());

			if(pickListVo.getId()!= null){
				result.setInteger("id", pickListVo.getId());
			}
			if(pickListVo.getObjeto()!= null){
				result.setString("objeto", pickListVo.getObjeto());
			}
			if(pickListVo.getCampo()!= null){
				result.setString("campo", pickListVo.getCampo());
			}
			if(pickListVo.getCodigo()!= null){
				result.setString("codigo", pickListVo.getCodigo());
			}
			if(pickListVo.getValor()!= null){
				result.setString("valor", pickListVo.getValor());
			}
			
			List<PickListsVO> pickList = result.list(); 	 
			
			logger.debug("--- Fin -- readPickListsUser ---");
			
			return pickList;

	    }catch (HibernateException e) {
	    	logger.error("--- readPickListsUser "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- readPickListsUser ---"); 
	    }finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	/**
	 * Devuelve todos los picklist para un objeto
	 * @return
	 */
	public List<PickListsVO> readPickListsByObject(String object){
		
		logger.debug("--- Inicio -- readPickListsByObject ---");
		
		Session session = sessionFactory.openSession();
				
		try{
			Query query = session.createQuery("from PickListsVO where objeto =:objeto");
			query.setString("objeto", object);
			List<PickListsVO> pickList = query.list(); 

			logger.debug("--- Fin -- readPickListsByObject ---");
			
			return pickList;
			
	    }catch (HibernateException e) {
	    	logger.error("--- readPickListsByObject "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- readPickListsByObject ---");
	    }finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	/**
	 * Devuelve todos los picklist para un objeto
	 * @return
	 */
	public List<PickListsVO> readPickListsByField(String object, String field){
		
		logger.debug("--- Inicio -- readPickListsByField ---");
		
		Session session = sessionFactory.openSession();
				
		try{
			Query query = session.createQuery("from PickListsVO where objeto =:objeto and campo :=campo");
			query.setString("objeto", object);
			query.setString("campo", field);
			List<PickListsVO> pickList = query.list(); 

			logger.debug("--- Fin -- readPickListsByField ---");
			
			return pickList;
			
	    }catch (HibernateException e) {
	    	logger.error("--- readPickListsByField "+ e.getMessage() +"---");
	    	logger.error(e.getStackTrace()); 
	    	logger.error("--- Fin -- readPickListsByField ---");
	    }finally {
	    	session.close(); 
	    }
	      return null;
	}
}
