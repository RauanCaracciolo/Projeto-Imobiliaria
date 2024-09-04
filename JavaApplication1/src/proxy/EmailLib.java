package proxy;

import models.Consultor;

public class EmailLib implements EmailService {

    @Override
    public void enviarEmail(String msg, Consultor c) {
        System.out.println("Enviando mensagem: '" + msg + "' para " + c.getEmail());
        // ...
        System.out.println("Mensagem Enviada!");
    }

}