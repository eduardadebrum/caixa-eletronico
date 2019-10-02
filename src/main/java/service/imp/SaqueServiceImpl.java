package service.imp;

import dto.CaixaEletronico;
import dto.Cedula;
import exception.SaqueException;
import service.SaqueService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Classe responsavél por fazer o processo de saque.
 *
 * @author Eduarda de Brum Lucena
 */
public class SaqueServiceImpl implements SaqueService {

    private static final Logger logger = Logger.getLogger(SaqueServiceImpl.class.getName());

    private CaixaEletronicoServiceImpl caixaEletronicoService;

    public SaqueServiceImpl() {
        this.caixaEletronicoService = new CaixaEletronicoServiceImpl();
    }

    @Override
    public List<Cedula> sacar(Integer valor) {
        List<Cedula> cedulasRecidas = new ArrayList<>();

        caixaEletronicoService.depositoEmCaixa(5);

        isValidateValorSaque(valor);
        caixaEletronicoService.existsSaldoSuficienteEmCaixa(valor);
        CaixaEletronico detalhesCaixaEletronico = caixaEletronicoService.getDetalhesCaixaEletronico();
        processSelecaoCedulas(valor, detalhesCaixaEletronico, cedulasRecidas);

        return cedulasRecidas;
    }

    private void processSelecaoCedulas(Integer valor, CaixaEletronico detalhesCaixaEletronico, List<Cedula> cedulasRecidas) {
        logger.info("Processo de Seleção de Células");
        for (Cedula cedula : detalhesCaixaEletronico.getCedulas()) {
            int quantidade = valor / cedula.getValor();

            if (quantidade > 0 && cedula.getQuantidade() >= quantidade) {
                int restante = Math.subtractExact(cedula.getQuantidade(), quantidade);
                cedula.setQuantidade(restante);
                cedulasRecidas.add(new Cedula(cedula.getValor(), quantidade));
            }
            logger.info("Cédula: R$ " + cedula.getValor() + " Quantidade Restante Caixa: " + quantidade);
            valor = valor % cedula.getValor();
        }
    }


    private boolean isValidateValorSaque(Integer valorSaque) {
        if (Objects.nonNull(valorSaque) && valorSaque % 10 == 0) {
            logger.info("Valor Válido para Saque.");
            return true;
        }

        logger.warning("Valor de Saque Inválido.");
        throw new SaqueException("Valor de Saque Inválido.");
    }

}
