package factories;

import builders.ImovelBuilder;
import enums.TipoImovel;
import models.Imovel;
import models.Usuario;


public class ImovelFactory {
         public static Imovel novoImovel(String titulo, String descricao, double preco, TipoImovel tipoImovel, Usuario proprietario) {
                  ImovelBuilder builder = new ImovelBuilder();
                  return builder
                          .setTitulo(titulo)
                          .setDescricao(descricao)
                          .setPreco(preco)
                          .setTipoImovel(tipoImovel)
                          .setProprietario(proprietario)
                          .build();
         }
}
