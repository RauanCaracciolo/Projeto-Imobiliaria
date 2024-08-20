package main;

import enums.TipoPagamento;
import models.Cliente;
import models.Pagamento;
import repositories.PagamentoRepository;


public class Teste {
         public static void main(String[] args) {
                  Cliente cliente = new Cliente();
                  
                  Pagamento p1 = new Pagamento(cliente, 10.0, TipoPagamento.CARTAO);
                  Pagamento p2 = new Pagamento(cliente, 20.0, TipoPagamento.DINHEIRO);
                  Pagamento p3 = new Pagamento(cliente, 30.0, TipoPagamento.PIX);
                  
                  //System.out.println(p1);
                  
                  PagamentoRepository pr = new PagamentoRepository();
                  
                  pr.salvar(p1);
                  pr.salvar(p2);
                  pr.salvar(p3);
                  
                  pr.excluir(p2.getId());
                  
                  System.out.println(pr.buscarPorId(1));
                  
                  System.out.println(pr.buscarTodos());
         }
}
