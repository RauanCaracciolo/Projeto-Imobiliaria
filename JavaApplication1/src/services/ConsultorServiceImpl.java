package services;

import exceptions.LoginInvalidoException;
import java.util.ArrayList;
import java.util.List;
import models.Cliente;
import models.Consultor;
import models.Usuario;
import repositories.UsuarioRepository;
import updaters.UsuarioUpdater;

public class ConsultorServiceImpl implements ConsultorService {

         private UsuarioRepository repository;
         private UsuarioUpdater usuarioUpdater;

         public ConsultorServiceImpl(UsuarioRepository repository) {
                  this.repository = repository;
                  usuarioUpdater = new UsuarioUpdater(repository);
         }

         @Override
         public List<Consultor> buscarTodosConsultores() {
                  return repository.buscarTodosConsultores();
         }

         @Override
         public Consultor buscarConsultorPorLogin(String login) {
                  if (login != null) {
                           if (repository.contem(login)) {
                                    if (repository.buscarPorLogin(login) instanceof Consultor consultor) {
                                             return consultor;
                                    }
                           }
                  }
                  throw new LoginInvalidoException("Login de consultor invalido.");
         }

         @Override
         public void salvarConsultor(Consultor consultor) {
                  if (consultor != null) {
                           if (!repository.contem(consultor.getLogin())) {
                                    repository.salvar(consultor);
                           }
                  }
         }

         @Override
         public void excluirConsultor(String login, String senha) {
                  if (repository.contem(login)) {
                           Usuario usuario = repository.buscarPorLogin(login);

                           if (usuario instanceof Consultor consultor) {
                                    if (consultor.getSenha().equals(senha)) {
                                             repository.excluir(login);
                                    }
                           } else {
                                    throw new LoginInvalidoException("Usuário não é um consultor.");
                           }
                  }
                  throw new LoginInvalidoException("Usuário não existe.");
         }
}
