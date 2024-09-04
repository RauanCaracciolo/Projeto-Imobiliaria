package exceptions;

//Criacao da Exception para caso um INPUT esteja algo INVALIDO
public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String mensagem){
        super(mensagem);
    }
}
