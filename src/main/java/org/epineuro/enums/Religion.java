package org.epineuro.enums;

public enum Religion {
	
	CATOLICA(0, "Católica"),
	EVANGELICA(1, "Evangélica"),
	AUSENTE(2, "Sem religião"),
	ESPIRITA(3, "Espírita"),
	AFRO_BRASILEIRAS(4, "Religiões afro-brasileiras"),
	ATEU(5, "Ateu"),
	JUDAICA(6, "Judaica"),
	OUTRA(7, "Outra religião não citada");
	
	private int cod;
	private String descricao;
	
	private Religion(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Religion toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (Religion x : Religion.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id invalido" + cod);
	}
	
}
