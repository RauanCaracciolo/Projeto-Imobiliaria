package proxy;

import java.util.HashMap;

import models.Consultor;

public class EmailCache implements EmailService {

    private EmailService servico;
    private HashMap<Consultor, String> cache;

    public EmailCache(EmailService servico) {
        this.servico = servico;
        cache = new HashMap<>();
    }

    @Override
    public void enviarEmail(String msg, Consultor c) {
        if (!(cache.containsKey(msg))) {
            cache.put(c, msg);
            this.servico.enviarEmail(msg, c);
        } else {
            cache = new HashMap<>();
        }
    }
}