package br.com.inmetrics.utils;

import br.com.inmetrics.teste.support.TipoContratacao;

public class Constantes {
	/* URLs utilizadas */
	public static final String PAGINA_LOGIN = "http://www.inmrobo.tk/accounts/login/";
	public static final String PAGINA_INICIAL = "http://www.inmrobo.tk/empregados/";
	public static final String PAGINA_NOVO_FUNCIONARIO = "http://www.inmrobo.tk/empregados/new_empregado";
	
	public static final String BASE_URL = "https://inm-api-test.herokuapp.com/";
	public static final String AUTENTICACAO_URL = BASE_URL + "acesso/login";
	public static final String POST_FUNCIONARIO = BASE_URL + "empregado/cadastrar";
	public static final String GET_FUNCIONARIO_POR_ID = BASE_URL + "empregado/list/%d";
	public static final String GET_TODOS_OS_FUNCIONARIOS = BASE_URL + "empregado/list_all";
	public static final String PUT_FUNCIONARIO = BASE_URL + "empregado/alterar/%d";
	
	/* Dados de usuários utilizados */
	public static final String TOKEN_API = "aW5tZXRyaWNzOmF1dG9tYWNhbw==";
	public static final String USERNAME_API = "inmetrics";
	public static final String PASSWORD_API = "automacao";
	public static final int ID_EMPREGADO_VALIDO = 5064;
	public static final int ID_EMPREGADO_INVALIDO = 0;
	public static final String USUARIO_PADRAO = "rwedla@inmetrics.com.br";
	public static final String SENHA_PADRAO = "12345678";
	public static final String USUARIO_INVALIDO = "wedla@wedla.com.br";
	public static final String SENHA_INVALIDA = "123456";
	
	/* Mensagens de sucesso e erro */
	public static final String MENSAGEM_ERRO_LOGIN = "ERRO! Usuário ou Senha inválidos";
	public static final String MENSAGEM_ERRO_CADASTRO_USUARIO = "Usuário já cadastrado";
	public static final String MENSAGEM_FALHA_ALTERACAO = "ERRO! Ops.. Não conseguimos atualizar as informações";
	public static final String MENSAGEM_ERRO_400_LIST_FUNCIONARIO_POR_ID = "Empregado não cadastrado";
	
	public static final String MENSAGEM_SUCESSO_CADASTRO = "SUCESSO! Usuário cadastrado com sucesso";
	public static final String MENSAGEM_SUCESSO_ALTERACAO = "SUCESSO! Informações atualizadas com sucesso";
	public static final String MENSAGEM_SUCESSO_REMOCAO = "SUCESSO! Funcionário removido com sucesso";
	
	public static final String CPF_INVALIDO = "111.856.607-62";
	
	public static final String FUNCIONARIO_PADRAO = "Dangelo";
	public static final String CARGO_PADRAO = "Analista de Testes Sênior";
	public static final String SALARIO_PADRAO = "1000000";
	public static final TipoContratacao CONTRATACAO_PADRAO = TipoContratacao.PJ;
	
	public static final String FUNCIONARIO_FAKE = "Fake";
}
