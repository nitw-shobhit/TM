package com.tm.dao.db;

import java.util.List;

import com.tm.core.entity.TmUserInfo;
import com.tm.util.db.DBFacade;

public interface UserDao extends DBFacade<TmUserInfo, Long>{

	TmUserInfo getUserByUserId(String userId);

	List<TmUserInfo> getUsersByQuery(String query);
}
