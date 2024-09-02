package services;

import java.util.List;
import models.Imovel;


public interface ImovelService {
         public void salvar(Imovel imovel);
         public void excluir(Imovel imovel);
         public List<Imovel> buscarTodos();
         public List<Imovel> buscarPorProprietario();
         public List<Imovel> buscarPorValorMaior();
         public List<Imovel> buscarPorValorMenor();
}
