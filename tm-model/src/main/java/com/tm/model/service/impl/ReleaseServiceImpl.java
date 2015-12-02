package com.tm.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tm.core.entity_sql.TmRelease;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db_sql.ReleaseDao;
import com.tm.dao.db_sql.UserDao;
import com.tm.model.bean.ui.ReleaseBean;
import com.tm.model.service.ReleaseService;
import com.tm.util.assembler.impl.DtoAssemblerFacadeImpl;
import com.tm.util.exceptions.DtoConversionException;

public class ReleaseServiceImpl extends DtoAssemblerFacadeImpl<TmRelease, ReleaseBean> implements ReleaseService {

	@Override
	public List<ReleaseBean> getReleasesByModule(long moduleId) throws DtoConversionException {
		ReleaseDao releaseDao = (ReleaseDao) DaoFactory.generateDao(DaoType.RELEASE);
		UserDao userDao = (UserDao) DaoFactory.generateDao(DaoType.USER);
		List<TmRelease> releaseEntityList = releaseDao.byModuleId(moduleId);
		List<ReleaseBean> releaseBeanList = new ArrayList<ReleaseBean>();
		for(TmRelease releaseEntity : releaseEntityList) {
			ReleaseBean releaseBean = toBean(releaseEntity);
			releaseBean.setUserIdString(userDao.findByPk(releaseBean.getUserId()).getUserId());
			releaseBeanList.add(releaseBean);
		}
		return releaseBeanList;
	}

	@Override
	public ReleaseBean addReleaseToModule(ReleaseBean releaseBean) throws DtoConversionException {
		ReleaseDao releaseDao = (ReleaseDao) DaoFactory.generateDao(DaoType.RELEASE);
		UserDao userDao = (UserDao) DaoFactory.generateDao(DaoType.USER);
		TmRelease releaseEntity = toEntity(releaseBean);
		releaseEntity = releaseDao.persist(releaseEntity, true);
		releaseBean = toBean(releaseEntity);
		releaseBean.setUserIdString(userDao.findByPk(releaseBean.getUserId()).getUserId());
		return releaseBean;
	}
}
