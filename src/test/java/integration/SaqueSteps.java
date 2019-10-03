package integration;

import dto.Cedula;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import service.imp.SaqueServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Classe que executa os testes automatizados de saque.
 *
 * @author Eduarda de Brum Lucena
 */
public class SaqueSteps implements En {

    private List<Cedula> cedulasResult;
    private List<Cedula> cedulasExcepted;

    private SaqueServiceImpl saqueService;

    public SaqueSteps() {

        Given("^Dado que o cliente precisa sacar dinheiro$", () -> {
            this.saqueService = new SaqueServiceImpl();
        });

        And("^O cliente informa o saque no valor R\\$ (\\d+)$", (Integer saque) -> {
            try {
                this.cedulasResult = saqueService.sacar(saque);
            } catch (Exception e) {
                assertEquals("Saldo em Caixa Insuficiente", e.getLocalizedMessage());
            }
        });

        When("^quando o caixa emitir as notas$", (DataTable table) -> {
            this.cedulasExcepted = converter(table.asMaps());
        });

        Then("^o caixa entrega o menor número de notas$", () -> {
            assertTrue(this.cedulasResult.containsAll(this.cedulasExcepted));
        });

        When("^O cliente informa o saque no valor R\\$ (\\d+) o caixa não permite o saque$", (Integer saque) -> {
            try {
                saqueService.sacar(saque);
            } catch (Exception e) {
                assertEquals("Saldo em Caixa Insuficiente", e.getLocalizedMessage());
            }
        });

        When("^O cliente informa o saque no valor R\\$ (\\d+) o valor informado não é permitido para saque$", (Integer saque) -> {
            try {
                saqueService.sacar(saque);
            } catch (Exception e) {
                assertEquals("Valor de Saque Inválido.", e.getLocalizedMessage());
            }
        });
    }

    private List<Cedula> converter(List<Map<String, String>> maps) {
        List<Cedula> cedulas = new ArrayList<>();
        maps.forEach(cedula -> {
            Cedula result =
                    new Cedula(Integer.valueOf(cedula.get("valor")), Integer.valueOf(cedula.get("quantidade")));
            cedulas.add(result);
        });

        return cedulas;
    }
}
