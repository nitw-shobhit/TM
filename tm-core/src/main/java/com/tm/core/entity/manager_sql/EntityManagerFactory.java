package com.tm.core.entity.manager_sql;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerFactory {

	private EntityManagerFactory() {
	}
	
	static class EmHelper {
		public static EntityManager em = Persistence.createEntityManagerFactory("tm-core").createEntityManager();
	}
	
	public static EntityManager createEntityManager() {
		return EmHelper.em;
	}
}
