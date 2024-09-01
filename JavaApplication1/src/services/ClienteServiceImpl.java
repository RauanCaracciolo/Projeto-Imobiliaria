package services;

import exceptions.LoginInvalidoException;
import java.util.ArrayList;
import java.util.List;
import models.Cliente;
import models.Usuario;
import repositories.UsuarioRepository;
import updaters.UsuarioUpdater;
//       COLOCAR MAIS VALIDACOES DEPOIS
//       COLOCAR MAIS VALIDACOES DEPOIS
//       COLOCAR MAIS VALIDACOES DEPOIS

public class ClienteServiceImpl implements ClienteService {

         private UsuarioRepository repository;
         private UsuarioUpdater usuarioUpdater;

         public ClienteServiceImpl(UsuarioRepository repository) {
                  this.repository = repository;
                  this.usuarioUpdater = new UsuarioUpdater(repository);
         }

         @Override
         public List<Cliente> buscarTodosClientes() {
                  List<Cliente> resultado = new ArrayList<>();

                  for (Usuario u : repository.buscarTodos()) {
                           if (!u.getConsultor()) {
                                    resultado.add((Cliente) u);
                           }
                  }

                  return resultado;
         }

         @Override
         public Cliente buscarClientePorLogin(String login) {
                  Cliente cliente;

                  if (login != null) {
                           cliente = (Cliente) repository.buscarClientePorLogin(login);
                           return cliente;
                  }

                  throw new LoginInvalidoException("Login invalido");
         }

         @Override
         public void salvarCliente(Cliente cliente) {
                  if (cliente != null) {
                           repository.salvar(cliente);
                  }
         }

         @Override
         public void excluirCliente(String login, String senha) {
                  Usuario usuario = repository.buscarClientePorLogin(login);

                  if (usuario instanceof Cliente) {
                           Cliente cliente = (Cliente) usuario;
                           if (cliente.getSenha().equals(senha)) {
                                    repository.excluir(login);
                           }
                  } else {
                           throw new LoginInvalidoException("Usuário não é um cliente");
                  }
         }
}
