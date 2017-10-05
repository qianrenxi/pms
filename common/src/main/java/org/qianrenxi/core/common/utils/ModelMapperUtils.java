package org.qianrenxi.core.common.utils;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class ModelMapperUtils {

	public static final ModelMapper modelMapper = new ModelMapper();
	
	public static <D> D map(Object source, Class<D> destinationType) {
		return modelMapper.map(source, destinationType);
	}
	
	public static <D> D map(Object source, Type destinationType) {
		return modelMapper.map(source, destinationType);
	}
	
	public static <D> Page<D> map(Page<?> source, Type type, Pageable pageable) {
		// Type type = new TypeToken<List<D>>() {}.getType();
		// Type type = TypeToken.of(Class<List<D>>);
		List<D> list = modelMapper.map(source.getContent(), type);
		
		return new PageImpl<D>(list, pageable, source.getTotalElements());
	}
}
