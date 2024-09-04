package proxy;

import models.Consultor;

public class Main {
    public static void main(String[] args) {

        EmailService servico = new EmailCache(new EmailLib());
        Consultor c = new Consultor("pedro", "pedr", "senha", "emaildopedro@gmail.com");

        servico.enviarEmail("bom dia pedro", c);

        servico.enviarEmail("bom tarde", c);
    }
}