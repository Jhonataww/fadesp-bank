# fadesp-bank
Desafio técnico - Nível 1. 
# Projeto de API de Pagamentos

Este projeto consiste em uma API para possibilitar o recebimento de pagamentos de débitos de pessoas físicas e jurídicas. A API permite criar cadastros de pessoas, contas, cartões de crédito e débito, realizar pagamentos, consultar pagamentos e alterar o status de pagamentos.

## Objetivo

O objetivo principal da API é fornecer um serviço para receber pagamentos de débitos de pessoas físicas e jurídicas. Quando um pagamento é recebido, ele é armazenado no banco de dados com status Pendente de Processamento. Uma aplicação terceira é responsável por processar os pagamentos e, após o processamento, alterar o status do pagamento para Processado com Sucesso ou Processado com Falha. Além disso, a API oferece funcionalidades para listar todos os pagamentos recebidos e filtrar os pagamentos com base em diferentes critérios.

## Endpoints

A seguir estão os principais endpoints disponíveis na API:

- **Cadastro de Pessoa:** `POST /cadastro/pessoa` - Cria um novo cadastro de pessoa.
- **Cadastro de Conta:** `POST /cadastro/conta` - Cria uma nova conta associada a uma pessoa.
- **Cartão de Crédito:** `POST /cartao/credito` - Cria um novo cartão de crédito associado a uma conta e pessoa.
- **Cartão de Débito:** `POST /cartao/debito` - Cria um novo cartão de débito associado a uma conta e pessoa.
- **Realizar Pagamento:** `POST /pagamento/realizar` - Realiza um novo pagamento, armazenando-o no banco de dados com status Pendente de Processamento.
- **Consultar Pagamentos:** `GET /pagamento/consultar` - Lista todos os pagamentos recebidos e permite filtrar os pagamentos com base em código de débito, CPF/CNPJ do pagador e status.
- **Excluir Pagamento:** `DELETE /pagamento/excluir` - Exclui um pagamento existente.
- **Alterar Status do Pagamento:** `PUT /pagamento/alterar` - Altera o status de um pagamento existente.

## Arquivos do Postman

Na pasta `src/main/resources/Postman`, você encontrará uma collection do Postman contendo requisições para cada endpoint da API. Esses arquivos podem ser importados no Postman para facilitar os testes e o entendimento dos endpoints disponíveis.

## Utilização

Para utilizar a API, é necessário seguir algumas etapas:

1. **Cadastro de Pessoa e Conta:** Antes de realizar um pagamento, é necessário cadastrar uma pessoa física ou jurídica (`POST /cadastro/pessoa`) e uma conta associada a essa pessoa (`POST /cadastro/conta`). A conta é essencial para identificar o pagador e registrar o débito.

2. **Cadastro de Cartão de Crédito ou Débito:** Dependendo do método de pagamento que está sendo realizado, é necessário cadastrar um cartão de crédito (`POST /cartao/credito`) ou de débito (`POST /cartao/debito`). O cartão é utilizado para efetuar o pagamento.

3. **Realização do Pagamento:** Com a pessoa, a conta e o cartão devidamente cadastrados, é possível realizar o pagamento (`POST /pagamento/realizar`). Certifique-se de fornecer os dados corretos, incluindo o código de débito, CPF/CNPJ do pagador, número do cartão, valor do pagamento, entre outros.

Caso não seja realizada a etapa de cadastro de pessoa, conta e cartão associado, as validações não permitirão que o pagamento seja efetuado.

## Documentação da API

A documentação da API está disponível no Swagger, uma ferramenta que permite visualizar e interagir com os endpoints da API de forma fácil e intuitiva. Você pode acessar a documentação da API através do seguinte URL:

```
http://localhost:8080/swagger-ui.html
```

Na documentação do Swagger, você encontrará informações detalhadas sobre cada endpoint da API, incluindo os parâmetros necessários, os tipos de dados esperados, os códigos de resposta e exemplos de requisições e respostas.


Na documentação do Swagger, você encontrará informações detalhadas sobre cada endpoint da API, incluindo os parâmetros necessários, os tipos de dados esperados, os códigos de resposta e exemplos de requisições e respostas.

## Scripts e Arquivos Adicionais

Na pasta `src/main/resources/scripts`, estão disponíveis os seguintes arquivos:

- `cadastro_pessoa.json`: JSON contendo o corpo da requisição para cadastrar uma pessoa.
- `cadastro_conta.json`: JSON contendo o corpo da requisição para cadastrar uma conta.
- `cadastro_cartao_credito.json`: JSON contendo o corpo da requisição para cadastrar um cartão de crédito.
- `cadastro_cartao_debito.json`: JSON contendo o corpo da requisição para cadastrar um cartão de débito.
- `realizar_pagamento.json`: JSON contendo o corpo da requisição para realizar um pagamento.
- `inserts.sql`: Script SQL contendo comandos para inserir dados na base de dados.

Esses arquivos podem ser utilizados para facilitar o teste e a integração
