package org.epineuro.enums;

public enum Job {
	
AGRO(0, "Na agricultura, no campo, na fazenda ou na pesca"),
INDUSTRIA(1, "Na indústria"),
CONSTRUCAO_CIVIL(2, "Na construção civil"),
COMERCIO(3, "No comércio, banco, transporte, hotelaria ou outros serviços."),
FUNCIONARIO_PUBLICO(4, "Como funcionário(a) do governo federal, estadual ou municipal."),
PROFISSIONAL_LIBERAL(5, "Como profissional liberal, professora ou técnica de nível superior."),
ATIVIDADES_INFORMAIS(6, "Trabalho fora de casa em atividades informais (pintor, eletricista, encanador, feirante, ambulante, guardador/a de carros, catador/a de lixo)."),
TRABALHO_EM_CASA(7, "Trabalho em minha casa em serviços (costura, aulas particulares, cozinha, artesanato, carpintaria etc)"),
TRABALHO_DOMESTICO(8, "Faço trabalho doméstico em casa de outras pessoas (cozinheiro/a, mordomo/governanta, jardineiro, babá, lavadeira, faxineiro/a, acompanhante de idosos/as etc.)."),
LAR(9, "No lar (sem remuneração)"),
OUTRO(10, "Outro não citado acima"),
DESEMPRAGADO(11, "Desempregado(a)");
	
	private int cod;
	private String descricao;
	
	private Job(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Job toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (Job x : Job.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id invalido" + cod);
	}
	
}
