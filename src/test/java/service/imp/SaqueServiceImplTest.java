package service.imp;

import dto.CaixaEletronico;
import dto.Cedula;
import exception.SaqueException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

/**
 * Classe de teste do serviço de saque
 *
 * @author Eduarda de Brum Lucena
 */

@RunWith(MockitoJUnitRunner.class)
public class SaqueServiceImplTest {

    @InjectMocks
    private SaqueServiceImpl saqueService;

    @Mock
    private CaixaEletronicoServiceImpl caixaEletronicoService;

    @Test(expected = SaqueException.class)
    public void shouldThrowWhenValorSaqueNaoEValido() {
        saqueService.sacar(123456);
    }

    @Test(expected = SaqueException.class)
    public void shouldThrowWhenSaldoInsuficienteEmCaixa() {

        when(caixaEletronicoService.existsSaldoSuficienteEmCaixa(any()))
                .thenThrow(new SaqueException("Saldo em Caixa Insuficiente"));

        saqueService.sacar(300);
    }

    @Test
    public void shouldSuccessWhenSaqueETrintaReais() {
        when(caixaEletronicoService.existsSaldoSuficienteEmCaixa(any())).thenReturn(true);
        when(caixaEletronicoService.getDetalhesCaixaEletronico()).thenReturn(new CaixaEletronico(createCedulasEmCaixa()));

        List<Cedula> cedulasRecebidas = saqueService.sacar(30);

        assertTrue(cedulasRecebidas.contains(new Cedula(20, 1)));
        assertTrue(cedulasRecebidas.contains(new Cedula(10, 1)));
    }


    @Test
    public void shouldSuccessWhenSaqueEOitentaReais() {

        when(caixaEletronicoService.existsSaldoSuficienteEmCaixa(any())).thenReturn(true);
        when(caixaEletronicoService.getDetalhesCaixaEletronico()).thenReturn(new CaixaEletronico(createCedulasEmCaixa()));

        List<Cedula> cedulasRecebidas = saqueService.sacar(80);

        assertTrue(cedulasRecebidas.contains(new Cedula(50, 1)));
        assertTrue(cedulasRecebidas.contains(new Cedula(20, 1)));
        assertTrue(cedulasRecebidas.contains(new Cedula(10, 1)));
    }

    private List<Cedula> createCedulasEmCaixa() {
        CaixaEletronicoServiceImpl caixaEletronicoService = new CaixaEletronicoServiceImpl();
        return caixaEletronicoService.depositoEmCaixa(10);
    }
}