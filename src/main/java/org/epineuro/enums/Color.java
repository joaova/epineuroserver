package org.epineuro.enums;

public enum Color {
	
	BRANCA(0, "Branca"),
	PRETA(1, "Preta"),
	PARDA(2, "Parda"),
	AMARELA(3, "Amarela"),
	INDIGENA(4, "Indígena");

	
	private int cod;
	private String descricao;
	
	private Color(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Color toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (Color x : Color.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id invalido" + cod);
	}
	
}
