package org.epineuro.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MedicationRequest {
	private Long id;
	private String name;
	private String dailyDosage;
}
 