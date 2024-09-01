package updaters;

import builders.UsuarioBuilder;
import models.Usuario;
import repositories.UsuarioRepository;

public class UsuarioUpdater {

         private UsuarioRepository repository;

         public UsuarioUpdater(UsuarioRepository repository) {
                  this.repository = repository;
         }

         public void mudarNome(Usuario usuario, String novoNome) {
                  UsuarioBuilder builder = new UsuarioBuilder(usuario);
                  Usuario usuarioAtualizado = builder.setNome(novoNome)
                          .build(usuario.getConsultor());
                  
                  repository.atualizar(usuario, usuarioAtualizado);
         }

         public void mudarLogin(Usuario usuario, String novoLogin) {
                  UsuarioBuilder builder = new UsuarioBuilder(usuario);
                  Usuario usuarioAtualizado = builder.setLogin(novoLogin)
                          .build(usuario.getConsultor());

                  repository.atualizar(usuario, usuarioAtualizado);
         }

         public void mudarSenha(Usuario usuario, String novaSenha) {
                  UsuarioBuilder builder = new UsuarioBuilder(usuario);
                  Usuario usuarioAtualizado = builder.setSenha(novaSenha)
                          .build(usuario.getConsultor());

                  repository.atualizar(usuario, usuarioAtualizado);
         }

         public void mudarEmail(Usuario usuario, String novoEmail) {
                  UsuarioBuilder builder = new UsuarioBuilder(usuario);
                  Usuario usuarioAtualizado = builder.setEmail(novoEmail)
                          .build(usuario.getConsultor());

                  repository.atualizar(usuario, usuarioAtualizado);
         }
}
