package proxy;

import models.Consultor;

public interface EmailService {

    public void enviarEmail(String msg, Consultor c);

}