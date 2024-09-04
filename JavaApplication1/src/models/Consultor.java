package models;


import exceptions.InvalidInputException;

public class Consultor implements Usuario{
         private String nome;
         private String login;
         private String senha;
         private String email;
         private boolean consultor;

         public Consultor(String nome, String login, String senha, String email) {
                  setNome(nome);
                  setLogin(login);
                  setSenha(senha);
                  setEmail(email);
                  this.consultor = true;
         }
         public void alugar(Imovel imovel, Usuario usuario){
             imovel.aluga();
             imovel.setProprietario(usuario);
         }
         @Override
         public String getNome() {
                  return nome;
         }

    @Override
    public void setNome(String nome) {
        if(nome != null){
            this.nome = nome;
        }else{
            throw new InvalidInputException("Nome invalido!");
        }
    }

    @Override
    public String getSenha() {
        return senha;
    }

    @Override
    public void setSenha(String senha) {
        if(senha != null){
            this.senha = senha;
        }else{
            throw new InvalidInputException("Senha invalida!");
        }
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login) {
        if(login != null){
            this.login = login;
        }else{
            throw new InvalidInputException("Login invalido!");
        }
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        if(email != null){
            this.email = email;
        }else{
            throw new InvalidInputException("Email invalido!");
        }
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
