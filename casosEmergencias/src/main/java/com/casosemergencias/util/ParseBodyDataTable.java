package com.casosemergencias.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class ParseBodyDataTable {
	
	final static Logger logger = Logger.getLogger(ParseBodyDataTable.class);
	
	/**
	 * Metodo que transforma el body en un DataTableProperties, clase que contiene propiedades de los DataTables 
	 * 
	 * @param body -- body recuperado del DataTable con el formato "prop1=valor&prop2=valor&prop3=valor"
	 * @return
	 */
	public static DataTableProperties parseBodyToDataTable(String body){
		//body tiene formato propiedad=valor&propiedad=valor
		
		try {
			body = URLDecoder.decode(body, "UTF-8");

			DataTableProperties dataTable = new DataTableProperties();
			
			String[] firstPartition = body.split("&");
			Map<String,String> mapProperties = new HashMap<>();
			for(String data : firstPartition){
				String[] secondPartition = data.split("=");
				if(secondPartition.length==1){
					//la propiedad no tiene valor
					mapProperties.put(secondPartition[0], "");
				}else{
					//la propiedad tiene clave y valor
					mapProperties.put(secondPartition[0], secondPartition[1]);
				}
				
			}
			
			//Montamos el objeto con las propiedades del datatable
			Integer numColOrder = Integer.parseInt(mapProperties.get("order[0][column]"));
			String nameColumn = "columns[" + numColOrder+ "][data]"; //variable para recuperar el nombre de la columna, es de la forma 'columns[0][data]'
			
			dataTable.setStart(Integer.parseInt(mapProperties.get("start")));
			dataTable.setDraw(Integer.parseInt(mapProperties.get("draw")));
			dataTable.setLength(Integer.parseInt(mapProperties.get("length")));
			dataTable.setOrderColumnNumber(numColOrder);
			dataTable.setOrderDirec(mapProperties.get("order[0][dir]"));
			dataTable.setOrderColumnName(mapProperties.get(nameColumn));
			
			return dataTable;
			
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			return null;
		}
		
		
	}
}
