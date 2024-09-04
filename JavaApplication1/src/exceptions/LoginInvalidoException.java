package exceptions;

//Criacao da Exception para caso o Longin (Classe Usuario) esteja INVALIDA
public class LoginInvalidoException extends RuntimeException{

         public LoginInvalidoException(String message) {
                  super(message);
         }
}
