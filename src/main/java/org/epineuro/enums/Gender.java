package org.epineuro.enums;

public enum Gender {
	
	MASCULINO(1, "Masculino"),
	FEMININO(2, "Feminino"),
	NAODECLARADO(3, "Não declarado");
	
	private int cod;
	private String descricao;
	
	private Gender(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Gender toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (Gender x : Gender.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id invalido" + cod);
	}
	
}
