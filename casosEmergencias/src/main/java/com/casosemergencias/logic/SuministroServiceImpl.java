package com.casosemergencias.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.SuministroDAO;
import com.casosemergencias.dao.vo.SuministroVO;
import com.casosemergencias.model.Suministro;
import com.casosemergencias.util.ParserModelVO;


public class SuministroServiceImpl implements SuministroService{

final static Logger logger = Logger.getLogger(SuministroService.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private SuministroDAO suministroDao;
	
	/**
	 * Metodo que devuelve una lista con todos los suministros que hay en BBDD
	 * 
	 * @return
	 */
	@Override
	public List<Suministro> readAllSuministros() {
		
		logger.debug("--- Inicio -- readAllSuministros ---");
		
		List<Suministro> listSuministro = new ArrayList<>();
		
		List<SuministroVO> listSuministroVO = suministroDao.readAllSuministro();
		logger.debug("--- Inicio -- readAllSuministros tamano : " + listSuministroVO.size() + " ---");
		
		for(SuministroVO suministroVO : listSuministroVO){
			Suministro suministro = new Suministro();
			ParserModelVO.parseDataModelVO(suministroVO, suministro);
			listSuministro.add(suministro);
			
		}
		
		logger.debug("--- Fin -- readAllSuministros ---:"+listSuministro.size());
		
		return listSuministro;
	}
	
	public Suministro readSuministroBySfid(String sfid){
		SuministroVO suministroVO = suministroDao.readSuministroBySfid(sfid);
		//Si nos devuelve null, devolvemos null, si no, devolvemos el objeto relleno con los datos que nos devuelve BBDD
		if(suministroVO!=null){
			Suministro suministro = new Suministro();
			ParserModelVO.parseDataModelVO(suministroVO, suministro);
			return suministro;
		}
		return null;
	}
	
	

}
