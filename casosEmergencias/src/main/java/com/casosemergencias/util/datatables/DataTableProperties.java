package com.casosemergencias.util.datatables;

/**
 * @author mcasas
 * 
 *         Clase que guarda propiedades de los DataTables. Estas propiedades se
 *         utilizarán para paginar y para ordenar
 *
 */
public class DataTableProperties {
	private int draw;
	private int start;
	private int length;
	private String orderColumnName;
	private int orderColumnNumber;
	private String orderDirec;
	private String valueSearch;
	private boolean allColumnSearch;

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getOrderColumnName() {
		return orderColumnName;
	}

	public void setOrderColumnName(String orderColumnName) {
		this.orderColumnName = orderColumnName;
	}

	public int getOrderColumnNumber() {
		return orderColumnNumber;
	}

	public void setOrderColumnNumber(int orderColumnNumber) {
		this.orderColumnNumber = orderColumnNumber;
	}

	public String getOrderDirec() {
		return orderDirec;
	}

	public void setOrderDirec(String orderDirec) {
		this.orderDirec = orderDirec;
	}

	public String getValueSearch() {
		return valueSearch;
	}

	public void setValueSearch(String valueSearch) {
		this.valueSearch = valueSearch;
	}

	public boolean isAllColumnSearch() {
		return allColumnSearch;
	}

	public void setAllColumnSearch(boolean allColumnSearch) {
		this.allColumnSearch = allColumnSearch;
	}
}