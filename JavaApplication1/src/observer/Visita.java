package observer;

import models.Imovel;
import models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Visita implements EventoListener {
    private String data;
    private Usuario user;
    private Imovel imovel;

    List<Imovel> agendados = new ArrayList<>();

    public Visita(String data, Usuario user, Imovel imovel) {
        setData(data);
        setUser(user);
        setImovel(imovel);
    }

    public void agendarVisita(String data, Imovel imovel, Usuario user) {
        /*
         * if(imovel.isDisponivel){
         * if(data > 0 && data < 32){
         * sout => "Agendada"
         * agendados.add(imovel)
         * }
         * }
         */
    }

    public String getData() {
        return data;
    }

    public Usuario getUser() {
        return user;
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
        System.out.println("Para: " + user.getNome() +
                "\nIMOVEL: " + imovel.getTipoImovel() +
                "\nNOME: " + imovel.getTitulo() +
                "\nDESCRICAO:  " + imovel.getDescricao() +
                "\nPRECO: R$" + imovel.getPreco() +
                "\nData => " + getData());
    }
}
