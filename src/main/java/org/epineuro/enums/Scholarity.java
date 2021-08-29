package org.epineuro.enums;

public enum Scholarity {
	
	FUNDAMENTAL_INCOMPLETO(0, "Ensino fundamental incompleto"),
	FUNDAMENTAL_COMPLETO(1, "Ensino fundamental completo"),
	MEDIO_INCOMPLETO(2, "Ensino médio incompleto"),
	MEDIO_COMPLETO(3, "Ensino médio completo"),
	TECNICO_INCOMPLETO(4, "Ensino técnico incompleto"),
	TECNICO_COMPLETO(5, "Ensino técnico compelto"),
	SUPERIOR_INCOMPLETO(6, "Ensino superior incompleto"),
	SUPERIOR_COMPLETO(7, "Ensino superior completo"),
	AUSENTE(8, "Ensino ausente");
	
	private int cod;
	private String descricao;
	
	private Scholarity(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Scholarity toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (Scholarity x : Scholarity.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id invalido" + cod);
	}
	
}
