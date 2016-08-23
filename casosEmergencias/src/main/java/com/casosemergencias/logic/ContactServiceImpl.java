package com.casosemergencias.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.CaseDAO;
import com.casosemergencias.dao.ContactDAO;
import com.casosemergencias.dao.RelacionActivoContactoDAO;
import com.casosemergencias.dao.vo.CaseVO;
import com.casosemergencias.dao.vo.ContactVO;
import com.casosemergencias.dao.vo.RelacionActivoContactoVO;
import com.casosemergencias.dao.vo.SuministroVO;
import com.casosemergencias.model.Caso;
import com.casosemergencias.model.Contacto;
import com.casosemergencias.model.Suministro;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.datatables.DataTableProperties;


//las transacciones se abren y cierran aqui
public class ContactServiceImpl implements ContactService{
	
	final static Logger logger = Logger.getLogger(ContactService.class);
	
	@Autowired
	private ContactDAO contactDao;
	
	@Autowired
	private RelacionActivoContactoDAO relacionDAO;
	
	@Autowired
	private CaseDAO casoDAO;
		
	/**
	 * Metodo que devuelve una lista de todos los contactos a mostrar en la tabla de nuestra app.
	 * @return listofallcontacts
	 */
	@Override
	public List<Contacto> listOfContactsTable() {
		
		List<Contacto> listOfContactsTable= new ArrayList<Contacto>();
		List<ContactVO> listOfAllContacts =new ArrayList<ContactVO>();
		listOfAllContacts=contactDao.readAllContact();
		Contacto contacto= null;
		
		
		for(ContactVO con:listOfAllContacts){
			
			contacto = new Contacto();
			
			ParserModelVO.parseDataModelVO(con, contacto);
		
			listOfContactsTable.add(contacto);
					
		}		
		return listOfContactsTable;		
	}
	
	@Override
	public Contacto readContactoBySfid(String sfid){
		Contacto returnContacto = new Contacto();
		ContactVO contactoVO = contactDao.readContactBySfid(sfid);
		
		if (contactoVO != null){
			ParserModelVO.parseDataModelVO(contactoVO, returnContacto);
		}
		
		List<RelacionActivoContactoVO> listaRelacionVO = relacionDAO.getSuministrosRelacionesPorContacto(sfid);
		List<Suministro> listaSuministro = parseaListaSuministros(listaRelacionVO);
		returnContacto.setSuministros(listaSuministro);
		
		List<CaseVO> listacasosVO = casoDAO.readCaseOfContact(sfid);
		List<Caso> casoRelacionado = parseaListaCasos(listacasosVO);
		returnContacto.setCasos(casoRelacionado);
		
		return returnContacto;
	}

	@Override
	public List<Contacto> readAllContactos(DataTableProperties propDatatable) {
		logger.debug("--- Inicio -- readAllContactos ---");
		List<Contacto> listContactos = new ArrayList<Contacto>();

		List<ContactVO> listContactosVO = contactDao.readContactosDataTable(propDatatable);
		logger.debug("--- Inicio -- readAllContactos cantidad: " + listContactosVO.size() + " ---");

		for (ContactVO contactoVO : listContactosVO) {
			Contacto contacto = new Contacto();
			ParserModelVO.parseDataModelVO(contactoVO, contacto);
			listContactos.add(contacto);
		}

		logger.debug("--- Fin -- readAllContactos ---:" + listContactos.size());
		return listContactos;
	}

	@Override
	public Integer getNumContactos(DataTableProperties propDatatable) {
		return contactDao.countContactos(propDatatable);
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

	private List<Suministro> parseaListaSuministros(List<RelacionActivoContactoVO> listaRelacionVO) {
		if(listaRelacionVO!=null && !listaRelacionVO.isEmpty()){
			List<Suministro> retorno = new ArrayList<Suministro>();
			for(RelacionActivoContactoVO relacion: listaRelacionVO){
				if(relacion.getActivo()!=null && relacion.getActivo().getSuministroJoin()!=null){
					SuministroVO sumConRelacion = relacion.getActivo().getSuministroJoin();
					Suministro sumRelacionado = new Suministro();
					ParserModelVO.parseDataModelVO(sumConRelacion, sumRelacionado);
					if(relacion.getTipoRelacionActivo()!=null)
						sumRelacionado.setRelacionActivo(relacion.getTipoRelacionActivo().getValor());
					retorno.add(sumRelacionado);
				}
			}
			
			return retorno;
		}
		return null;
	}
}