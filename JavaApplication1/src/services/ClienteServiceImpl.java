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
        return repository.buscarTodosClientes();
    }

    @Override
    public Cliente buscarClientePorLogin(String login) {
        if (login != null) {
            if (repository.contem(login)) {
                if (repository.buscarPorLogin(login) instanceof Cliente) {
                    return (Cliente) repository.buscarPorLogin(login);
                }
            }
        }
        throw new LoginInvalidoException("Login de cliente invalido.");
    }

    @Override
    public void salvarCliente(Cliente cliente) {
        if (cliente != null) {
            if (!repository.contem(cliente.getLogin())) {
                repository.salvar(cliente);
            }
        }
    }

    @Override
    public void excluirCliente(String login, String senha) {
        if (repository.contem(login)) {
            Usuario usuario = repository.buscarPorLogin(login);

            if (usuario instanceof Cliente) {
                if (usuario.getSenha().equals(senha)) {
                    repository.excluir(login);
                }
            } else {
                throw new LoginInvalidoException("Usuário não é um cliente.");
            }
        }
        throw new LoginInvalidoException("Usuário não existe.");
    }
}
