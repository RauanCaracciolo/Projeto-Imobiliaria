package factories;

import builders.UsuarioBuilder;
import models.Usuario;

//Criacao do UsuarioFactory, onde foi usado um Builder

public class UsuarioFactory {
         public static Usuario criarUsuario(String nome, String login, String senha, String email, boolean consultor) {
                  UsuarioBuilder builder = new UsuarioBuilder();
                  return builder
                          .setNome(nome)
                          .setLogin(login)
                          .setSenha(senha)
                          .setEmail(email)
                          .build(consultor);
         }
}
