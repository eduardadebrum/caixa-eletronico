package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Eduarda de Brum Lucena
 */
@Data
@AllArgsConstructor
public class CaixaEletronico {

    private Integer total;
    private List<Cedula> cedulas;

    public CaixaEletronico(List<Cedula> cedulas) {
        this.cedulas = cedulas;
    }

    public Integer getTotal() {
        return total = cedulas.stream().mapToInt(cedula -> cedula.getQuantidade() * cedula.getValor()).sum();
    }

    public List<Cedula> getCedulas() {
        return cedulas;
    }
}
