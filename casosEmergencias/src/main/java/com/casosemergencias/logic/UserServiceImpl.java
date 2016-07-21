package com.casosemergencias.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.casosemergencias.controller.LoginController;
import com.casosemergencias.dao.HerokuUser;
import com.casosemergencias.dao.HerokuUserDAO;
import com.casosemergencias.model.User;


//las transacciones se abren y cierran aqui
public class UserServiceImpl implements UserService{
	
	final static Logger logger = Logger.getLogger(UserService.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private HerokuUserDAO herokuUserDao;
	
	/**
	 * Dado un usuario y una contraseña, busca en BBDD si existe. Si existe, devuelve el objeto user, si no devuelve null.
	 * */
	@Override
	public User readUser(String user, String pass) {

		logger.info("Inicio readUser");
		User userView = new User();
				
		HerokuUser herokuUser = new HerokuUser();
		herokuUser.setUsername(user);
		herokuUser.setPassword(pass);
		
		
		List<HerokuUser> listHerokuUser = new ArrayList<HerokuUser>();
		listHerokuUser = herokuUserDao.readHerokuUser(herokuUser);
		
		if(listHerokuUser != null && !listHerokuUser.isEmpty()){
			//Si la lista no esta vacia y tiene solo un dato, el usuario y contraseña es correcta
			//Si tiene mas de un elemento tenemos un problema 
			herokuUser = listHerokuUser.get(0);
			
			//guardamos el HerokuUser en UserView
			userView.setId(herokuUser.getId());
			userView.setName(herokuUser.getName());
			userView.setUser(herokuUser.getUsername());
			userView.setPass(herokuUser.getPassword());
			userView.setEmail(herokuUser.getEmail());
			
			logger.info("Fin readUser - Existe usuario y password");
			
			return userView;
			
		}else{
			//si no existen datos devuelvo el usuario vacio
			logger.info("Fin readUser - No existe usuario y password");
			return null;
		}

	}
	
	@Transactional
	@Override
	public void insertUser() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try{
			HerokuUser herokuUser1 = new HerokuUser();
			herokuUser1.setName("User3");
			herokuUser1.setPassword("User3");
			herokuUser1.setEnvioMail(false);
			herokuUser1.setUsername("User3");
			herokuUser1.setActivo(false);
			herokuUser1.setEmail("user1@email.com");
			herokuUser1.setCreatedDate(new Date());
			
			HerokuUser herokuUser2 = new HerokuUser();
			herokuUser2.setName("User4");
			herokuUser2.setPassword("User4");
			herokuUser2.setEnvioMail(false);
			herokuUser2.setUsername("User4");
			herokuUser2.setActivo(true);
			herokuUser2.setEmail("user2@email.com");
			herokuUserDao.insertHerokuUser(herokuUser1, session);
			herokuUserDao.insertHerokuUser(herokuUser2, session);
			
			tx.commit();

	 	}catch (Exception e) {
	    	logger.error("readHerokuUser "+ e.getMessage());
	    	logger.error(e.getStackTrace()); 
	    	tx.rollback();
	    }finally {
	    	session.close(); 
	    }
	
	}


}
