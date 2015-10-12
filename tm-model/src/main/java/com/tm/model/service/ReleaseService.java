package com.tm.model.service;

import java.util.List;

import com.tm.core.bean.ReleaseBean;
import com.tm.core.entity.TmRelease;
import com.tm.util.assembler.DtoAssemblerFacade;
import com.tm.util.exceptions.DtoConversionException;

public interface ReleaseService extends DtoAssemblerFacade<TmRelease, ReleaseBean> {

	List<ReleaseBean> getReleasesByModule(long moduleId) throws DtoConversionException;
}
