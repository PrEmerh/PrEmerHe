package com.casosemergencias.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.CaseDAO;
import com.casosemergencias.dao.RelacionActivoContactoDAO;
import com.casosemergencias.dao.SuministroDAO;
import com.casosemergencias.dao.vo.CaseVO;
import com.casosemergencias.dao.vo.RelacionActivoContactoVO;
import com.casosemergencias.dao.vo.SuministroVO;
import com.casosemergencias.logic.ws.clients.ConsultaDatosSuministroWSClient;
import com.casosemergencias.logic.ws.clients.GetEventosRelacionadosWSClient;
import com.casosemergencias.logic.ws.responses.ConsultaDatosSuministroWSResponse;
import com.casosemergencias.logic.ws.responses.GetEventosRelacionadosWSResponse;
import com.casosemergencias.model.Caso;
import com.casosemergencias.model.Contacto;
import com.casosemergencias.model.Suministro;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.constants.ConstantesTibcoWS;
import com.casosemergencias.util.datatables.DataTableProperties;


public class SuministroServiceImpl implements SuministroService{

	final static Logger logger = Logger.getLogger(SuministroService.class);
	
	@Autowired
	private SuministroDAO suministroDao;
	
	@Autowired
	private CaseDAO casoDAO;
	
	@Autowired
	private RelacionActivoContactoDAO relacionDAO;
		
	@Autowired
	private ConsultaDatosSuministroWSClient consultaDatosSuministroWSClient;
	
	@Autowired
	private GetEventosRelacionadosWSClient getEventosRelacionadosWSClient;
	
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
		List<Suministro> listSuministro = new ArrayList<Suministro>();
		
		List<SuministroVO> listSuministroVO = suministroDao.readSuministroDataTable(propDatatable);
		logger.debug("--- Inicio -- readAllSuministros cantidad: " + listSuministroVO.size() + " ---");
		
		for (SuministroVO suministroVO : listSuministroVO) {
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
			List<RelacionActivoContactoVO> listaRelacionVO = relacionDAO.getContactosRelacionadosPorSuministro(sfid);
			List<Contacto> contactosRelacionado = parseaListaContactosRel(listaRelacionVO);
			suministro.setContactosRelacionados(contactosRelacionado);
			
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
	private List<Contacto> parseaListaContactosRel(List<RelacionActivoContactoVO> listaRelacionVO) {
		if(listaRelacionVO!=null && !listaRelacionVO.isEmpty()){
			List<Contacto> retorno = new ArrayList<Contacto>();
			for(RelacionActivoContactoVO relacion: listaRelacionVO){
				if(relacion.getContacto()!=null ){
					Contacto contactoRelacionado = new Contacto();
					ParserModelVO.parseDataModelVO(relacion.getContacto(), contactoRelacionado);
					if(relacion.getTipoRelacionActivo()!=null)
						contactoRelacionado.setRelacionActivo(relacion.getTipoRelacionActivo().getValor());
					contactoRelacionado.setPrincipal(relacion.getPrincipal());
					retorno.add(contactoRelacionado);
				}
			}
			return retorno;
		}
		return null;
	}

	public Integer getNumSuministros(DataTableProperties propDatatable){
		return suministroDao.countSuministro(propDatatable);
	}

	/**
	 * M&eacute;todo que realiza la llamada a los servicios web de TIBCO para
	 * devolver la informaci&oacute;n del suministro y sus eventos relacionados.
	 * 
	 * @param numSuministro
	 *            N&uacute;mero del suministro.
	 * @return Map<String, Object> Mapa con los objetos de los dos servicios
	 *         web.
	 */
	public Map<String, Object> getDatosSuministroWS(String numSuministro) {
		logger.debug("--- Inicio -- getDatosSuministroWS ---");
		Map<String, Object> datosWS = new HashMap<String, Object>();
		
		logger.info("------>>>>> Llamando al servicio de consulta de datos de suministro ------>>>>>");
		ConsultaDatosSuministroWSResponse datosSumResponse = consultaDatosSuministroWSClient.consultarDatosSuministroWS(numSuministro, ConstantesTibcoWS.TIBCO_WS_SIRES033_ID_EMPRESA);
		if (datosSumResponse != null) {
			if (datosSumResponse.getMapaErrores() != null) {
				if (datosSumResponse.getMapaErrores().containsKey("0")) {
					logger.info("Peticion procesada correctamente");
				} else {
					logger.error("Error en la llamada al servicio: ");
					for (Map.Entry<String,String> entry : datosSumResponse.getMapaErrores().entrySet()) {
						logger.error("- Error " + entry.getKey() + ": " + entry.getValue());
					}
				}
			} else {
				logger.info("Registros encontrados: " + datosSumResponse.getTotalRegistros());
				if (datosSumResponse.getListadoSuministros() != null && !datosSumResponse.getListadoSuministros().getSuministro().isEmpty()) {
					datosWS.put(ConstantesTibcoWS.SIRES033_RESPONSE_LIST_NAME, datosSumResponse.getListadoSuministros());
				}
			}
		} else {
			logger.error("El servicio ha devuelto una respuesta vacia");
		}
		logger.info("<<<<<------ Llamada al servicio de consulta de datos de suministro completa <<<<<------");
		logger.info("------>>>>> Llamando al servicio de consulta de eventos relacionados con un suministro ------>>>>>");
		GetEventosRelacionadosWSResponse eventosRelResponse = getEventosRelacionadosWSClient.getEventosRelacionadosWS(numSuministro, ConstantesTibcoWS.TIBCO_WS_SIRES033_ID_EMPRESA);
		if (eventosRelResponse != null) {
			if (eventosRelResponse.getMapaErrores() != null) {
				if (eventosRelResponse.getMapaErrores().containsKey("0")) {
					logger.info("Peticion procesada correctamente");
				} else {
					logger.error("Error en la llamada al servicio: ");
					for (Map.Entry<String,String> entry : eventosRelResponse.getMapaErrores().entrySet()) {
						logger.error("- Error " + entry.getKey() + ": " + entry.getValue());
					}
				}
			} else {
				if (eventosRelResponse.getListadoEventos() != null && !eventosRelResponse.getListadoEventos().getEvento().isEmpty()) {
					logger.info("El suministro tiene eventos " + eventosRelResponse.getListadoEventos().getEvento().size() + " relacionados");
					datosWS.put(ConstantesTibcoWS.SIEME009_RESPONSE_LIST_NAME, eventosRelResponse.getListadoEventos());
				}
			}
		} else {
			logger.error("El servicio ha devuelto una respuesta vacia");
		}
		logger.info("<<<<<------ Llamada al servicio de consulta de eventos relacionados con un suministro completa <<<<<------");
		
		logger.debug("--- Fin -- getDatosSuministroWS ---");
		return datosWS;
	}
}