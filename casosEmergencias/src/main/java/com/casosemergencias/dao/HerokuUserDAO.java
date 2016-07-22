package com.casosemergencias.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class HerokuUserDAO {
	
	final static Logger logger = Logger.getLogger(HerokuUserDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private String a;
	private String b;
	
	/**
	 * Devuelve una lista con todos los HerokuUser de BBDD
	 * 
	 * @return
	 */
	public List<HerokuUser> readAllHerokuUser(){
				
		Session session = sessionFactory.openSession();
				
		try{
			Query query = session.createQuery("from HerokuUser");
			
			List<HerokuUser> userList = query.list(); 

			return userList;
			
	    }catch (HibernateException e) {
	    	e.printStackTrace(); 
	    }finally {
	    	session.close(); 
	    }
	      return null;
	}
	
	
	/**
	 * Devuelve el HerokuUser que tiene como id el pasado por parametro al metodo
	 * 
	 * @param id
	 * @return
	 */
	public HerokuUser readHerokuUserById(Integer id){
		
		Session session = sessionFactory.openSession();
				
		try{
			Query query = session.createQuery("from HerokuUser as herUser WHERE herUser.id = :id");
			query.setInteger("id", id);
			
			List<HerokuUser> userList = query.list(); 

			if(userList != null){
				return userList.get(0);
			}			
			
	    }catch (HibernateException e) {
	    	e.printStackTrace(); 
	    }finally {
	    	session.close(); 
	    }
		
	    return null;
	    
	}
	

	/**
	 * Dado un HerokuUser, recupera una lista de HerokuUser con los mismos datos que HerokuUser
	 * @param herokuUser
	 * @return
	 */
	public List<HerokuUser> readHerokuUser(HerokuUser herokuUser){
		logger.debug("readHerokuUser -- inicio");
		
		Session session = sessionFactory.openSession();
		boolean isFirst = true;
	
	    try{
	    	//preparamos la query
	    	StringBuilder query = new StringBuilder("from HerokuUser as herUser");
			if(herokuUser.getId()!= null){
				if(isFirst){
					query.append(" WHERE herUser.id = :id");
					isFirst = false;
				}else{
					query.append(" AND herUser.id = :id");
				}
			}
			if(herokuUser.getName()!= null){
				if(isFirst){
					query.append(" WHERE herUser.name = :name");
					isFirst = false;
				}else{
					query.append(" AND herUser.name = :name");
				}
			}
			if(herokuUser.getUsername()!= null){
				if(isFirst){
					query.append(" WHERE herUser.username = :username");
					isFirst = false;
				}else{
					query.append(" AND herUser.username = :username");
				}
			}
			if(herokuUser.getPassword()!= null){
				if(isFirst){
					query.append(" WHERE herUser.password = :password");
					isFirst = false;
				}else{
					query.append(" AND herUser.password = :password");
				}
			}
			if(herokuUser.getEmail()!= null){
				if(isFirst){
					query.append(" WHERE herUser.email = :email");
					isFirst = false;
				}else{
					query.append(" AND herUser.email = :email");
				}
			}
			if(herokuUser.getEnvioMail()!= null){
				if(isFirst){
					query.append(" WHERE herUser.envioMail = :envioMail");
					isFirst = false;
				}else{
					query.append(" AND herUser.envioMail = :envioMail");
				}
			}
			if(herokuUser.getActivo()!= null){
				if(isFirst){
					query.append(" WHERE herUser.activo = :activo");
					isFirst = false;
				}else{
					query.append(" AND herUser.activo = :activo");
				}
			}
			if(herokuUser.getSfid()!= null){
				if(isFirst){
					query.append(" WHERE herUser.sfid = :sfid");
					isFirst = false;
				}else{
					query.append(" AND herUser.sfid = :sfid");
				}
			}
			if(herokuUser.getHcError()!= null){
				if(isFirst){
					query.append(" WHERE herUser.hcError = :hcError");
					isFirst = false;
				}else{
					query.append(" AND herUser.hcError = :hcError");
				}
			}
			if(herokuUser.getHcLastop()!= null){
				if(isFirst){
					query.append(" WHERE herUser.hcLastop = :hcLastop");
					isFirst = false;
				}else{
					query.append(" AND herUser.hcLastop = :hcLastop");
				}
			}
			if(herokuUser.getIsDeleted()!= null){
				if(isFirst){
					query.append(" WHERE herUser.isDeleted = :isDeleted");
					isFirst = false;
				}else{
					query.append(" AND herUser.isDeleted = :isDeleted");
				}
			}
			if(herokuUser.getSystemDate()!= null){
				if(isFirst){
					query.append(" WHERE herUser.systemDate = :systemDate");
					isFirst = false;
				}else{
					query.append(" AND herUser.systemDate = :systemDate");
				}
			}
			if(herokuUser.getCreatedDate()!= null){
				if(isFirst){
					query.append(" WHERE herUser.createdDate = :createdDate");
					isFirst = false;
				}else{
					query.append(" AND herUser.createdDate = :createdDate");
				}
			}
			
			//añadimos los valores por los que filtrara la query
			Query result = session.createQuery(query.toString());

			if(herokuUser.getId()!= null){
				result.setInteger("id", herokuUser.getId());
			}
			if(herokuUser.getName()!= null){
				result.setString("name", herokuUser.getName());
			}
			if(herokuUser.getUsername()!= null){
				result.setString("username", herokuUser.getUsername());
			}
			if(herokuUser.getPassword()!= null){
				result.setString("password", herokuUser.getPassword());
			}
			if(herokuUser.getEmail()!= null){
				result.setString("email", herokuUser.getEmail());
			}
			if(herokuUser.getEnvioMail()!= null){
				result.setBoolean("envioMail", herokuUser.getEnvioMail());
			}
			if(herokuUser.getActivo()!= null){
				result.setBoolean("activo", herokuUser.getActivo());
			}
			if(herokuUser.getSfid()!= null){
				result.setString("sfid", herokuUser.getSfid());
			}
			if(herokuUser.getHcError()!= null){
				result.setString("hcError", herokuUser.getHcError());
			}
			if(herokuUser.getHcLastop()!= null){
				result.setString("hcLastop", herokuUser.getHcLastop());
			}
			if(herokuUser.getIsDeleted()!= null){
				result.setBoolean("isDeleted", herokuUser.getIsDeleted());
			}
			if(herokuUser.getSystemDate()!= null){
				result.setDate("systemDate", herokuUser.getSystemDate());
			}
			if(herokuUser.getCreatedDate()!= null){
				result.setDate("createdDate", herokuUser.getCreatedDate());
			}
			
			List<HerokuUser> userList = result.list(); 	 
			
			return userList;

	    }catch (HibernateException e) {
	    	logger.error("readHerokuUser "+ e.getMessage());
	    	logger.error(e.getStackTrace()); 
	    }finally {
	    	session.close(); 
	    }
	    return null;
	}
	
	/**
	 * Inserta un HerokuUser en BBDD
	 * @param herokuUser
	 * @return
	 */
	public int insertHerokuUser(HerokuUser herokuUser, Session session){
		logger.debug("updateHerokuUser -- inicio");
		
//		Session session = sessionFactory.openSession();
		int numModif = 0;
//		session.setAutocommit(false); 
//		StringBuilder query = new StringBuilder("INSERT INTO HerokuUser(name, createddate, password, envioMail, username, activo,  email) VALUES("); 
//				query.append(herokuUser.getName()+", ");
//				query.append(new Date()+", ");
//				query.append(herokuUser.getPassword()+", ");
//				if(herokuUser.getEnvioMail()!= null){
//					query.append(herokuUser.getEnvioMail()+", ");
//				}else{
//					query.append(false);
//				}
//				query.append(herokuUser.getUsername()+", ");
//				query.append(herokuUser.getActivo()+", ");
//				query.append(herokuUser.getEmail()+")");	
		//añadimos los valores por los que filtrara la query
//		Query result = session.createSQLQuery(query.toString());

//		numModif = result.executeUpdate();
		session.save(herokuUser);
		    
		
		
		return numModif;
	}
	

}
