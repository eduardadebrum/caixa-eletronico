package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Eduarda de Brum Lucena
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cedula {

    private Integer valor;
    private Integer quantidade;
}
