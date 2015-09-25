package com.tm.util.db;

import java.util.List;
import java.util.Set;

public interface DBFacade<T, PK> {

	T persist(T obj, boolean baseFlag);
	
	T persistNoTx(T obj, boolean baseFlag);
	
	T merge(T obj, boolean baseFlag);
	
	T mergeNoTx(T obj, boolean baseFlag);
	
	void remove(T obj);
	
	void removeNoTx(T obj);
	
	T findByPk(PK obj);
	
	List<T> findAll();
	
	List<T> findByParams(String query, Param[] param);
	
	int executeNamedQuery(String query, Param[] param);
	
	void executeMultipleNamedQueries(Set<MultipleQueryBean> queries);
}
