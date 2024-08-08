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

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
