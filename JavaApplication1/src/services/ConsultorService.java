package services;

import java.util.List;
import models.Consultor;

public interface ConsultorService {

         public List<Consultor> buscarTodosConsultores();

         public Consultor buscarConsultorPorLogin(String login);

         public void salvarConsultor(Consultor consultor);

         public void excluirConsultor(String login, String senha);
}
