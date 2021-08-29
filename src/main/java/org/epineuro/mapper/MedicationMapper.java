package org.epineuro.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.epineuro.dto.MedicationDTO;
import org.epineuro.model.Medication;
import org.epineuro.request.MedicationRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicationMapper {
	
    @Autowired
	private ModelMapper modelMapper;
	
	public MedicationDTO modelToDTO(Medication medication) {
		return modelMapper.map(medication, MedicationDTO.class);
	}

	public Medication dtoRequestToModel(MedicationRequest medicationRequest) {
		return modelMapper.map(medicationRequest, Medication.class);
	}
	
	public Set<Medication> medicationRequestToModel(Set<MedicationRequest> dR) {
		
		return dR.stream()
				.map(dis -> modelMapper.map(dis, Medication.class))
				.collect(Collectors.toSet());		
	}

	
	public Set<MedicationDTO> medicationToDTO(Set<Medication> dM) {
		return dM.stream()
				.map(dis -> modelMapper.map(dis, MedicationDTO.class))
				.collect(Collectors.toSet());
	}
}
