package builders;

import models.Cliente;
import models.Consultor;
import models.Usuario;

public class UsuarioBuilder {
         private String nome;
         private String login;
         private String senha;
         private String email;

         public UsuarioBuilder() { }
         
         public UsuarioBuilder(Usuario usuario) { //construtor utilizado para atualizar atributos
                  setNome(usuario.getNome());
                  setLogin(usuario.getLogin());
                  setSenha(usuario.getSenha());
                  setEmail(usuario.getEmail());
         }

         public UsuarioBuilder setNome(String nome) {
                  this.nome = nome;
                  return this;
         }

         public UsuarioBuilder setLogin(String login) {
                  this.login = login;
                  return this;
         }

         public UsuarioBuilder setSenha(String senha) {
                  this.senha = senha;
                  return this;
         }

         public UsuarioBuilder setEmail(String email) {
                  this.email = email;
                  return this;
         }
         
         public Usuario build(boolean consultor) {
                  return consultor ? new Consultor(nome, login, senha, email) : new Cliente(nome, login, senha, email);
         }
}
