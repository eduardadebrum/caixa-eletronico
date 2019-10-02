package exception;

/**
 * @author Eduarda de Brum Lucena
 */
public class SaqueException extends RuntimeException {

    private String message;

    public SaqueException(String message) {
        super(message);
    }
}
