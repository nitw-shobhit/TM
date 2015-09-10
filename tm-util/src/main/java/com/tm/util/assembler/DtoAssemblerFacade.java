package com.tm.util.assembler;

import com.tm.util.exceptions.DtoConversionException;

public interface DtoAssemblerFacade<E, B> {

	B toBean(E entity) throws DtoConversionException;
	
	E toEntity(B bean) throws DtoConversionException;
}
