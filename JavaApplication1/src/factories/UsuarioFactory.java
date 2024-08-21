package factories;

import builders.UsuarioBuilder;
import models.Usuario;

public class UsuarioFactory {
         public static Usuario criarUsuario(String nome, String login, String senha, String email, boolean adm) {
                  UsuarioBuilder builder = new UsuarioBuilder();
                  return builder
                          .setNome(nome)
                          .setLogin(login)
                          .setSenha(senha)
                          .setEmail(email)
                          .build(adm);
         }
}
