package exceptions;

//Criacao da Exception para caso o Pagamento (Classe Pagamento) esteja INVALIDA
public class InvalidPagamentoException extends RuntimeException{

         public InvalidPagamentoException(String message) {
                  super(message);
         }
}
