package service;

import dto.Cedula;

import java.util.List;

/**
 * Interface para o serviço de saque.
 *
 * @author Eduarda de Brum Lucena
 */
public interface SaqueService {

    /**
     * Método que realiza o saque.
     *
     * @param valor Valor do saque
     * @return as informações da cédulas recebidas após.
     */
    List<Cedula> sacar(Integer valor);
}
