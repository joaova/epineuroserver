package org.epineuro.enums;

public enum CivilState {
	
	SOLTEIRO(0, "Solteiro(a)"),
	CASADO(1, "Casado(a)"),
	SEPARADO(2, "Separado(a)"),
	DIVORCIADO(3, "Divorciado(a)"),
	VIUVO(4, "Viúvo(a)");

	private int cod;
	private String descricao;
	
	private CivilState(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static CivilState toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (CivilState x : CivilState.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id invalido" + cod);
	}
	
}
