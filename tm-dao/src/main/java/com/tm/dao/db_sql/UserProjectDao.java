package com.tm.dao.db_sql;

import java.util.List;

import com.tm.core.entity_sql.TmUserProject;
import com.tm.util.db.genericdao.DBFacade_Sql;

public interface UserProjectDao extends DBFacade_Sql<TmUserProject, Long>{

	List<TmUserProject> byProjectId(long projectId);

}
