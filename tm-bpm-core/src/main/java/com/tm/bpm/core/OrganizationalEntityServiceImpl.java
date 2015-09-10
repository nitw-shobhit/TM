package com.tm.bpm.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class OrganizationalEntityServiceImpl implements OrganizationalEntityService {

	private static EntityManager em = Persistence.createEntityManagerFactory("tm-bpm").createEntityManager();
	
	@Override
	public void persist(String id, String type) {
		CustomOrganizationalentity orgEntity = new CustomOrganizationalentity();
		orgEntity.setId(id);
		orgEntity.setDtype(type);
		EntityTransaction etx = em.getTransaction();
		try {
			etx.begin();
			em.persist(orgEntity);
			etx.commit();
		} catch(Exception e) {
			etx.rollback();
			throw e;
		}
	}
}
