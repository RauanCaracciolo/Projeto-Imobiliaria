package Decorator;

import enums.TipoImovel;
import models.Casa;
import models.Cliente;

public class Teste {
    public static void main(String[] args) {
        Cliente luiz = new Cliente("Luiz","sla","sla123","slaporra");
        Visita v1 = new Visita("12/10/2004", luiz, new Casa("casa1","casa boa", 200.00, TipoImovel.CASA, luiz));

        EventoManager notificacao = new EventoManager();

        notificacao.inscrever(v1);

        notificacao.notificar("Reserva Ativa");
    }
}