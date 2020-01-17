package com.swapkart.model;

import java.util.List;

public class QueryBean {
	
@Override
	public String toString() {
		return "QueryBean [operator=" + operator + ", columnName=" + columnName + ", dataType=" + dataType
				+ ", stringColumnValue=" + stringColumnValue + ", intColumnValue=" + intColumnValue
				+ ", listStringColumnValue=" + listStringColumnValue + ", listntColumnValue=" + listntColumnValue + "]";
	}
	//	
//	
//	public QueryBean(String operator, String columnName, String dataType, String stringColumnValue, int intColumnValue,
//			List<String> listStringColumnValue, List<Integer> listntColumnValue) {
//		super();
//		this.operator = operator;
//		this.columnName = columnName;
//		this.dataType = dataType;
//		this.stringColumnValue = stringColumnValue;
//		this.intColumnValue = intColumnValue;
//		this.listStringColumnValue = listStringColumnValue;
//		this.listntColumnValue = listntColumnValue;
//	}
	private String operator;
	private String columnName;
	private String dataType;
	private String stringColumnValue;
	private int intColumnValue;
	private List<String> listStringColumnValue;
	private List<Integer> listntColumnValue;
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getStringColumnValue() {
		return stringColumnValue;
	}
	public void setStringColumnValue(String stringColumnValue) {
		this.stringColumnValue = stringColumnValue;
	}
	public int getIntColumnValue() {
		return intColumnValue;
	}
	public void setIntColumnValue(int intColumnValue) {
		this.intColumnValue = intColumnValue;
	}
	public List<String> getListStringColumnValue() {
		return listStringColumnValue;
	}
	public void setListStringColumnValue(List<String> listStringColumnValue) {
		this.listStringColumnValue = listStringColumnValue;
	}
	public List<Integer> getListntColumnValue() {
		return listntColumnValue;
	}
	public void setListntColumnValue(List<Integer> listntColumnValue) {
		this.listntColumnValue = listntColumnValue;
	}
	
	
	

}
