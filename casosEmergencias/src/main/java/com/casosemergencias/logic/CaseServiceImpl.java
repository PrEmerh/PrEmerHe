package com.casosemergencias.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.CaseCommentDAO;
import com.casosemergencias.dao.CaseDAO;
import com.casosemergencias.dao.CaseHistoryDAO;
import com.casosemergencias.dao.vo.CaseCommentVO;
import com.casosemergencias.dao.vo.CaseHistoryVO;
import com.casosemergencias.dao.vo.CaseVO;
import com.casosemergencias.model.CaseComment;
import com.casosemergencias.model.CaseHistory;
import com.casosemergencias.model.Caso;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.datatables.DataTableProperties;

public class CaseServiceImpl implements CaseService{

final static Logger logger = Logger.getLogger(CaseService.class);
	
	@Autowired
	private CaseDAO caseDao;
	
	@Autowired
	private CaseHistoryDAO caseHistoryDao;
	
	@Autowired
	private CaseCommentDAO caseCommentDao;
	
	/**
	 * Metodo que devuelve una lista con todos los Casos que hay en BBDD
	 * 
	 * @return
	 */
	@Override
	public List<Caso> readAllCase(DataTableProperties propDatatable) {
		
		logger.debug("--- Inicio -- readAllCase ---");
		
		List<Caso> listCaso = new ArrayList<>();
		List<CaseVO> listCasosVO = caseDao.readCaseDataTable(propDatatable);

		logger.debug("--- Inicio -- readAllCase casos en la lista: " + listCasosVO.size() + " ---");
		
		for (CaseVO casoVO : listCasosVO) {
			Caso caso = new Caso();
			ParserModelVO.parseDataModelVO(casoVO, caso);
			listCaso.add(caso);
		}
		
		logger.debug("--- Fin -- readAllCase ---");
		return listCaso;
	}
	
	/**
	 * Metodo que devuelve caso de BBDD por su sfid
	 * 
	 * @return
	 */
	@Override
	public Caso readCaseBySfid(String sfid){
		Caso returnCase = new Caso();
		CaseVO casoVO = caseDao.readCaseBySfid(sfid);
		if (casoVO != null){
			ParserModelVO.parseDataModelVO(casoVO, returnCase);
		}
		
		List<CaseHistoryVO> listaHistorialCasoVO = caseHistoryDao.readCaseHistoryByCaseId(sfid);
		List<CaseHistory> historialCasosRelacionado = parseaListaHistorialCasos(listaHistorialCasoVO);
		returnCase.setHistorialCaso(historialCasosRelacionado);
		
		List<CaseCommentVO> listaComentarioCasoVO = caseCommentDao.readCaseCommentByCaseId(sfid);
		List<CaseComment> comentariosCasoRelacionado = parseaListaComentariosCasos(listaComentarioCasoVO);
		returnCase.setCommentarioCaso(comentariosCasoRelacionado);
		
		return returnCase;
	}
	
	/**
	 * Metodo que devuelve caso de BBDD por su id
	 * 
	 * @return
	 */
	@Override
	public Caso readCaseById(Integer id){
		Caso returnCase = new Caso();
		CaseVO casoVO = caseDao.readCaseById(id);
		if (casoVO != null){
			ParserModelVO.parseDataModelVO(casoVO, returnCase);
		}
		return returnCase;
	}

	
	public Integer getNumCasos(DataTableProperties propDatatable){
		logger.debug("--- getNumCasos ---");
		return caseDao.getNumCasos(propDatatable);
	}
	
	public Integer insertCase(Caso caso){
		CaseVO casoVO = new CaseVO();
		ParserModelVO.parseDataModelVO(caso, casoVO);
		Integer id = caseDao.insertCase(casoVO);
		return id;
	}

	@Override
	public Integer updateCase(Caso caso) {
		CaseVO casoVO = new CaseVO();
		casoVO = caseDao.readCaseBySfid(caso.getSfid());
		
		casoVO.setDescription(caso.getDescription());
		Integer id = caseDao.updateCase(casoVO);
		return id;
	}
	
	private List<CaseHistory> parseaListaHistorialCasos(List<CaseHistoryVO> listaCaseHistoryVO) {
		if(listaCaseHistoryVO!=null && !listaCaseHistoryVO.isEmpty()){
			List<CaseHistory> retorno = new ArrayList<CaseHistory>();
			for(CaseHistoryVO historiaCasoVO: listaCaseHistoryVO){
				CaseHistory casoRelacionado = new CaseHistory();
				ParserModelVO.parseDataModelVO(historiaCasoVO, casoRelacionado);
				retorno.add(casoRelacionado);
			}
			return retorno;
		}
		return null;
	}
	
	private List<CaseComment> parseaListaComentariosCasos(List<CaseCommentVO> listaCaseCommentVO) {
		if(listaCaseCommentVO!=null && !listaCaseCommentVO.isEmpty()){
			List<CaseComment> retorno = new ArrayList<CaseComment>();
			for(CaseCommentVO comentarioCasoVO: listaCaseCommentVO){
				CaseComment casoRelacionado = new CaseComment();
				ParserModelVO.parseDataModelVO(comentarioCasoVO, casoRelacionado);
				retorno.add(casoRelacionado);
			}
			return retorno;
		}
		return null;
	}
}
