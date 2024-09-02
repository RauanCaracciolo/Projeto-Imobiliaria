package exceptions;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String mensagem){
        super(mensagem);
    }
}
