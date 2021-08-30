package org.epineuro.enums;

public enum DiseaseGroup {
	
	HEADACHE(0, "Cefaleia"),
	MOVEMENT_DISORDERS(1, "Distúrbios do movimento"),
	EPILEPSY(2, "Epilepsia"),
	DEMENTIA(3, "Demências"),
	CEREBROVASCULAR_DISEASE(4, "Doenças Cerebrovasculares"),
	NEUROMUSCULAR_DISEASE(5, "Doenças neuromusculares"),
	NEUROINFECTIOUS_DISEASE(6, "Doenças neuroinfecciosas"),
	SPINAL_CORD(7, "Doenças da medula espinal"),
	PNS_AND_MOTOR_NEURON(8, "Doenças do sistema nervoso periférico e do neurônio motor"),
	SLEEP_DISORDERS(9, "Doenças do sono"),
	AUTONOMIC_DISEASE(10, "Distúrbios autonômicos"),
	NEURO_OTOLOGY(11, "Neuro-otologia"),
	MS_AND_INFLAMATORY(12, "Esclerose múltipla e outras doenças inflamatórias"),
	NEURO_ONCOLOGY(13, "Neuro-oncologia");
	
	private int cod;
	private String description;
	
	private DiseaseGroup(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getdescription() {
		return description;
	}
	
	public static DiseaseGroup toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (DiseaseGroup x : DiseaseGroup.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id invalido" + cod);
	}
	
}
