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
                  if (usuario instanceof Cliente) {
                           return (Cliente) usuario;
                  } else if (usuario instanceof Consultor consultor) {
                           return consultor;
                  }
                  
                  throw new LoginInvalidoException("Login invalido");
         }

         public List<Usuario> buscarTodos() {
                  List<Usuario> resultado = new ArrayList<>();
                  for (Usuario u : usuarios.values()) {
                           resultado.add(u);
                  }
                  return resultado;
         }

         public List<Consultor> buscarTodosConsultores() {
                  List<Consultor> resultado = new ArrayList<>();
                  for (Usuario u : usuarios.values()) {
                           if (u instanceof Consultor) {
                                    resultado.add((Consultor) u);
                           }
                  }
                  return resultado;
         }

         public List<Cliente> buscarTodosClientes() {
                  List<Cliente> resultado = new ArrayList<>();
                  for (Usuario u : usuarios.values()) {
                           if (u instanceof Cliente) {
                                    resultado.add((Cliente) u);
                           }
                  }
                  return resultado;
         }

         public boolean contem(String login) {
                  return usuarios.containsKey(login);
         }
}
