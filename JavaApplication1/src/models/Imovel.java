package models;

import enums.TipoImovel;

public abstract class Imovel {
    private String titulo;
    private String descricao;
    private double preco;
    private TipoImovel tipoImovel;

    private Usuario proprietario;

    public String getTitulo() {
        return titulo;
    };

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    };

    public String getDescricao() {
        return descricao;
    };

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    };

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    };

    public TipoImovel getTipoImovel() {
        return tipoImovel;
    };

    public void setTipoImovel(TipoImovel tipoImovel) {
        this.tipoImovel = tipoImovel;
    };

    public Usuario getProprietario() {
        return proprietario;
    };

    public void setProprietario(Usuario usuario) {
        this.proprietario = usuario;
    };

    public void aluga() {
    };

    // Precisa informar se o Imovel esta disponivel ou não, depois implementar no
    // decorator
}