package com.tm.util.db;

import java.util.List;
import java.util.Set;

public interface DBFacade<T, PK> {

	T persist(T obj);
	
	T merge(T obj);
	
	void remove(T obj);
	
	T findByPk(PK obj);
	
	List<T> findAll(String query);
	
	List<T> findByParams(String query, Param[] param);
	
	int executeNamedQuery(String query, Param[] param);
	
	void executeMultipleNamedQueries(Set<MultipleQueryBean> queries);
}
