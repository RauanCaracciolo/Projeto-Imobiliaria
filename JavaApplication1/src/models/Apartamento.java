package models;

import enums.TipoImovel;
import java.text.NumberFormat;

public class Apartamento implements Imovel {

         private String titulo;
         private String descricao;
         private double preco;
         private TipoImovel tipoImovel;
         private Usuario proprietario;

         public Apartamento(String titulo, String descricao, double preco, TipoImovel tipoImovel, Usuario proprietario) {
                  this.titulo = titulo;
                  this.descricao = descricao;
                  this.preco = preco;
                  this.tipoImovel = tipoImovel;
                  this.proprietario = proprietario;
         }
         

         @Override
         public String getTitulo() {
                  return titulo;
         }

         @Override
         public String getDescricao() {
                  return descricao;
         }

         @Override
         public double getPreco() {
                  return preco;
         }

         @Override
         public TipoImovel getTipoImovel() {
                  return tipoImovel;
         }

         @Override
         public Usuario getProprietario() {
                  return proprietario;
         }

         @Override
         public String toString() {
                  NumberFormat formater = NumberFormat.getNumberInstance();
                  String valorFormatado = formater.format(preco);
                  return "\n\n============================================================================\n" + getTitulo() + "\n----------------------------------------------------------------------------\n" + getDescricao() + "\n\nPreco: R$" + valorFormatado + "\nContato proprietario: " + proprietario.getEmail() + "\n============================================================================\n\n";
         }
}
