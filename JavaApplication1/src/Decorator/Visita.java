package Decorator;

import models.Imovel;
import models.Usuario;

//Criacao da classe Visita e tambem
//suas variaveis, metodos e funcoes
public class Visita implements EventoListener {
    private String data;
    private Usuario user;
    private Imovel imovel;

    public Visita(String data, Usuario user, Imovel imovel) {
        setData(data);
        setUser(user);
        setImovel(imovel);
    }

    public String getData() {
        return data;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    @Override
    public void update(String mensagem) {
        System.out.println(mensagem +
                "\nPara: " + user.getNome() +
                "\nIMOVEL: " + imovel.getTipoImovel() +
                "\nNOME: " + imovel.getTitulo() +
                "\nDESCRICAO:  " + imovel.getDescricao() +
                "\nPRECO: R$" + imovel.getPreco() +
                "\nData => " + getData());
    }
}