package Usuarios;

public class Cliente extends Usuario{


    public Cliente(String login, String nome, String senha, String email, Endereco endereco) {
        super(login, nome, senha, email, endereco);
    }
}
