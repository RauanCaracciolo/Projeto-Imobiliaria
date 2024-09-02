package updaters;

import builders.ImovelBuilder;
import enums.TipoImovel;
import models.Imovel;
import models.Usuario;
import repositories.ImovelRepository;

public class ImovelUpdater {

         private ImovelRepository repository;

         public ImovelUpdater(ImovelRepository repository) {
                  this.repository = repository;
         }
         
         public void mudarTitulo(Imovel imovel, String novoTitulo) {
                  ImovelBuilder builder = new ImovelBuilder(imovel);
                  Imovel imovelAtualizado = builder.setTitulo(novoTitulo)
                          .build();
                  
                  repository.atualizar(imovel, imovelAtualizado);        
         }
         
         public void mudarDescricao(Imovel imovel, String novaDescricao) {
                  ImovelBuilder builder = new ImovelBuilder(imovel);
                  Imovel imovelAtualizado = builder.setDescricao(novaDescricao)
                          .build();
                  
                  repository.atualizar(imovel, imovelAtualizado);        
         }
         
         public void mudarPreco(Imovel imovel, double preco) {
                  ImovelBuilder builder = new ImovelBuilder(imovel);
                  Imovel imovelAtualizado = builder.setPreco(preco)
                          .build();
                  
                  repository.atualizar(imovel, imovelAtualizado);        
         }
         
         public void mudarTipoImovel(Imovel imovel, TipoImovel tipoImovel) {
                  ImovelBuilder builder = new ImovelBuilder(imovel);
                  Imovel imovelAtualizado = builder.setTipoImovel(tipoImovel)
                          .build();
                  
                  repository.atualizar(imovel, imovelAtualizado);        
         }
         
         public void mudarProprietario(Imovel imovel, Usuario proprietario) {
                  ImovelBuilder builder = new ImovelBuilder(imovel);
                  Imovel imovelAtualizado = builder.setProprietario(proprietario)
                          .build();
                  
                  repository.atualizar(imovel, imovelAtualizado);        
         }
}
