# Caixa Eletronico
Projeto de caixa eletrônico onde podem ser efetuados saques de valores.

**Objetivo:** Objetivo do algoritmo é entregar o menor número de notas disponível no caixa.

**Exemplo:**

**Notas disponíveis:**  R$ 100,00; R$ 50,00; R$ 20,00 e R$ 10,00

Valor do Saque: R$ 30,00 – Resultado Esperado: Entregar 1 nota de R$20,00 e 1 nota de R$ 10,00.

Valor do Saque: R$ 80,00 – Resultado Esperado: Entregar 1 nota de R$50,00 1 nota de R$ 20,00 e 1 nota de R$ 10,00.


## Tecnologias 
 Foi utilizado a versão do  **Java 8** e a ferramenta **Gradle**. A aplicação foi implementada através da ide de desenvolvimento **Intellij** e o sistema operacional **Linux**.
 
 Obs: Os comandos a serem apresentados são para ambientes **Linux**. 

### Estrutura do Projeto

O projeto está estruturado com as classes que processam as regras de negócio e os testes para validação da implementação.

Para baixar as dependências do projeto pode ser executado o seguinte comando através do terminal:  
```
/.gradlew clean build
```

### Execução dos Testes
Foram desenvolvimento testes unitários utilizando **Junit e o Mockito**. Para os testes automatizados foi utilizado o **Cucumber**.

Para executar os testes pelo terminal deve ser utilizado o seguinte comando:

```
./gradlew clean test --info
```

#### Testes Unitários

Testes unitários com os cenários principal e de excessão.

![alt text](https://github.com/eduardadebrum/caixa-eletronico/blob/master/img/unit/Captura%20de%20tela%20de%202019-10-03%2003-07-31.png)

Essa imagem mostra a cobertura dos testes unitários:

![alt text](https://github.com/eduardadebrum/caixa-eletronico/blob/master/img/unit/Captura%20de%20tela%20de%202019-10-03%2003-08-00.png)


#### Testes Automatizados  

Cenários desenvolvidos para os testes automatizados.

![alt text](https://github.com/eduardadebrum/caixa-eletronico/blob/master/img/integration/Captura%20de%20tela%20de%202019-10-03%2003-07-02.png)

Toda vez que os testes são executados é criado um relatório com a informações do cenários implementados.

![alt text](https://github.com/eduardadebrum/caixa-eletronico/blob/master/img/integration/Captura%20de%20tela%20de%202019-10-03%2003-49-21.png)

![alt text](https://github.com/eduardadebrum/caixa-eletronico/blob/master/img/integration/Captura%20de%20tela%20de%202019-10-03%2003-50-20.png)

## Resolução do Problema
Uma Breve descrição da lógica utilizada.

Os valores em caixa: R$ 100,00; R$ 50,00; R$ 20,00 e R$ 10,00

```
Se eu desejo sacar R$ 80,00:
Caso o sistema comece a dar notas de R$ 10,00 são necessárias 8 notas. 
Caso o sistema comece a dar notas de R$ 20,00 são necessárias 4 notas. 
Nesse caso tivemos um redução significativa. Como o propósito é fornecer o minimo, a ideia é que sejam utilizadas as maiores notas desde que elas não sejam maiores que o valor de saque. 

Exemplo:

Caso o sistema tente a dar uma nota de R$ 100,00 não será permitido, pois o número de saque é menor.
Caso a próxima nota(R$ 50,00) seja menor ou igual ao valor do saque, é possivél 

Lógica(nota| valor)      | Resultado 
se 50 <= 80              | então falta = 80 - 50 = 40
se 50 <= 30              | não é menor, próxima nota.
se 20 <= 30              | falta = 30 - 20 = 10
se 20 <= 10              | não é menor, próxima nota.
se 10 <= 10              |  então falta = 10 - 10 = 0

Resultado 
nota | quantidade
50   |  1 
20   |  1
10   |  1


```
