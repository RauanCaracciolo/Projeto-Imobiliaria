package repositories;

import java.util.Comparator;
import java.util.List;
import models.Imovel;
import models.Usuario;

public class ImovelRepository {

         private List<Imovel> imoveis;

         public void salvar(Imovel imovel) {
                  if (!imoveis.contains(imovel)) {
                           imoveis.add(imovel);
                  }
         }

         public void excluir(Imovel imovel) {
                  if (imoveis.contains(imovel)) {
                           imoveis.remove(imovel);
                  }
         }

         public void atualizar(Imovel imovel, Imovel imovelAtualizado) {
                  excluir(imovel);
                  salvar(imovelAtualizado);
         }

         public List<Imovel> buscarTodos() {
                  return imoveis;
         }

         public List<Imovel> buscarPorProprietario(Usuario usuario) {
                  return imoveis.stream()
                          .filter(imovel -> imovel.getProprietario()
                          .equals(usuario))
                          .toList();
         }
         
         public List<Imovel> buscarPorValorMaior(double valor) {
                  return imoveis.stream()
                          .filter(imovel -> imovel.getPreco() >= valor)
                          .sorted(Comparator.comparingDouble(Imovel::getPreco))
                          .toList();
         }
         
         public List<Imovel> buscarPorValorMenor(double valor) {
                  return imoveis.stream()
                          .filter(imovel -> imovel.getPreco() <= valor)
                          .sorted(Comparator.comparingDouble(Imovel::getPreco))
                          .toList();
         }
         
         public boolean contem(Imovel imovel) {
                  return imoveis.contains(imovel);
         }
}
