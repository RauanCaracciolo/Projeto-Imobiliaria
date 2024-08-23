package updaters;

import builders.UsuarioBuilder;
import models.Usuario;
import repositories.UsuarioRepository;
//vai ser usado pelo service
public class UsuarioUpdater {
         UsuarioBuilder builder;
         UsuarioRepository repository;
         Usuario usuario;

         public UsuarioUpdater(UsuarioRepository repository, Usuario usuario) {
                  builder = new UsuarioBuilder(usuario);
                  this.repository = repository;
                  this.usuario = usuario;
         }

         public void mudarNome(String novoNome) {
                  Usuario usuarioAtualizado = builder.setNome(novoNome)
                                                                        .build(usuario.getConsultor());
                  
                  repository.excluir(usuario.getLogin());
                  repository.salvar(usuarioAtualizado);
         }

         public void mudarLogin(String novoLogin) {
                  Usuario usuarioAtualizado = builder.setNome(novoLogin)
                                                                        .build(usuario.getConsultor());
                  
                  repository.excluir(usuario.getLogin());
                  repository.salvar(usuarioAtualizado);
         }

         public void mudarSenha(String novaSenha) {
                  Usuario usuarioAtualizado = builder.setNome(novaSenha)
                                                                        .build(usuario.getConsultor());
                  
                  repository.excluir(usuario.getLogin());
                  repository.salvar(usuarioAtualizado);
         }

         public void mudarEmail(String novoEmail) {
                  Usuario usuarioAtualizado = builder.setNome(novoEmail)
                                                                        .build(usuario.getConsultor());
                  
                  repository.excluir(usuario.getLogin());
                  repository.salvar(usuarioAtualizado);
         }
}
