package com.casosemergencias.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.casosemergencias.dao.AccountDAO;
import com.casosemergencias.dao.AccountVO;
import com.casosemergencias.dao.DireccionDAO;
import com.casosemergencias.dao.DireccionVO;
import com.casosemergencias.model.Cuenta;
import com.casosemergencias.model.Direccion;
import com.casosemergencias.util.ParserModelVO;


//las transacciones se abren y cierran aqui
public class DireccionServiceImpl implements DireccionService{
	
	final static Logger logger = Logger.getLogger(DireccionService.class);
	
	@Autowired
	private DireccionDAO direccionDao;
		
	/**
	 * Metodo que devuelve una lista de todas las direccions a mostrar en la tabla de nuestra app.
	 * @return listofalldireccions
	 */
	@Override
	public List<Direccion> listOfDireccionesTable() {
		
		List<Direccion> listOfDireccionesTable= new ArrayList<Direccion>();
		List<DireccionVO> listOfAllDirecciones =new ArrayList<DireccionVO>();
		listOfAllDirecciones=direccionDao.readAllDireccion();
		Direccion direccion= null;
		
		
		for(DireccionVO dir:listOfAllDirecciones){
			
			direccion = new Direccion();
			
			ParserModelVO.parseDataModelVO(dir, direccion);
		
			listOfDireccionesTable.add(direccion);
					
		}		
		return listOfDireccionesTable;		
	}




}