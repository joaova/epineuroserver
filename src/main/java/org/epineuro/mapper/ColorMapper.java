package org.epineuro.mapper;

import org.epineuro.dto.ColorDTO;
import org.epineuro.model.Color;
import org.epineuro.request.ColorRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ColorMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ColorDTO modelToDTO(Color Color) {
		return modelMapper.map(Color, ColorDTO.class);
	}

	public Color dtoRequestToModel(ColorRequest ColorRequest) {
		return modelMapper.map(ColorRequest, Color.class);
	}
	
}
