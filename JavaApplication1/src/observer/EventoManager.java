package observer;

import java.util.ArrayList;

public class EventoManager {
    private ArrayList<EventoListener> notificacoes;

    public EventoManager() {
        notificacoes = new ArrayList<>();
    }

    public void inscrever(EventoListener e) {
        if (!notificacoes.contains(e)) {
            notificacoes.add(e);
        }
    }

    public void remover(EventoListener e) {
        if (notificacoes.contains(e)) {
            notificacoes.remove(e);
        }
    }

    public void notificar(String mensagem) {
        for (EventoListener e : notificacoes) {
            e.update(mensagem);
        }
    }

}
