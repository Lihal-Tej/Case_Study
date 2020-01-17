package com.swapkart.dao;

import java.util.HashMap;
import java.util.List;

import com.swapkart.model.QueryBean;

public class QueryBuilder {
	
	
	HashMap<String, String[]> hashMap;
	
//	public QueryBuilder(HashMap<String, String[]> hashMap) {
//		
//		this.hashMap = hashMap;
//		
//	}
	
	public String queryGenerator() {
		
		String sql = "";
		
		try {
			for (String key : hashMap.keySet()) {
				
				  
				 if(key.equals("product_price") ) {
					 sql = sql +"("+ key+ " > "+hashMap.get(key)[0] +" and "+key + " < "+hashMap.get(key)[1] +" )  and  ";
				 }
				 if(key.equals("product_rating") ) {
					 sql = sql +" ( "+ key+ " >= "+hashMap.get(key)[0]  +" )  and  ";
				 }
				 if(!(key.equals("product_price")) ) {
					 if(!(key.equals("product_rating"))) {
						 sql = sql +  key + " In (";
					 for(int i=0;i<hashMap.get(key).length;i++) {
						
						 sql = sql +"'"+ hashMap.get(key)[i].toString() +"',";
						
					  } 
					 sql = sql.substring(0,sql.length()-1) + " ) and   ";
					 }
				 }
				  
				  
			}
			
			System.out.println(sql);
			sql = sql.substring(0, sql.length() - 6)+";";
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return sql;
		
	}
	
	
	
	public String queryGen(List<QueryBean> queryBeans) {
		
		String sql = "";
		try {
			
			for(int p=0;p<queryBeans.size();p++) {
				
			QueryBean queryBean = queryBeans.get(p);
			
			String operator = queryBean.getOperator();
			String dataType = queryBean.getDataType();
			if(operator.equals("In")) {
				if(dataType.equals("String")) {
				sql = sql + " "+queryBean.getColumnName() +" In ('";
				for(int i=0;i<queryBean.getListStringColumnValue().size();i++) {
					sql = sql+queryBean.getListStringColumnValue().get(i) +"' ,'";
				}
				
				sql = sql.substring(0, sql.length()-2) + " ) and ";
				}
				
				if(dataType.equals("int")) {
					sql = sql + queryBean.getColumnName() +" In (";
					for(int i=0;i<queryBean.getListntColumnValue().size();i++) {
						sql =sql+ queryBean.getListntColumnValue().get(i)+"  , ";
					}
					sql = sql.substring(0, sql.length()-2) + " ) and ";
				}
				
			
			}else if(operator.equals(">=")) {
				
				sql = sql + queryBean.getColumnName()+ " >= "+queryBean.getIntColumnValue() + " and ";
				
			}else if(operator.equals("<=")) {
				
				sql = sql + queryBean.getColumnName()+ " <= "+queryBean.getIntColumnValue() + " and ";
			}else if(operator.equals("like")) {
				
				sql = sql + queryBean.getColumnName()+ " like '"+queryBean.getStringColumnValue() + "%' and  ";
			}
			
			
		
			
			}
			
			System.out.println(sql);
			
			sql = sql.substring(0, sql.length()-4);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return sql;
		
	}
	

}
