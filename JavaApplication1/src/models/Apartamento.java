package models;

import enums.TipoImovel;
import exceptions.InvalidInputException;

import java.text.NumberFormat;

public class Apartamento extends Imovel {

    private String titulo;
    private String descricao;
    private double preco;
    private TipoImovel tipoImovel;
    private Usuario proprietario;

    private boolean alugada;

    public Apartamento(String titulo, String descricao, double preco, TipoImovel tipoImovel, Usuario proprietario) {
        setTitulo(titulo);
        setDescricao(descricao);
        setPreco(preco);
        setTipoImovel(tipoImovel);
        setProprietario(proprietario);
        alugada = false;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public void setTitulo(String titulo) {
        if (titulo != null) {
            this.titulo = titulo;
        } else {
            throw new InvalidInputException("Titulo nulo!");
        }
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void setDescricao(String descricao) {
        if (descricao != null) {
            this.descricao = descricao;
        } else {
            throw new InvalidInputException("Descrição nula!");
        }
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public void setPreco(double preco) {
        if (preco > 0.0) {
            this.preco = preco;
        } else {
            throw new InvalidInputException("Preço negativo!");
        }
    }

    @Override
    public TipoImovel getTipoImovel() {
        return tipoImovel;
    }

    @Override
    public void setTipoImovel(TipoImovel tipoImovel) {
        if (tipoImovel != null) {
            this.tipoImovel = tipoImovel;
        } else {
            throw new InvalidInputException("Tipo de imovel invalido!");
        }
    }

    @Override
    public Usuario getProprietario() {
        return proprietario;
    }

    @Override
    public void setProprietario(Usuario usuario) {
        if (usuario != null) {
            this.proprietario = usuario;
        } else {
            throw new InvalidInputException("Proprietario nulo!");
        }
    }

    @Override
    public void aluga() {
        alugada = true;
    }

    @Override
    public String toString() {
        NumberFormat formater = NumberFormat.getNumberInstance();
        String valorFormatado = formater.format(preco);
        return "\n\n============================================================================\n" + getTitulo()
                + "\n----------------------------------------------------------------------------\n" + getDescricao()
                + "\n\nPreco: R$" + valorFormatado + "\nContato proprietario: " + proprietario.getEmail()
                + "\n============================================================================\n\n";
    }
}
