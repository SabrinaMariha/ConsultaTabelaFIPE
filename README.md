# Consulta Tabela FIPE

## Descrição do Projeto

Este projeto é uma aplicação Java desenvolvida com Spring Boot e Maven que consulta informações da Tabela FIPE. A Tabela FIPE é uma referência de preços médios de veículos no Brasil e é amplamente utilizada para avaliação de veículos novos e usados.

## Funcionalidades

- Consulta de preços de veículos na Tabela FIPE.
- Modelagem de dados utilizando a biblioteca Jackson para desserialização de JSON.
- Criação de interfaces e classes de serviço com métodos genéricos.
- Menu de opções interativo para facilitar a navegação e uso da aplicação.
- Operações em listas, incluindo filtro, ordenação, transformação de dados e geração de novas listas e mapas.
- Busca de episódios por nome ou data específica.
- Geração de estatísticas de avaliação por temporada e série.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework para simplificar a criação de aplicações Java.
- **Maven**: Ferramenta de automação de compilação e gerenciamento de dependências.
- **Jackson**: Biblioteca para processamento de JSON.
- **OMDb API**: API externa utilizada para recuperar dados de séries, temporadas e episódios.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- **src/main/java**: Contém os arquivos de código-fonte Java.
  - **com.example.fipe**: Pacote principal do projeto.
    - **models**: Contém as classes de modelo de dados.
    - **services**: Contém as interfaces e implementações dos serviços.
    - **utils**: Contém utilitários e classes auxiliares.
    - **Application.java**: Classe principal que inicializa a aplicação.
- **src/main/resources**: Contém arquivos de configuração e recursos estáticos.
- **pom.xml**: Arquivo de configuração do Maven.

## Configuração e Execução

### Pré-requisitos

- **Java 8 ou superior**: Necessário para compilar e executar a aplicação.
- **Maven**: Necessário para gerenciar as dependências e a compilação do projeto.



## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests para melhorias.



Este projeto foi desenvolvido como parte do curso, onde praticamos diversas funcionalidades do Java, incluindo listas, coleções de dados, funções lambdas, streams e geração de estatísticas.

