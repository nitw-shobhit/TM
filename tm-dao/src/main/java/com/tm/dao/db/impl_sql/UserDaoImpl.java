package com.tm.dao.db.impl_sql;

import java.util.List;

import com.tm.core.entity_sql.TmUserInfo;
import com.tm.core.genericdao.impl_sql.DBFacadeImpl_Sql;
import com.tm.dao.db_sql.UserDao;
import com.tm.util.db.Param;

public class UserDaoImpl extends DBFacadeImpl_Sql<TmUserInfo, Long> implements UserDao {

	@Override
	public TmUserInfo byUserId(String userId) {
		TmUserInfo userEntity = null;
		Param [] params = new Param[1];
		params[0] = new Param(PARAM_USER_ID, userId);
		List<TmUserInfo> resultList = findByParams(GET_USER_BY_USER_ID, params);
		if(resultList != null && resultList.size() == 1) {
			userEntity = resultList.get(0);
		}
		return userEntity;
	}
}
