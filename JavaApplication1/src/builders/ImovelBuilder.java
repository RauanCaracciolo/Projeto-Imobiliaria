package builders;

import enums.TipoImovel;
import models.Apartamento;
import models.Casa;
import models.Imovel;
import models.Usuario;


public class ImovelBuilder {
         private String titulo;
         private String descricao;
         private double preco;
         private TipoImovel tipoImovel;
         private Usuario proprietario;

         public ImovelBuilder() { }
         
         public ImovelBuilder(Imovel imovel) { //construtor utilizado para atualizar atributos
                  setTitulo(imovel.getTitulo());
                  setDescricao(imovel.getDescricao());
                  setPreco(imovel.getPreco());
                  setProprietario(imovel.getProprietario());
                  setTipoImovel(imovel.getTipoImovel());
         }

         public ImovelBuilder setTitulo(String titulo) {
                  this.titulo = titulo;
                  return this;
         }

         public ImovelBuilder setDescricao(String descricao) {
                  this.descricao = descricao;
                  return this;
         }

         public ImovelBuilder setPreco(double preco) {
                  this.preco = preco;
                  return this;
         }

         public ImovelBuilder setTipoImovel(TipoImovel tipoImovel) {
                  this.tipoImovel = tipoImovel;
                  return this;
         }

         public ImovelBuilder setProprietario(Usuario proprietario) {
                  this.proprietario = proprietario;
                  return this;
         }
         
         
         public Imovel build() {
                  return tipoImovel == TipoImovel.APARTAMENTO ? new Apartamento(titulo, descricao, preco, tipoImovel, proprietario) : new Casa(titulo, descricao, preco, tipoImovel, proprietario);
         }
}
