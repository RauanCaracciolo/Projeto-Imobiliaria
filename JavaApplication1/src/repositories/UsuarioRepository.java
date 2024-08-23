package repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.Usuario;

public class UsuarioRepository {

         //map<login, usuario>
         private Map<String, Usuario> usuarios = new HashMap<>();

         public void salvar(Usuario usuario) {
                  usuarios.put(usuario.getLogin(), usuario);
         }

         public void excluir(String login) {
                  usuarios.remove(login);
         }
         
         public Usuario buscarPorLogin(String login) {
                  return usuarios.get(login);
         }
         
         public List<Usuario> buscarTodos() {
                  List<Usuario> resultado = new ArrayList<>();
                  
                  for(Usuario u : usuarios.values()) {
                           resultado.add(u);
                  }
                  
                  return resultado;
         }
         
         public boolean contem(String login) {
                  return usuarios.containsKey(login);
         }
}
