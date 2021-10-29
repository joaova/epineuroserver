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
		if(Color != null) {
			return modelMapper.map(Color, ColorDTO.class);
		}

		return null;
		
	}

	public Color dtoRequestToModel(ColorRequest ColorRequest) {
		if (ColorRequest != null) {
			return modelMapper.map(ColorRequest, Color.class);
		}

		return null;
		
	}
	
}
