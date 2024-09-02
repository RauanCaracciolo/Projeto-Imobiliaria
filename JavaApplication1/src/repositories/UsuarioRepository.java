package repositories;

import exceptions.LoginInvalidoException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.Cliente;
import models.Consultor;
import models.Usuario;

public class UsuarioRepository {

         // Map<login, usuario>
         private Map<String, Usuario> usuarios = new HashMap<>();

         public void salvar(Usuario usuario) {
                  if (!usuarios.containsKey(usuario.getLogin())) {
                           usuarios.put(usuario.getLogin(), usuario);
                  }
         }

         public void excluir(String login) {
                  if (usuarios.containsKey(login)) {
                           usuarios.remove(login);
                  }
         }

         public void atualizar(Usuario usuario, Usuario usuarioAtualizado) {
                  excluir(usuario.getLogin());
                  salvar(usuarioAtualizado);
         }

         public Usuario buscarPorLogin(String login) {
                  Usuario usuario = usuarios.get(login);
                  
                  if (usuario instanceof Cliente cliente) {
                           return cliente;
                  } else if (usuario instanceof Consultor consultor) {
                           return consultor;
                  }
                  
                  throw new LoginInvalidoException("Login invalido");
         }

         public List<Usuario> buscarTodos() {
                  return usuarios.values().stream().toList();
         }
         
         public List<Consultor> buscarTodosConsultores() {
                  return usuarios.values().stream()
                          .filter(usuario -> usuario instanceof Consultor)
                          .map(usuario -> (Consultor) usuario)
                          .toList();
         }

         public List<Cliente> buscarTodosClientes() {
                  return usuarios.values().stream()
                          .filter(usuario -> usuario instanceof Cliente)
                          .map(usuario -> (Cliente) usuario)
                          .toList();
         }

         public boolean contem(String login) {
                  return usuarios.containsKey(login);
         }
}
