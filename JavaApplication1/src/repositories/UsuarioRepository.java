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
                        return usuario;
                } else if (usuario instanceof Consultor) {
                        return usuario;
                }

                throw new LoginInvalidoException("Login invalido");
        }

        public List<Usuario> buscarTodos() {
                List<Usuario> result = new ArrayList<>();

                usuarios.values().stream().forEach(i -> result.add(i));

                return result;
        }

        public List<Consultor> buscarTodosConsultores() {
                List<Consultor> result = new ArrayList<>();

                usuarios.values().stream()
                                .filter(usuario -> usuario instanceof Consultor)
                                .map(usuario -> (Consultor) usuario)
                                .forEach(i -> result.add(i));

                return result;
        }

        public List<Cliente> buscarTodosClientes() {
                List<Cliente> result = new ArrayList<>();

                usuarios.values().stream()
                                .filter(usuario -> usuario instanceof Cliente)
                                .map(usuario -> (Cliente) usuario)
                                .forEach(i -> result.add(i));

                return result;
        }

        public boolean contem(String login) {
                return usuarios.containsKey(login);
        }
}
