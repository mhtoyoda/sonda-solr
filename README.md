# sonda-solr
Projeto Teste Elo7 - SondaSolr by Marcelo Toyoda

Este projeto visa simular comandos enviados para um conjunto de Sondas para explorar a malha do planalto.
Seguindo uma série de instruções de coordenadas e tendo como retorno a posição final das sondas.

Instruções:
- Caso as intruções de movimento ultrapassem o limite superior direito da malha, assumi que a posição final, seja da coordenada x ou y será igual ao limite x e/ou y da malha do planalto.

Passo a passo:
- Inicializar o Apache Solr: bin/solr start

- Executar o comando para criar a coleção sonda: bin/solr create -c sonda

- Executar método main da classe SondaSolrApplication.java para iniciar o Tomcat e popular o Apache Solr com dados em massa.

Orientações:
- Dentro da pasta resources/solr-files, encontram-se versionados os arquivos de configuração para a coleção sonda, criada para o teste para serem substituídos pelos respectivos arquivos originais dentro da pasta sonda/conf.
- Todos os métodos de indexação e busca estão cobertos com testes unitários.
- Contexto da Aplicação: sonda-web
- Porta Tomcat: 8080
- Tela de Indexação -> http://localhost:8080/sonda-web/
- Tela de Consulta de dados Indexados -> http://localhost:8080/sonda-web/search

*Requisitos de sistema:
- Java JDK 1.8
- Spring Boot 1.4.3
- Spring Data Solr
- Maven 3
- Apache Solr 6.3 (porta 8983)
- Thymeleaf 1.4.3.RELEASE
- Apache Tomcat (Embedded)
