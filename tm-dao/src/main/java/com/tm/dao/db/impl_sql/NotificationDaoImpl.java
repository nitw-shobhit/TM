package com.tm.dao.db.impl_sql;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.tm.core.entity.TmNotification;
import com.tm.core.entity.TmNotificationVariable;
import com.tm.core.genericdao.impl_sql.DBFacadeImpl_Sql;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db.NotificationDao;
import com.tm.dao.db.NotificationVariableDao;
import com.tm.util.db.Param;
import com.tm.util.exceptions.DaoException;

public class NotificationDaoImpl extends DBFacadeImpl_Sql<TmNotification, Long> implements NotificationDao {

	@Override
	public List<TmNotification> byUserId(long userId) {
		Param [] params = new Param[1];
		params[0] = new Param(PARAM_USER_ID, userId);
		return findByParams(GET_NOTIFICATIONS_BY_USER_ID, params);
	}

	@Override
	public TmNotification addNotification(TmNotification notificationEntity, List<TmNotificationVariable> notificationVariableEntityList)
			throws DaoException {
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			tx.begin();
			persistNoTx(notificationEntity, true);
			
			for(TmNotificationVariable notificationVariableEntity : notificationVariableEntityList) {
				NotificationVariableDao notificationDao = (NotificationVariableDao) DaoFactory.generateDao(DaoType.NOTIFICATION_VARIABLE);
				notificationVariableEntity.setNotId(notificationEntity.getId());
				notificationDao.persistNoTx(notificationVariableEntity, false);
			}
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			throw new DaoException(e);
		}
		return notificationEntity;
	}
}
