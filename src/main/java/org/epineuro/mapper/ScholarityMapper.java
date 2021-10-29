package org.epineuro.mapper;


import org.epineuro.dto.ScholarityDTO;
import org.epineuro.model.Scholarity;
import org.epineuro.request.ScholarityRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScholarityMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ScholarityDTO modelToDTO(Scholarity Scholarity) {
		if (Scholarity != null) {
			return modelMapper.map(Scholarity, ScholarityDTO.class);

		}

		return null;
	}

	public Scholarity dtoRequestToModel(ScholarityRequest ScholarityRequest) {

		if (ScholarityRequest != null) {
			return modelMapper.map(ScholarityRequest, Scholarity.class);

		}

		return null;
	}
	
}
