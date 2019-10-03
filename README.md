# Caixa Eletronico
Projeto de caixa eletrônico onde podem ser efetuados saques de valores.

**Objetivo:** Objetivo do algoritmo é entregar o menor número de notas disponível no caixa.

**Exemplo:**

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

