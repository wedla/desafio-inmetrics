package br.com.inmetrics.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.github.javafaker.Faker;

public class Pessoa {
	
	private static Faker faker;
	private static String nome;
	private static String cargo;
	private static String comissao;
	private static String documento;
	private static String salario;
	private static char sexo;
	private static String admissao;
	private static String tipoContratacao;
	
	private static int departamentoId;
	
	public static String generatePessoaJson() {
		generatePessoa();
		
		String jsonRequest =  "{ \"empregadoId\": \"" + Constantes.ID_EMPREGADO_VALIDO + "\", \"admissao\": \""
				+ Pessoa.getAdmissao() + "\", \"cargo\": \"" + Pessoa.getCargo() + "\", " + "\"comissao\": \""
				+ Pessoa.getComissao() + "\", \"cpf\": \"" + Pessoa.getDocumento() + "\", " + "\"departamentoId\": "
				+ Pessoa.getDepartamentoId() + ", \"nome\": \"" + Pessoa.getNome() + "\", " + "\"salario\": \""
				+ Pessoa.getSalario() + "\", \"sexo\": \"" + Pessoa.getSexo() + "\", " + "\"tipoContratacao\": \""
				+ Pessoa.getTipoContratacao() + "\"}";
		
		return jsonRequest;
	}
	
	private static void generatePessoa() { 
		faker = new Faker();
		GeneratorDocumento geradorDocumento = new GeneratorDocumento();
		Date date = new Date();
		
		Pessoa.setNome(faker.name().fullName().replace(".", ""));
		Pessoa.setCargo("Analista de Testes");
		Pessoa.setComissao("1.000,00");
		Pessoa.setDocumento(geradorDocumento.cpf(true));
		Pessoa.setDepartamentoId(1);
		Pessoa.setSalario("4.000,00");
		Pessoa.setSexo(generateRandomSexo());
		Pessoa.setAdmissao(new SimpleDateFormat("dd/MM/yyyy").format(date));
		Pessoa.setTipoContratacao(generateRandomTipoContratacao());
	}
	
	public static char generateRandomSexo() {
		int ramdomN = faker.number().numberBetween(0, 1);
	    
		if (ramdomN == 0) {
	        return 'm';
	    } else {
	        return 'f';
	    }
	}
	
	public static String generateRandomTipoContratacao() {
		int ramdomN = faker.number().numberBetween(0, 1);
	    
		if (ramdomN == 0) {
	        return "clt";
	    } else {
	        return "pj";
	    }
	}

	public static String getNome() {
		return nome;
	}

	public static void setNome(String nome) {
		Pessoa.nome = nome;
	}

	public static String getCargo() {
		return cargo;
	}

	public static void setCargo(String cargo) {
		Pessoa.cargo = cargo;
	}

	public static String getComissao() {
		return comissao;
	}

	public static void setComissao(String comissao) {
		Pessoa.comissao = comissao;
	}

	public static String getDocumento() {
		return documento;
	}

	public static void setDocumento(String documento) {
		Pessoa.documento = documento;
	}

	public static String getSalario() {
		return salario;
	}

	public static void setSalario(String salario) {
		Pessoa.salario = salario;
	}

	public static char getSexo() {
		return sexo;
	}

	public static void setSexo(char sexo) {
		Pessoa.sexo = sexo;
	}

	public static String getAdmissao() {
		return admissao;
	}

	public static void setAdmissao(String admissao) {
		Pessoa.admissao = admissao;
	}

	public static String getTipoContratacao() {
		return tipoContratacao;
	}

	public static void setTipoContratacao(String tipoContratacao) {
		Pessoa.tipoContratacao = tipoContratacao;
	}

	public static int getDepartamentoId() {
		return departamentoId;
	}

	public static void setDepartamentoId(int departamentoId) {
		Pessoa.departamentoId = departamentoId;
	}
}
