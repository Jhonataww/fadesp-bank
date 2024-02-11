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

Para utilizar a API, basta enviar requisições HTTP para os endpoints desejados, utilizando o método adequado (GET, POST, PUT, DELETE) e fornecendo os parâmetros necessários. Certifique-se de seguir as instruções de cada endpoint e fornecer os dados corretamente para garantir o funcionamento adequado da API.

Este README fornece uma visão geral do projeto e dos principais endpoints da API. Para obter mais detalhes sobre cada endpoint, consulte a documentação completa da API ou analise o código-fonte do projeto.

Para quaisquer dúvidas ou problemas, entre em contato com a equipe responsável pelo projeto.

## Documentação da API

A documentação da API está disponível no Swagger, uma ferramenta que permite visualizar e interagir com os endpoints da API de forma fácil e intuitiva. Você pode acessar a documentação da API através do seguinte URL:

```
http://localhost:8080/swagger-ui.html
```

Na documentação do Swagger, você encontrará informações detalhadas sobre cada endpoint da API, incluindo os parâmetros necessários, os tipos de dados esperados, os códigos de resposta e exemplos de requisições e respostas.
