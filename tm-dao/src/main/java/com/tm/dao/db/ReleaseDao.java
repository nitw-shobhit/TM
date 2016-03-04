package com.tm.dao.db;

import java.util.List;

import com.tm.core.entity.TmRelease;
import com.tm.util.db.genericdao.DBFacade_Sql;

public interface ReleaseDao extends DBFacade_Sql<TmRelease, Long>{

	List<TmRelease> byModuleId(long moduleId);
}
