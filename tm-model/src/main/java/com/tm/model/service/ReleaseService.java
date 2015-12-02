package com.tm.model.service;

import java.util.List;

import com.tm.core.entity_sql.TmRelease;
import com.tm.model.bean.ui.ReleaseBean;
import com.tm.util.assembler.DtoAssemblerFacade;
import com.tm.util.exceptions.DtoConversionException;

public interface ReleaseService extends DtoAssemblerFacade<TmRelease, ReleaseBean> {

	List<ReleaseBean> getReleasesByModule(long moduleId) throws DtoConversionException;

	ReleaseBean addReleaseToModule(ReleaseBean releaseBean) throws DtoConversionException;
}
