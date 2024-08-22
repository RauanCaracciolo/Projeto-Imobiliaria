package models;

import enums.TipoImovel;


public interface Imovel {
         public String getTitulo();
         public String getDescricao();
         public double getPreco();
         public TipoImovel getTipoImovel();
         public Usuario getProprietario();
}