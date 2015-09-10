package com.tm.dao.db;

import java.util.List;

import com.tm.core.entity.TmIssue;
import com.tm.util.db.DBFacade;

public interface IssueDao extends DBFacade<TmIssue, Long>{

	List<TmIssue> byModuleId(long moduleId);

}
