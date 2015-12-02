package com.tm.core.genericdao.impl_sql;

import java.lang.reflect.ParameterizedType;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.tm.core.entity.manager_sql.EntityManagerFactory;
import com.tm.core.entity_sql.TmBase;
import com.tm.core.query.QueryConstants;
import com.tm.util.db.MultipleQueryBean;
import com.tm.util.db.Param;
import com.tm.util.db.genericdao.DBFacade_Sql;

public class DBFacadeImpl_Sql<T, PK> extends QueryConstants implements DBFacade_Sql<T, PK> {

	@Override
	public T persist(T obj, boolean baseFlag) {
		EntityTransaction etx = getEntityManager().getTransaction();
		try {
			etx.begin();
			obj = persistNoTx(obj, baseFlag);
			etx.commit();
		} catch(Exception e) {
			etx.rollback();
			throw e;
		}
		return obj;
	}
	
	@Override
	public T persistNoTx(T obj, boolean baseFlag) {
		if(baseFlag) {
			((TmBase)obj).setDtCreated(new Timestamp(new Date().getTime()));
			((TmBase)obj).setDtModified(new Timestamp(new Date().getTime()));
			((TmBase)obj).setVisible(true);
		}
		getEntityManager().persist(obj);
		return obj;
	}

	@Override
	public T merge(T obj, boolean baseFlag) {
		EntityTransaction etx = getEntityManager().getTransaction();
		T objRet = null;
		try {
			etx.begin();
			objRet = mergeNoTx(obj, baseFlag);
			etx.commit();
		} catch(Exception e) {
			etx.rollback();
			throw e;
		}
		return objRet;
	}
	
	@Override
	public T mergeNoTx(T obj, boolean baseFlag) {
		if(baseFlag) {
			((TmBase)obj).setDtModified(new Timestamp(new Date().getTime()));
		}
		return getEntityManager().merge(obj);
	}

	@Override
	public void remove(T obj) {
		EntityTransaction etx = getEntityManager().getTransaction();
		try {
			etx.begin();
			getEntityManager().remove(obj);
			etx.commit();
		} catch(Exception e) {
			etx.rollback();
			throw e;
		}
	}
	
	@Override
	public void removeNoTx(T obj) {
		getEntityManager().remove(obj);
	}
	
	@Override
	public T findByPk(PK obj) {
		return getEntityManager().find(getGenericClass(), obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		Query namedQuery = getEntityManager().createQuery("Select a from "+ getGenericClass().getSimpleName() + " a");
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
