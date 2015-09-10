package com.tm.util.assembler.impl;

import java.lang.reflect.ParameterizedType;

import com.inspiresoftware.lib.dto.geda.assembler.DTOAssembler;
import com.tm.util.assembler.DtoAssemblerFacade;
import com.tm.util.exceptions.DtoConversionException;

public class DtoAssemblerFacadeImpl<E, B> implements DtoAssemblerFacade<E, B> {

	@Override
	public B toBean(E entity) throws DtoConversionException {
		Class<B> classB = getBeanClass();
		B bean;
		try {
			bean = classB.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new DtoConversionException("Conversion failure", e);
		}
		DTOAssembler.newAssembler(classB, getEntityClass()).assembleDto(bean, entity, null, null);
		return bean;
	}

	@Override
	public E toEntity(B bean) throws DtoConversionException {
		Class<E> classE = getEntityClass();
		E entity;
		try {
			entity = classE.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new DtoConversionException("Conversion failure", e);
		}
		DTOAssembler.newAssembler(getBeanClass(), classE).assembleEntity(bean, entity, null, null);
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	private Class<E> getEntityClass() {
		 ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
	     return (Class<E>) genericSuperclass.getActualTypeArguments()[0];
	}
	
	@SuppressWarnings("unchecked")
	private Class<B> getBeanClass() {
		 ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
	     return (Class<B>) genericSuperclass.getActualTypeArguments()[1];
	}
}
