package com.tm.dao.db;

import com.tm.core.entity.TmUserInfo;
import com.tm.util.db.genericdao.DBFacade;

public interface UserDao extends DBFacade<TmUserInfo, Long>{

	TmUserInfo byUserId(String userId);
}
