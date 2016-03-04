package com.tm.dao.db;

import java.util.List;

import com.tm.core.entity.TmUserProject;
import com.tm.util.db.genericdao.DBFacade_Sql;

public interface UserProjectDao extends DBFacade_Sql<TmUserProject, Long>{

	List<TmUserProject> byProjectId(long projectId);

}
