package services;

import java.util.List;
import models.Cliente;

public interface ClienteService {

         public List<Cliente> buscarTodosClientes();

         public Cliente buscarClientePorLogin(String login);

         public void salvarCliente(Cliente cliente);

         public void excluirCliente(String login, String senha);
}
