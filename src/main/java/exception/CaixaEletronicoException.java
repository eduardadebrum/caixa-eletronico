package exception;

/**
 * @author Eduarda de Brum Lucena
 */
public class CaixaEletronicoException extends RuntimeException {

    private String message;

    public CaixaEletronicoException(String message) {
        super(message);
    }
}
