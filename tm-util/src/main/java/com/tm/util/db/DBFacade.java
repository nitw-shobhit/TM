package com.tm.util.db;

import java.util.List;
import java.util.Set;

public interface DBFacade<T, PK> {

	T persist(T obj);
	
	T persistNoTx(T obj);
	
	T merge(T obj);
	
	T mergeNoTx(T obj);
	
	void remove(T obj);
	
	void removeNoTx(T obj);
	
	T findByPk(PK obj);
	
	List<T> findAll();
	
	List<T> findByParams(String query, Param[] param);
	
	int executeNamedQuery(String query, Param[] param);
	
	void executeMultipleNamedQueries(Set<MultipleQueryBean> queries);
}
