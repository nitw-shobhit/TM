package com.tm.dao.db_sql;

import java.util.List;

import com.tm.core.entity_sql.TmRelease;
import com.tm.util.db.genericdao.DBFacade_Sql;

public interface ReleaseDao extends DBFacade_Sql<TmRelease, Long>{

	List<TmRelease> byModuleId(long moduleId);
}
