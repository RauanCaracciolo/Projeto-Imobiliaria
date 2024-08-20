package exceptions;

public class InvalidApartamentoException extends Exception {

    public InvalidApartamentoException(String message, Throwable err) {
        super(message, err);
    }

}
