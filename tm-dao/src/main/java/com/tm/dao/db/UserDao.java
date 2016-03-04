package com.tm.dao.db;

import com.tm.core.entity.TmUserInfo;
import com.tm.util.db.genericdao.DBFacade_Sql;

public interface UserDao extends DBFacade_Sql<TmUserInfo, Long>{

	TmUserInfo byUserId(String userId);
}
