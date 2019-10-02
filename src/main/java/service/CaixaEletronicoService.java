package service;

import dto.CaixaEletronico;
import dto.Cedula;

import java.util.List;

/**
 * Interface para implementar o servico de caixa eletronico.
 *
 * @author Eduarda de Brum Lucena
 */
public interface CaixaEletronicoService {

    /**
     * Verifica se existe saldo no caixa eletronico para efetuar o saque.
     *
     * @param valorSaque Valor do saque
     * @return True caso as cedulas no caixa sejam superior ao valor de saque.
     * @throws exception.SaqueException caso o saldo seja insuficiente.
     */
    boolean existsSaldoSuficienteEmCaixa(Integer valorSaque);

    /**
     * Busca informações contidas no caixa eletronico
     *
     * @return retorna o objecto contendo os valores da cédula e o total em caixa.
     */
    CaixaEletronico getDetalhesCaixaEletronico();

    /**
     * @param cedulas quantidade de cédulas
     * @return saldo disponivel em caixa
     */
    Integer saldoDisponivelEmCaixa(List<Cedula> cedulas);

    /**
     * Esse método visa depositar valores dentro do caixa eletronico.
     *
     * @param quantidade Referente a quantidade de cédula para cada valor.
     * @return a lista de cédula.
     */
    List<Cedula> depositoEmCaixa(Integer quantidade);
}
