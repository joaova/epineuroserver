package org.epineuro.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ExamRequest {

	private String name;
	private LocalDate examDate;
	
}
 