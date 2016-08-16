package com.casosemergencias.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.CaseDAO;
import com.casosemergencias.dao.SuministroDAO;
import com.casosemergencias.dao.vo.CaseVO;
import com.casosemergencias.dao.vo.SuministroVO;
import com.casosemergencias.model.Caso;
import com.casosemergencias.model.Suministro;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.datatables.DataTableProperties;


public class SuministroServiceImpl implements SuministroService{

final static Logger logger = Logger.getLogger(SuministroService.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private SuministroDAO suministroDao;
	
	@Autowired
	private CaseDAO casoDAO;
	
	@Override
	public List<Suministro> readAllSuministros() {
		
		logger.debug("--- Inicio -- readAllSuministros ---");
		
		List<Suministro> listSuministro = new ArrayList<>();
		
		List<SuministroVO> listSuministroVO = suministroDao.readAllSuministro();
		logger.debug("--- Inicio -- readAllSuministros cantidad : " + listSuministroVO.size() + " ---");
		
		for(SuministroVO suministroVO : listSuministroVO){
			Suministro suministro = new Suministro();
			ParserModelVO.parseDataModelVO(suministroVO, suministro);
			listSuministro.add(suministro);
			
		}
		
		logger.debug("--- Fin -- readAllSuministros ---:"+listSuministro.size());
		
		return listSuministro;
	}
	
	/**
	 * Metodo que devuelve una lista con todos los suministros que hay en BBDD
	 * 
	 * @return
	 */
	@Override
	public List<Suministro> readAllSuministros(DataTableProperties propDatatable) {
		
		logger.debug("--- Inicio -- readAllSuministros ---");
		
		List<Suministro> listSuministro = new ArrayList<>();
		
		//List<SuministroVO> listSuministroVO = suministroDao.readAllSuministro();
		List<SuministroVO> listSuministroVO = suministroDao.readSuministroDataTable(propDatatable);
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
		Suministro suministro = new Suministro();
		//Si nos devuelve null, devolvemos null, si no, devolvemos el objeto relleno con los datos que nos devuelve BBDD
		if(suministroVO!=null){
			ParserModelVO.parseDataModelVO(suministroVO, suministro);
			List<CaseVO> listacasosVO = casoDAO.readCaseOfSuministro(sfid);
			List<Caso> casoRelacionado = parseaListaCasos(listacasosVO);
			suministro.setCasos(casoRelacionado);
			return suministro;
		}
		return null;
	}
	
	private List<Caso> parseaListaCasos(List<CaseVO> listacasosVO) {
		if(listacasosVO!=null && !listacasosVO.isEmpty()){
			List<Caso> retorno = new ArrayList<Caso>();
			for(CaseVO casoVO: listacasosVO){
				Caso casoRelacionado = new Caso();
				ParserModelVO.parseDataModelVO(casoVO, casoRelacionado);
				retorno.add(casoRelacionado);
			}
			return retorno;
		}
		return null;
	}

	public Integer getNumSuministros(DataTableProperties propDatatable){
		return suministroDao.countSuministro(propDatatable);
	}

}
