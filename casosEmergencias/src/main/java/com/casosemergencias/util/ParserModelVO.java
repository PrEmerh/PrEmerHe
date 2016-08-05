package com.casosemergencias.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.casosemergencias.controller.LoginController;
import com.casosemergencias.dao.SuministroVO;
import com.casosemergencias.model.Suministro;

public class ParserModelVO {
	
	
	final static Logger logger = Logger.getLogger(ParserModelVO.class);
	
	//Metodo que dado dos objetos, se pasa la información de objectWithData y se vuelca en objectToFill
	//Para que funcione se deben llamar igual los campos que queremos informar,
	//es decir, si queremos que se pase la información de name, necesitamos tener un getName y en el objeto que recibe la información el metodo setName
	//LIMITACIÓN: No admite tipos de datos, solo clases. NO se pasará el metodo con parametros de entrada int, boolean...
	public static void parseDataModelVO(Object objectWithData, Object objectToFill){

		Method[] methodsGets = objectWithData.getClass().getMethods();
		Method[] methodsSets = objectToFill.getClass().getMethods();
		Map<String, Method> mapFieldSetMethod = getMapOfSetFields(methodsSets);
		for(Method methodGetData : methodsGets){
			String nameMethodData = methodGetData.getName();
			if(nameMethodData!=null && nameMethodData.startsWith("get")){
				String fieldData = nameMethodData.substring(3);
				if(mapFieldSetMethod.containsKey(fieldData)){
					Method methodSetField = mapFieldSetMethod.get(fieldData);
					try {
						Object valueToSet= methodGetData.invoke(objectWithData);
						methodSetField.invoke(objectToFill, valueToSet);
						
					} catch (IllegalAccessException e) {
						logger.error(e);
					} catch (IllegalArgumentException e) {
						logger.error(e);
					} catch (InvocationTargetException e) {
						logger.error(e);
					}
				}
				
			}
			
		}
	}

	private static Map<String, Method> getMapOfSetFields(Method[] methodsSets) {
		Map<String, Method> mapToReturn = new HashMap<String, Method>();
		for(Method methodSet : methodsSets){
			String nameMethodSet = methodSet.getName();
			if(nameMethodSet!=null && nameMethodSet.startsWith("set")){
				String fieldData = nameMethodSet.substring(3);
				mapToReturn.put(fieldData, methodSet);
			}
			
		}
		return mapToReturn;
	}
	
	public static void main(String[] args){
		SuministroVO suministroVO = new SuministroVO();
		suministroVO.setAlimentador("alimentador---------");
		suministroVO.setId(new Integer(111));
		
		Suministro suministro = new Suministro();
		ParserModelVO.parseDataModelVO(suministroVO, suministro);
		suministro.setBloque("numero2");
		SuministroVO suministro2VO = new SuministroVO();
		ParserModelVO.parseDataModelVO(suministro, suministro2VO);
		
	}

}
