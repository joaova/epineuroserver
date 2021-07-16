package org.epineuro.enums;

public enum DiseaseGroup {
	
	HEADACHE(0, "Cefaleia"),
	MOVEMENT_DISORDERS(1, "Distúrbios do movimento"),
	EPILEPSY(2, "Epilepsia"),
	DEMENTIA(3, "Demências"),
	CEREBROVASCULAR_DISEASE(4, "Doenças Cerebrovasculares"),
	NEUROMUSCULAR_DISEASE(5, "Doenças neuromusculares");
	
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
