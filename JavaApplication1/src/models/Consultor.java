package models;


public class Consultor implements Usuario{
         private String nome;
         private String login;
         private String senha;
         private String email;
         private boolean consultor;

         public Consultor(String nome, String login, String senha, String email) {
                  this.nome = nome;
                  this.login = login;
                  this.senha = senha;
                  this.email = email;
                  this.consultor = true;
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
         
         @Override
         public boolean getConsultor() {
                  return consultor;
         }
         
         @Override
         public String toString() {
                  return "Nome: " + nome + ", Email: " + email + "\n";
         }
}
