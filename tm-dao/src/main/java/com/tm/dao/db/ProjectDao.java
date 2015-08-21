package com.tm.dao.db;

import java.util.List;

import com.tm.core.entity.TmProject;
import com.tm.util.db.DBFacade;

public interface ProjectDao extends DBFacade<TmProject, Long>{

	List<TmProject> getProjectsByUserId(Long id);
}
