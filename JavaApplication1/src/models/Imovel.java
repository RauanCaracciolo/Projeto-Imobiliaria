package models;

import enums.TipoImovel;


public interface Imovel {
         public String getTitulo();
         public void setTitulo(String titulo);
         public String getDescricao();
         public void setDescricao(String descricao);
         public double getPreco();
         public void setPreco(double preco);
         public TipoImovel getTipoImovel();
         public void setTipoImovel(TipoImovel tipoImovel);
         public Usuario getProprietario();
         public void setProprietario(Usuario usuario);


         //Precisa informar se o Imovel esta disponivel ou não, depois implementar no decorator
}