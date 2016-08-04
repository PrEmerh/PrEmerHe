package com.casosemergencias.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.CaseDAO;
import com.casosemergencias.dao.vo.CaseVO;
import com.casosemergencias.model.Caso;
import com.casosemergencias.model.Contacto;
import com.casosemergencias.model.Cuenta;
import com.casosemergencias.model.Direccion;
import com.casosemergencias.model.Suministro;
import com.casosemergencias.util.ParserModelVO;

public class CaseServiceImpl implements CaseService{

final static Logger logger = Logger.getLogger(CaseService.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CaseDAO caseDao;
	
	/**
	 * Metodo que devuelve una lista con todos los Casos que hay en BBDD
	 * 
	 * @return
	 */
	@Override
	public List<Caso> readAllCase() {
		
		logger.debug("--- Inicio -- readAllCase ---");
		
		List<Caso> listCaso = new ArrayList<>();
		
		List<CaseVO> listCasosVO = caseDao.readAllCaseDescriptionPick();
		logger.debug("--- Inicio -- readAllCase tamano : " + listCasosVO.size() + " ---");
		
		for(CaseVO casoVO : listCasosVO){
			Caso caso = new Caso();
			ParserModelVO.parseDataModelVO(casoVO, caso);
			/*caso.setId(casoVO.getId());
			caso.setSfid(casoVO.getSfid());
			caso.setMotivo(casoVO.getPeticion());
			caso.setNumeroCaso(casoVO.getNumeroCaso());
			caso.setNumeroInservice(casoVO.getNumeroInservice());
			caso.setFechaApertura(casoVO.getCreatedDate());
			caso.setFechaEstimadoNormalizacion(casoVO.getFechaEstimadaCierre());
			caso.setPropietarioCaso(casoVO.getOwnerid());
			caso.setFechaCierre(casoVO.getClosedDate());
			caso.setSubMotivo(casoVO.getMotivoEmpresa());
			caso.setCondicionAgravante(casoVO.getCondicionAgravante());
			caso.setTipoAtencionInterna(casoVO.getTipoAtencionInterna());
			caso.setContacto(new Contacto()); //Añadir los datos del contacto
			caso.setSuministro(new Suministro()); //añadir los datos del suministro
			caso.setDireccion(new Direccion()); //añadir los datos de la direccion
			caso.setCuenta(new Cuenta()); //añadir los datos de la cuenta
			caso.setDireccionSuministro(casoVO.getDireccionSuministro());
			caso.setComuna(casoVO.getComunaF());
			caso.setNumeroMedidor(casoVO.getNumeroMedidor());
			caso.setCuerpoMail(casoVO.getCuerpoMail());
			caso.setRespuestaCliente(casoVO.getRespuestaAlCliente());
			caso.setEstado(casoVO.getEstado());
			caso.setSubEstado(casoVO.getSubEstado());
			caso.setCanalOrigen(casoVO.getOrigin());
			caso.setUnidad(casoVO.getCallCenter());
			caso.setCasoPrincipal(casoVO.getParentid()); //buscar el nombre de este
			caso.setAsunto(casoVO.getSubject());
			caso.setDescripcion(casoVO.getDescription());
			caso.setTipoAtencionSEC(casoVO.getTipoAtencionSec());
			caso.setCanalNotificacion(casoVO.getCanalNotificacion());
			caso.setTelefonoContacto(casoVO.getTelefonoContacto());
			caso.setEmailNotificacion(casoVO.getEmailNotificacion());
			caso.setIdFacebook(casoVO.getFacebook());
			caso.setTwitter(casoVO.getTwitter());
//			caso.setActualizarDatosContancto(casoVO.getActDatosContacto());
			caso.setAni(casoVO.getAni());
			caso.setFavorabilidadCaso(casoVO.getFavorabilidadDelCaso());
			caso.setEstadoPickList(casoVO.getEstadoPickList());*/
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

}
