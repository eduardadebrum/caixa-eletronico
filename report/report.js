$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/saque.feature");
formatter.feature({
  "name": "Saque em um Caixa Eletrônico.",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Saque R$ 30 em um Caixa Eletrônico",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Dado que o cliente precisa sacar dinheiro",
  "keyword": "Given "
});
formatter.match({
  "location": "SaqueSteps.java:29"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "O cliente informa o saque no valor R$ 30",
  "keyword": "And "
});
formatter.match({
  "location": "SaqueSteps.java:33"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "quando o caixa emitir as notas",
  "rows": [
    {
      "cells": [
        "valor",
        "quantidade"
      ]
    },
    {
      "cells": [
        "20",
        "1"
      ]
    },
    {
      "cells": [
        "10",
        "1"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "SaqueSteps.java:41"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "o caixa entrega o menor número de notas",
  "keyword": "Then "
});
formatter.match({
  "location": "SaqueSteps.java:45"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Saque R$ 80 em um Caixa Eletrônico",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Dado que o cliente precisa sacar dinheiro",
  "keyword": "Given "
});
formatter.match({
  "location": "SaqueSteps.java:29"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "O cliente informa o saque no valor R$ 80",
  "keyword": "And "
});
formatter.match({
  "location": "SaqueSteps.java:33"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "quando o caixa emitir as notas",
  "rows": [
    {
      "cells": [
        "valor",
        "quantidade"
      ]
    },
    {
      "cells": [
        "10",
        "1"
      ]
    },
    {
      "cells": [
        "20",
        "1"
      ]
    },
    {
      "cells": [
        "50",
        "1"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "SaqueSteps.java:41"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "o caixa entrega o menor número de notas",
  "keyword": "Then "
});
formatter.match({
  "location": "SaqueSteps.java:45"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Saque  acima do disponivel do Caixa Eletrônico",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Dado que o cliente precisa sacar dinheiro",
  "keyword": "Given "
});
formatter.match({
  "location": "SaqueSteps.java:29"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "O cliente informa o saque no valor R$ 20000 o caixa não permite o saque",
  "keyword": "When "
});
formatter.match({
  "location": "SaqueSteps.java:49"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Saque com valores inválidos",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Dado que o cliente precisa sacar dinheiro",
  "keyword": "Given "
});
formatter.match({
  "location": "SaqueSteps.java:29"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "O cliente informa o saque no valor R$ 199 o valor informado não é permitido para saque",
  "keyword": "When "
});
formatter.match({
  "location": "SaqueSteps.java:57"
});
formatter.result({
  "status": "passed"
});
});