# Desafio Inmetrics

## Descrição:

Este é um projeto Maven, escrito em linguagem de programação Java, com os frameworks Selenium WebDriver, Cucumber e JUnit.

Foram automatizados testes para todos as funcionalidades propostas no documento, sendo elas:
</br></br>
<b>Website:</b>
<ul>
    <li>
        1. Cadastrar usuário
    </li>
    <li>
        2. Login
    </li>
    <li>
        3. Funcionário (Cadastrar / Editar / excluir)
    </li>
</ul>
</br>
<b>Webservice:</b> 
<ul>
    <li>
        1. Cadastrar usuário (POST) – Empregado Controller
    </li>
    <li>
        2. Listar usuário cadastrados (GET) – Empregado Controller
    </li>
    <li>
        3. Listar todos usuários (GET) – Empregado Controller
    </li>
    <li>
        4. Alterar usuário (PUT) – Empregado Controller
    </li>
</ul>

<b>Observação</b>: dois testes estão quebrados por não cumprirem o comportamento ideal de fluxo de resposta (análise pessoal). Um deles tem a ver com o tamanho do campo de salário que não foi limitado no front, de forma que é passado um número gigante e quebra. O outro é que o endpoint de alterar funcionário, quando passa o id de empregado 0, insere um novo registro. Neste caso, por não saber a regra de negócio exatamente, é retornada falha no teste.

## Padrão de projeto:

Aplicação do conceito de Page Object.

## Pré-requisitos para execução:

Devem estar instalados na máquina:
<ul>
    <li>Maven 3.6.3</li>
    <li>Navegador Google Chorme Versão 86.0.4240.111 (Versão oficial) 64 bits</li>
    <li>Navegador Firefox Browser 82.0 (64-bits)</li>
</ul>

## Execução:

Em um console, executar a seguinte linha de comando: <br/>

> mvn test

</br>

## Relatórios:

Ao fim do processo de build, será criado um diretório de reports na pasta raiz do projeto, onde dentro estarão incluídos os arquivos de relatório sobre a execução dos testes, sendo eles test-report-api.html (testes de Webservice) e test-report-ui.html (testes de interface). </br>

## Jenkins:

No arquivo jenkins-evidencias.rar estão alguns prints mostrando a configuração e o console de saída do projeto no Jenkins. No print onde são apresentados os resultados, vê-se erros de sessão relacionados ao driver do Chrome, mas isso aconteceu pois a janela do navegador foi fechada antes de o teste ser finalizado.
