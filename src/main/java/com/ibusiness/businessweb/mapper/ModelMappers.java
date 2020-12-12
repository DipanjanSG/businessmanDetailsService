package com.ibusiness.businessweb.mapper;

import org.modelmapper.ModelMapper;

import com.ibusiness.businessweb.dto.BusinessmanAllDetailsDto;
import com.ibusiness.businessweb.dto.BusinessmanDto;
import com.ibusiness.businessweb.entity.BusinessmanAllDetails;
import com.ibusiness.businessweb.entity.BusinessmanEntity;

public class ModelMappers {
	
	static ModelMapper modelMapper = new ModelMapper();
	
	public static BusinessmanDto businessmanToBusinessmanDto(BusinessmanEntity businessmanEntity) {
		return modelMapper.map(businessmanEntity,BusinessmanDto.class);
	}
	public static BusinessmanEntity BusinessmanDtoToBusinessman(BusinessmanDto businessmanDto) {
		return modelMapper.map(businessmanDto,BusinessmanEntity.class);
	}
	
	public static BusinessmanAllDetailsDto businessmanAllDetailsToBusinessmanAllDetailsDto(BusinessmanAllDetails businessmanAllDetails) {
		return modelMapper.map(businessmanAllDetails,BusinessmanAllDetailsDto.class);
	}

}
