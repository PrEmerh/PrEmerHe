package com.casosemergencias.util.datatables;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedList;
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
	public static DataTableProperties parseBodyToDataTable(String body) {
		//body tiene formato propiedad=valor&propiedad=valor
		try {
			body = URLDecoder.decode(body, "UTF-8");
			DataTableProperties dataTable = new DataTableProperties();
			Map<String, String> mapProperties = mapDataTableProperties(body);
			
			//Montamos el objeto con las propiedades del datatable
			Integer numColOrder = Integer.parseInt(mapProperties.get("order[0][column]"));
			String nameColumn = "columns[" + numColOrder+ "][data]"; //variable para recuperar el nombre de la columna, es de la forma 'columns[0][data]'			
			
			dataTable.setStart(Integer.parseInt(mapProperties.get("start")));
			dataTable.setDraw(Integer.parseInt(mapProperties.get("draw")));
			dataTable.setLength(Integer.parseInt(mapProperties.get("length")));
			dataTable.setOrderColumnNumber(numColOrder);
			dataTable.setOrderDirec(mapProperties.get("order[0][dir]"));
			dataTable.setOrderColumnName(mapProperties.get(nameColumn));
			dataTable.setValueSearch(mapProperties.get("search[value]"));
			dataTable.setAllColumnSearch(Boolean.parseBoolean(mapProperties.get("search[regex]"))); //Por defecto viene a false
			return dataTable;	
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			return null;
		}
	}

	public static DataTableRemappedProperties parseBodyToRemappedDataTable(String body) {
		DataTableRemappedProperties dataTableProperties = new DataTableRemappedProperties();
		try {
			body = URLDecoder.decode(body, "UTF-8");
			Map<String, String> mappedPropertiesFromBody = mapDataTableProperties(body);
			
			dataTableProperties.setStart(Integer.parseInt(mappedPropertiesFromBody.get("start")));
			dataTableProperties.setLength(Integer.parseInt(mappedPropertiesFromBody.get("length")));
			dataTableProperties.setDraw(Integer.parseInt(mappedPropertiesFromBody.get("draw")));
			
			Map<String, Object> genericSearching = new HashMap<String, Object>();
			genericSearching.put("searchValue", mappedPropertiesFromBody.get("search[value]"));
			genericSearching.put("searchRegEx", Boolean.parseBoolean(mappedPropertiesFromBody.get("search[regex]")));
			dataTableProperties.setGenericSearching(genericSearching);
			
			Map<String, Object> tableOrdering = new HashMap<String, Object>();
			Integer orderingColumnNumber = Integer.parseInt(mappedPropertiesFromBody.get("order[0][column]"));
			//variable para recuperar el nombre de la columna, es de la forma 'columns[0][data]'
			String orderingColumnName = mappedPropertiesFromBody.get("columns[" + orderingColumnNumber+ "][data]"); 
			tableOrdering.put("orderingColumnNumber", orderingColumnNumber);
			tableOrdering.put("orderingColumnName", orderingColumnName);
			tableOrdering.put("orderingDirection", mappedPropertiesFromBody.get("order[0][dir]"));
			dataTableProperties.setTableOrdering(tableOrdering);
			
			List<DataTableColumnInfo> columnsInfo = new LinkedList<DataTableColumnInfo>();
			int columnCounter = 0;
			while (mappedPropertiesFromBody.containsKey("columns[" + columnCounter + "][data]")) {
				DataTableColumnInfo columnInfo = new DataTableColumnInfo();
				columnInfo.setColumnOrder(columnCounter);
				columnInfo.setData(mappedPropertiesFromBody.get("columns[" + columnCounter + "][data]"));
				columnInfo.setName(mappedPropertiesFromBody.get("columns[" + columnCounter + "][name]"));
				columnInfo.setOrderable(Boolean.parseBoolean(mappedPropertiesFromBody.get("columns[" + columnCounter + "][orderable]")));
				columnInfo.setSearchable(Boolean.parseBoolean(mappedPropertiesFromBody.get("columns[" + columnCounter + "][searchable]")));
				columnInfo.setSearchValue(mappedPropertiesFromBody.get("columns[" + columnCounter + "][search][value]"));
				columnInfo.setSearchRegEx(Boolean.parseBoolean(mappedPropertiesFromBody.get("columns[" + columnCounter + "][search][regex]")));
				columnsInfo.add(columnInfo);
				columnCounter++;
			}
			dataTableProperties.setColumsInfo(columnsInfo);
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			return null;
		}
		
		return dataTableProperties;
	}
	
	/**
	 * @param body
	 * @return
	 */
	private static Map<String, String> mapDataTableProperties(String body) {
		String[] firstPartition = body.split("&");
		Map<String, String> mapProperties = new HashMap<>();
		for (String data : firstPartition) {
			String[] secondPartition = data.split("=");
			if (secondPartition.length == 1) {
				//la propiedad no tiene valor
				mapProperties.put(secondPartition[0], "");
			} else {
				//la propiedad tiene clave y valor
				mapProperties.put(secondPartition[0], secondPartition[1]);
			}
		}
		return mapProperties;
	}
}