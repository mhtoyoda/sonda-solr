# sonda-solr
Projeto Teste Elo7 - SondaSolr by Marcelo Toyoda

Este projeto visa simular comandos enviados para um conjunto de Sondas para explorar a malha do planalto.
Seguindo uma série de instruções de coordenadas e tendo como retorno a posição final das sondas.

*Caso as intruções de movimento ultrapassem o limite superior direito da malha, assumi que a posição final, seja da coordenada x ou y será igual
ao limite x e/ou y da malha do planalto.

*Dentro da pasta resources/solr-files, encontram-se versionados os arquivos de configuração para a coleção sonda, criada para o teste.

*Todos os métodos de indexação e busca estão cobertos com testes unitários.

*Requisitos de sistema:
- Java JDK 1.8
- Spring Boot 1.4.3
- Spring Data Solr
- Maven 3
- Apache Solr 6.3 (porta 8983)
