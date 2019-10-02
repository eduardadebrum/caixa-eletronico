package service.imp;

import dto.CaixaEletronico;
import dto.Cedula;
import exception.CaixaEletronicoException;
import exception.SaqueException;
import service.CaixaEletronicoService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Classe de serviço do caixa eletronico
 *
 * @author Eduarda de Brum Lucena
 */
public class CaixaEletronicoServiceImpl implements CaixaEletronicoService {

    private static final Logger logger = Logger.getLogger(CaixaEletronicoServiceImpl.class.getName());

    private List<Cedula> cedulas;

    CaixaEletronicoServiceImpl() {
        this.cedulas = depositoEmCaixa(5);
    }

    @Override
    public boolean existsSaldoSuficienteEmCaixa(Integer valorSaque) {
        int total = saldoDisponivelEmCaixa(cedulas);
        if (valorSaque < total) {
            logger.info("Saldo Disponivel em Caixa: {}" + total);
            return true;
        }
        logger.warning("Saldo em Caixa Insuficiente");
        throw new SaqueException("Saldo em Caixa Insuficiente");
    }


    @Override
    public CaixaEletronico getDetalhesCaixaEletronico() {
        return new CaixaEletronico(cedulas);
    }

    @Override
    public Integer saldoDisponivelEmCaixa(List<Cedula> cedulas) {
        return new CaixaEletronico(cedulas).getTotal();
    }

    @Override
    public List<Cedula> depositoEmCaixa(Integer quantidade) {
        if (Objects.nonNull(quantidade) && quantidade > 0) {
            cedulas.add(new Cedula(10, quantidade));
            cedulas.add(new Cedula(20, quantidade));
            cedulas.add(new Cedula(50, quantidade));
            cedulas.add(new Cedula(100, quantidade));

            this.cedulas = cedulas.stream().sorted(Comparator.comparingInt(Cedula::getValor)
                    .reversed())
                    .collect(Collectors.toList());
            return cedulas;
        }


        throw new CaixaEletronicoException("Deposito no caixa eletronico inválido. Quantidade de notas não informada");
    }

    public void setCedulas(List<Cedula> cedulas) {
        this.cedulas = cedulas;
    }
}
