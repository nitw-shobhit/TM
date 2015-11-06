package com.tm.dao.db;

import java.util.List;

import com.tm.core.entity.TmRelease;
import com.tm.util.db.genericdao.DBFacade;

public interface ReleaseDao extends DBFacade<TmRelease, Long>{

	List<TmRelease> byModuleId(long moduleId);
}
