package models;


public class Cliente implements Usuario{
         private String nome;
         private String login;
         private String senha;
         private String email;

         public Cliente(String nome, String login, String senha, String email) {
                  this.nome = nome;
                  this.login = login;
                  this.senha = senha;
                  this.email = email;
         }
         
         @Override
         public String getNome() {
                  return nome;
         }

         @Override
         public String getSenha() {
                  return senha;
         }

         @Override
         public String getLogin() {
                  return login;
         }

         @Override
         public String getEmail() {
                  return email;
         }
}
