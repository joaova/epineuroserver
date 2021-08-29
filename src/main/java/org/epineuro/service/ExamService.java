package org.epineuro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.epineuro.dto.ExamDTO;
import org.epineuro.mapper.ExamMapper;
import org.epineuro.model.Exam;
import org.epineuro.repository.ExamRepository;
import org.epineuro.request.ExamRequest;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ExamService {

    @Autowired
	private ExamRepository repository;
	
	@Autowired
	private ExamMapper mapper;
	
	public List<ExamDTO> listar() {
		List<Exam> exams = repository.findAll();
		return exams.stream()
					  .map(p -> mapper.modelToDTO(p))
					  .collect(Collectors.toList());
	}
	
	public ExamDTO buscar(Long id) {
		
		Optional<Exam> exam = repository.findById(id);
				
		if(exam.isPresent()) {
			return mapper.modelToDTO(exam.get());
		}
		
		return null;	
	}
	

	@Transactional
	public ExamDTO salvar(ExamRequest request) {
		Exam e = mapper.dtoRequestToModel(request);
		return mapper.modelToDTO(repository.save(e));
	}
	
	@Transactional
	public void atualizar(Exam obj) {
		repository.save(obj);
	}
    
}
