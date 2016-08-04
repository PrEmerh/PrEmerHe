package com.casosemergencias.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.casosemergencias.dao.HerokuUserDAO;
import com.casosemergencias.dao.vo.HerokuUserVO;
import com.casosemergencias.model.User;


//las transacciones se abren y cierran aqui
public class UserServiceImpl implements UserService{
	
	final static Logger logger = Logger.getLogger(UserService.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private HerokuUserDAO herokuUserDao;
	
	
	/**
	 * Metodo que dado un usuario y una contraseña, recupera de BBDD un HerokuUser. Si no existe devuelve null
	 * 
	 * @param user
	 * @param pass
	 * @return
	 */
	@Override
	public User readUserPass(String user, String pass) {

		logger.info("--- Inicio -- readUserPass ---");
		User userView = new User();
				
		HerokuUserVO herokuUser = new HerokuUserVO();
		herokuUser.setUsername(user);
		herokuUser.setPassword(pass);
		
		
		List<HerokuUserVO> listHerokuUser = new ArrayList<HerokuUserVO>();
		listHerokuUser = herokuUserDao.readHerokuUser(herokuUser);
		
		if(listHerokuUser != null && !listHerokuUser.isEmpty()){
			//El UserName es unico, por lo tanto  listHerokuUser solo tendra un dato
			herokuUser = listHerokuUser.get(0);
			
			//guardamos el HerokuUser en UserView
			userView.setId(herokuUser.getId());
			userView.setName(herokuUser.getName());
			userView.setUser(herokuUser.getUsername());
			userView.setPass(herokuUser.getPassword());
			userView.setEmail(herokuUser.getEmail());
			userView.setEnvioEmail(herokuUser.getEnvioMail());
			
			logger.info("--- Fin -- readUserPass -- Existe usuario y password ---");
			
			return userView;
			
		}else{
			//si no existen datos devuelvo el usuario vacio
			logger.info("--- Fin -- readUserPass -- No existe usuario y password ---");
			return null;
		}

	}
	

	/**
	 * Metodo que dado un usuario y una contraseña, recupera de BBDD un HerokuUser. Si no existe devuelve null
	 * 
	 * @param user
	 * @param pass
	 * @return
	 */
	@Override
	public User readUser(String userName) {

		logger.info("--- Inicio -- readUser ---");
		User userView = new User();
				
		HerokuUserVO herokuUser = new HerokuUserVO();
		herokuUser.setUsername(userName);		
		
		List<HerokuUserVO> listHerokuUser = new ArrayList<HerokuUserVO>();
		listHerokuUser = herokuUserDao.readHerokuUser(herokuUser);
		
		if(listHerokuUser != null && !listHerokuUser.isEmpty()){
			//El UserName es unico, por lo tanto  listHerokuUser solo tendra un dato
			herokuUser = listHerokuUser.get(0);
			
			//guardamos el HerokuUser en UserView
			userView.setId(herokuUser.getId());
			userView.setName(herokuUser.getName());
			userView.setUser(herokuUser.getUsername());
			userView.setPass(herokuUser.getPassword());
			userView.setEmail(herokuUser.getEmail());
			userView.setEnvioEmail(herokuUser.getEnvioMail());
			
			logger.info("--- Fin -- readUser -- Existe usuario y password ---");
			
			return userView;
			
		}else{
			//si no existen datos devuelvo el usuario vacio
			logger.info("--- Fin -- readUser -- No existe usuario y password ---");
			return null;
		}

	}
	
	 /**
	 * Pone a true el campo envioEmail de HerokuUser. Le pasamos un User del que utilizaremos el id para recuperar los datos del HerokuUser que modificaremos
	 * 
	 * @param userChangEmail
	 * @return
	 */
	@Override
	public boolean changeEnvioEmail(User userChangEmail){
		logger.info("--- Inicio -- changeEnvioEmail ---");
		
		//Creamos un HerokuUser con ide de userChangEmail para que en el update sepa que usuario modificar y enviaoEmail = true
		HerokuUserVO herokuUser = new HerokuUserVO();
		herokuUser = herokuUserDao.readHerokuUserById(userChangEmail.getId());
		herokuUser.setEnvioMail(true);
		
		int row = this.herokuUserDao.updateHerokuUser(herokuUser);
		if(row>0){
			logger.info("--- Fin -- changeEnvioEmail ---");
			return true;
		}else{
			logger.info("--- Fin -- changeEnvioEmail ---");
			return false;
		}
		
	}
	
	 /**
	 * Recupera el herokuUser con sfid pasado por parametro y le modifica la password 
	 * 
	 * @param newpass
	 * @param sfid
	 * @return
	 */
	@Override
	public boolean changePassHerokuUser (String newpass, String sfid){
		
		logger.info("--- Inicio -- changePassHerokuUser ---");
		
		//Creamos un HerokuUser con ide de userChangEmail para que en el update sepa que usuario modificar y enviaoEmail = true
		HerokuUserVO herokuUser = new HerokuUserVO();
		herokuUser = herokuUserDao.readHerokuUserBySfid(sfid);
		herokuUser.setPassword(newpass);
		
		int row =  this.herokuUserDao.updateHerokuUser(herokuUser);
		if(row>0){
			logger.info("--- Fin -- changePassHerokuUser ---");
			return true;
		}else{
			logger.info("--- Fin -- changePassHerokuUser ---");
			return false;
		}
			
	}
	
	
	@Transactional
	@Override
	public void insertUser() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try{
			HerokuUserVO herokuUser1 = new HerokuUserVO();
			herokuUser1.setName("User3");
			herokuUser1.setPassword("User3");
			herokuUser1.setEnvioMail(false);
			herokuUser1.setUsername("User3");
			herokuUser1.setActivo(false);
			herokuUser1.setEmail("user1@email.com");
			herokuUser1.setCreatedDate(new Date());
			
			HerokuUserVO herokuUser2 = new HerokuUserVO();
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
