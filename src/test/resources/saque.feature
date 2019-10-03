Feature: Saque em um Caixa Eletrônico.

  Scenario: Saque R$ 30 em um Caixa Eletrônico
    Given Dado que o cliente precisa sacar dinheiro
    And O cliente informa o saque no valor R$ 30
    When quando o caixa emitir as notas
      | valor | quantidade |
      | 20    | 1          |
      | 10    | 1          |
    Then o caixa entrega o menor número de notas

  Scenario: Saque R$ 80 em um Caixa Eletrônico
    Given Dado que o cliente precisa sacar dinheiro
    And O cliente informa o saque no valor R$ 80
    When quando o caixa emitir as notas
      | valor | quantidade |
      | 10    | 1          |
      | 20    | 1          |
      | 50    | 1          |
    Then o caixa entrega o menor número de notas


  Scenario: Saque  acima do disponivel do Caixa Eletrônico
    Given Dado que o cliente precisa sacar dinheiro
    When O cliente informa o saque no valor R$ 20000 o caixa não permite o saque

  Scenario: Saque com valores inválidos
    Given Dado que o cliente precisa sacar dinheiro
    When O cliente informa o saque no valor R$ 199 o valor informado não é permitido para saque

