package service.imp;

import dto.CaixaEletronico;
import dto.Cedula;
import exception.CaixaEletronicoException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Eduarda de Brum Lucena
 */
@RunWith(MockitoJUnitRunner.class)
public class CaixaEletronicoServiceImplTest {

    @InjectMocks
    private CaixaEletronicoServiceImpl caixaEletronicoService;

    @Test
    public void shouldSuccessWhenExistsSaldoSuficienteEmCaixa() {
        caixaEletronicoService.setCedulas(createCedulasEmCaixa(100));
        boolean existsSaldoSuficienteEmCaixa = caixaEletronicoService.existsSaldoSuficienteEmCaixa(50);
        assertTrue(existsSaldoSuficienteEmCaixa);
    }

    @Test(expected = CaixaEletronicoException.class)
    public void shouldFailedWhenNotExistsSaldoSuficienteEmCaixa() {
        caixaEletronicoService.setCedulas(createCedulasEmCaixa(0));
        caixaEletronicoService.existsSaldoSuficienteEmCaixa(5000);
    }

    @Test
    public void shouldSuccessGetDetalhesCaixaEletronico() {
        caixaEletronicoService.setCedulas(createCedulasEmCaixa(10));
        CaixaEletronico detalhesCaixaEletronico = caixaEletronicoService.getDetalhesCaixaEletronico();

        assertNotNull(detalhesCaixaEletronico.getCedulas());
        assertNotNull(detalhesCaixaEletronico.getTotal());
    }

    @Test
    public void shouldSuccessSaldoDisponivelEmCaixa() {
        Integer saldo = caixaEletronicoService.saldoDisponivelEmCaixa(createCedulasEmCaixa(10));
        assertTrue(saldo > 0);
    }

    @Test
    public void shouldSuccessWhendepositoEmCaixa() {
        Integer quantidade = 5;
        List<Cedula> cedulas = caixaEletronicoService.depositoEmCaixa(quantidade);
        assertTrue(cedulas.contains(new Cedula(50, quantidade)));

    }

    @Test(expected = CaixaEletronicoException.class)
    public void shouldFailWhenCedulasNaoForamDepositadas() {
        Integer quantidade = 0;
        caixaEletronicoService.depositoEmCaixa(quantidade);
    }

    private List<Cedula> createCedulasEmCaixa(Integer quantidade) {
        CaixaEletronicoServiceImpl caixaEletronicoService = new CaixaEletronicoServiceImpl();
        return caixaEletronicoService.depositoEmCaixa(quantidade);
    }
}