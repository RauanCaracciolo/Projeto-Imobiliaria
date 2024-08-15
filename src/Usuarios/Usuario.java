package Usuarios;

public abstract class Usuario {
    private String login;
    private String nome;
    private String senha;
    private String email;
    private Endereco endereco;

    public Usuario(String login, String nome, String senha, String email, Endereco endereco) {
        setLogin(login);
        setNome(nome);
        setSenha(senha);
        setEmail(email);
        setEndereco(endereco);
    }

    public String getLogin() {
        return login;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setLogin(String login) {
        if(login != "" || login != null){
            this.login = login;
        } else{
            throw new RuntimeException("O login precisa ser um login valido");
        }
    }

    public void setNome(String nome) {
        if(nome != "" || nome != null){
            this.nome = nome;
        } else{
            throw new RuntimeException("O nome precisa ser um nome existente");
        }
    }

    public void setSenha(String senha) {
        if(senha != "" || senha != null){
            this.senha = senha;
        } else{
            throw new RuntimeException("A senha precisa ser valida");
        }
    }

    public void setEmail(String email) {
        //Fazer regex
        if(email != "" || email != null){
            this.email = email;
        } else{
            throw new RuntimeException("O email precisa ser um email valido");
        }
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
