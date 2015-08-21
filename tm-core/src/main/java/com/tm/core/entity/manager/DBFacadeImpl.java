package com.tm.core.entity.manager;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.tm.util.db.DBFacade;
import com.tm.util.db.MultipleQueryBean;
import com.tm.util.db.Param;

public class DBFacadeImpl<T, PK> implements DBFacade<T, PK> {

	protected Class<T> entityClass;
	
	@Override
	public T persist(T obj) {
		EntityTransaction etx = getEntityManager().getTransaction();
		try {
			etx.begin();
			getEntityManager().persist(obj);
			etx.commit();
		} catch(Exception e) {
			etx.rollback();
			throw e;
		}
		return obj;
	}

	@Override
	public T merge(T obj) {
		EntityTransaction etx = getEntityManager().getTransaction();
		T objRet = null;
		try {
			etx.begin();
			objRet = getEntityManager().merge(obj);
			etx.commit();
		} catch(Exception e) {
			etx.rollback();
			throw e;
		}
		return objRet;
	}

	@Override
	public void remove(T obj) {
		getEntityManager().remove(obj);
	}
	
	@Override
	public void removeByPk(PK obj) {
		remove(findByPk(obj));
	}
	
	@Override
	public T findByPk(PK obj) {
		return getEntityManager().find(getGenericClass(), obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(String query) {
		Query namedQuery = getEntityManager().createNamedQuery(query);
		return namedQuery.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByParams(String query, Param[] params) {
		Query namedQuery = getEntityManager().createNamedQuery(query);
		for(Param param : params) {
			namedQuery.setParameter(param.getName(), param.getValue());
		}
		return namedQuery.getResultList();
	}
	
	@Override
	public int executeNamedQuery(String query, Param[] params) {
		int result = 0;
		EntityTransaction etx = getEntityManager().getTransaction();
		try {
			etx.begin();
			result = executeQuery(query, params);
			etx.commit();
		} catch(Exception e) {
			etx.rollback();
			throw e;
		}
		return result;
	}
	
	private int executeQuery(String query, Param[] params) {
		Query namedQuery = getEntityManager().createNamedQuery(query);
		for(Param param : params) {
			namedQuery.setParameter(param.getName(), param.getValue());
		}
		return namedQuery.executeUpdate();		
	}

	@Override
	public void executeMultipleNamedQueries(Set<MultipleQueryBean> queries) {
		EntityTransaction etx = getEntityManager().getTransaction();
		try {
			etx.begin();
			for(MultipleQueryBean entry : queries) {
				executeQuery(entry.getQuery(), entry.getParams());
			}
			etx.commit();
		} catch(Exception e) {
			etx.rollback();
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	private Class<T> getGenericClass() {
		 ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
	     return (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}
	
	protected EntityManager getEntityManager() {
		EntityManager em = EntityManagerFactory.createEntityManager();
		return em;
	}
}
