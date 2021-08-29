package org.epineuro.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.epineuro.dto.ExamDTO;
import org.epineuro.model.Exam;
import org.epineuro.request.ExamRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExamMapper {
    @Autowired
	private ModelMapper modelMapper;
	
	public ExamDTO modelToDTO(Exam exam) {
		return modelMapper.map(exam, ExamDTO.class);
	}

	public Exam dtoRequestToModel(ExamRequest examRequest) {
		return modelMapper.map(examRequest, Exam.class);
	}
	
	public Set<Exam> examRequestToModel(Set<ExamRequest> dR) {
		
		return dR.stream()
				.map(dis -> modelMapper.map(dis, Exam.class))
				.collect(Collectors.toSet());		
	}

	
	public Set<ExamDTO> examToDTO(Set<Exam> dM) {
		return dM.stream()
				.map(dis -> modelMapper.map(dis, ExamDTO.class))
				.collect(Collectors.toSet());
	}
}
