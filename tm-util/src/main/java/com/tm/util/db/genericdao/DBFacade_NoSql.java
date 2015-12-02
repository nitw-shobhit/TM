package com.tm.util.db.genericdao;

import java.util.List;

import com.tm.util.db.Param;

public interface DBFacade_NoSql<T> {

	void persist(T obj);
	
	List<T> find(Param param);
	
	List<T> findAll();
}
