package com.tm.util.db;

public class MultipleQueryBean {

	private String query;
	private Param[] params;
	
	public MultipleQueryBean(String query, Param[] params) {
		this.query = query;
		this.params = params;
	}
	
	public String getQuery() {
		return query;
	}
	
	public void setQuery(String query) {
		this.query = query;
	}
	
	public Param[] getParams() {
		return params;
	}
	
	public void setParams(Param[] params) {
		this.params = params;
	}
}
