package repositories;

import java.util.Comparator;
import java.util.List;

import Iterator.Iterator;
import models.Imovel;
import models.Usuario;

/*
Nesta classe, foi criado um repositorio de imoveis, foi utilizado List, uma vez que com a mesma, e possivel navegar por ela
e localizar algum objeto da classe Imoveis, com maior facilidade
 */
public class ImovelRepository implements Iterator {
    int i = -1;

    private List<Imovel> imoveis;

    //Adiciona o imovel, caso não esteja adicionado já
    public void salvar(Imovel imovel) {
        if (!imoveis.contains(imovel)) {
            imoveis.add(imovel);
        } else{
            throw new RuntimeException("Imovel já existente");
        }
    }

    //Exclui o Imovel, caso esteja dentro da Lista
    public void excluir(Imovel imovel) {
        if (imoveis.contains(imovel)) {
            imoveis.remove(imovel);
        } else {
            throw new RuntimeException("Não existe este imovel");
        }
    }

    //Atualiza as informações do imovel
    //OBS: Apaga o anterior, já existente e adiciona um novo (Atualizado)
    public void atualizar(Imovel imovel, Imovel imovelAtualizado) {
        excluir(imovel);
        salvar(imovelAtualizado);
    }

    //Retorna TODOS os imoveis cadastrados
    public List<Imovel> buscarTodos() {
                  return imoveis;
         }
         //Buscar pelo Proprietario
         public List<Imovel> buscarPorProprietario(Usuario usuario) {
            return imoveis.stream()
                    .filter(imovel -> imovel.getProprietario()
                            .equals(usuario))
                            .toList();
         }

         //Busca pelos imoveis com preço maior que o passado como argumento
         public List<Imovel> buscarPorValorMaior(double valor) {
                  return imoveis.stream()
                          .filter(imovel -> imovel.getPreco() >= valor)
                          .sorted(Comparator.comparingDouble(Imovel::getPreco))
                          .toList();
         }

         //Busca pelos imoveis com preço menor que o passado como argumento
         public List<Imovel> buscarPorValorMenor(double valor) {
                  return imoveis.stream()
                          .filter(imovel -> imovel.getPreco() <= valor)
                          .sorted(Comparator.comparingDouble(Imovel::getPreco))
                          .toList();
         }

         //Acredito que não seja nescessario esta funcao
         //public boolean contem(Imovel imovel) {
                  //return imoveis.contains(imovel);
         //}

        @Override
        public boolean hasNext() {
            return i + 1 < imoveis.size();
        }

        @Override
        public Object next() {
            if (hasNext()) {
                i++;
                return imoveis.get(i);
            }
            throw new RuntimeException("Não há mais elementos.");
        }


    //Na Main:
        /*
        // Criando o repositório
            ImovelRepository repository = new ImovelRepository();
        *
        // Usando o iterador
            Iterator imovelIterator = repository;

            while (imovelIterator.hasNext()) {
            Imovel imovel = (Imovel) imovelIterator.next();
            System.out.println(imovel);
        }
        */
}
