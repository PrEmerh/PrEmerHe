package com.casosemergencias.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.CaseCommentDAO;
import com.casosemergencias.dao.CaseDAO;
import com.casosemergencias.dao.CaseHistoryDAO;
import com.casosemergencias.dao.vo.CaseCommentVO;
import com.casosemergencias.dao.vo.CaseVO;
import com.casosemergencias.model.CaseComment;
import com.casosemergencias.model.Caso;
import com.casosemergencias.util.ParserModelVO;

public class CaseCommentServiceImpl implements CaseCommentService{

	final static Logger logger = Logger.getLogger(CaseCommentService.class);
	
	@Autowired
	public CaseCommentDAO caseCommentDAO;
	
	@Autowired CaseDAO caseDAO;
	
	@Override
	public List<CaseComment> obtenerListaComentariosDeUnCaso(String caseSfid) {
		
		List<CaseCommentVO> listaComentariosVO = caseCommentDAO.readCaseCommentByCaseId(caseSfid);
		List<CaseComment> listaComentarios = parseaListaComentariosCasos(listaComentariosVO);
		
		return listaComentarios;
	}

	@Override
	public void guardarComentarioDeUnCaso(CaseComment comentarioCaso) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Caso obtenerDatosCasoParaComentario(String caseSfid) {
		CaseVO caseVO = caseDAO.readCaseForCommentByCaseid(caseSfid);
		Caso casoRetorno = new Caso();
		ParserModelVO.parseDataModelVO(caseVO, casoRetorno);
		
		return casoRetorno;
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
	
	@Override
	public Boolean insertCaseComment(CaseComment caseComment) {
		CaseCommentVO caseCommentVO = new CaseCommentVO();
		
		caseCommentVO.setComment(caseComment.getComment());
		caseCommentVO.setIspublished(false);
		caseCommentVO.setCaseid(caseComment.getCaseid());
		Boolean insert = caseCommentDAO.insertCaseComment(caseCommentVO);
		return insert;
	}
	

	

}
