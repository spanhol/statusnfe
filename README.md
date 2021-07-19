# StatusNFE

uso dos endpoints REST

3- Retornar por rest os status atual dos serviços por estado.
http://localhost:8080/atual

4- Retornar por rest o status atual do serviço filtrando por estado.

url no formato:
http://localhost:8080/{estado}

funciona para todos os valores da coluna Autorizador como por exemplo SVC-AN ou PR
http://localhost:8080/SVC-AN
http://localhost:8080/PR

5- Retornar por rest os status dos serviços por estado filtrando por data.

url com timestamp no formato:
http://localhost:8080/atual/yyyy-mm-dd hh:mm:ss[.fffff]/yyyy-mm-dd hh:mm:ss[.fffff]

exemplo:
http://localhost:8080/atual/2021-07-17 23:26:00/2021-07-17 23:30:00
http://localhost:8080/atual/2021-07-17 23:26:00.100/2021-07-17 23:30:00.500

6- Retornar por rest qual estado teve mais indisponibilidade de serviço.
http://localhost:8080/indisponibilidade

# Frontend Angular na pasta frontend
