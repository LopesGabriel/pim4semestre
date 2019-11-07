# Endpoints
## Apartamentos
- /apartamentos (Get) -> Lista de apartamentos
- /apartamentos (POST) -> Cria um novo ap
- /apartamentos (PUT) -> Edita um ap
- /apartamentos (DELETE) -> Deleta um ap
- /apartamentos/id (GET) -> Recupera 1 ap

## Moradores
- /moradores (Get) -> Lista de moradores
- /moradores (POST) -> Cria um novo morador
- /moradores (PUT) -> Edita um morador
- /moradores (Delete) -> Deleta um morador
- /moradores/id (GET) -> Recupera um morador

## Veiculos
 - /veiculos (Get) -> Lista de veículos
 - /veiculos/id (Get) -> Recupera um veículo {id} (Integer)
 - /veiculos (POST) -> Cria um novo veículo
 - /veiculos (Put) -> Edita um veículo
 - /veiculos/id (Delete) -> Deleta o veiculo por id

 ## Vaga Estacionamento
 - /vagas/id (Get) -> Recupera uma vaga
 - /vagas (Get) -> Lista todas as vagas
 - /vagas/disponiveis (Get) -> Lista disponíveis

 ## Visitantes
 - /visitantes/id (Get) -> Retorna o visitante
 - /visitantes (Get) -> Lista com todos os visitantes
 - /visitantes (Post) -> Salvar o visitante
    - Parâmetros (nome, cpf, rg, dtEntrada, dtSaida(Nullable),)
 - /visitantes (Put) -> Editar o visitante
 - /visitantes (Delete) -> Deleta o visitante

Exemplo JSON
 ```javascript
{
    "id": null,
    "nome": "Nome Aqui",
    "cpf": "123.456.789-01",
    "rg": "RG aqui",
    "dtEntrada": "2019-11-07T16:31.000",
    "dtSaida": null
}
 ```
