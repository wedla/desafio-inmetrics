package br.com.inmetrics.utils;

public enum Sexo {
	FEMININO("Feminino"),
	MASCULINO("Masculino"),
	INDIFERENTE("Indiferente");
	
	private String nome;

    private Sexo(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

}
