package main;

import enums.TipoPagamento;
import factories.UsuarioFactory;
import models.Cliente;
import models.Pagamento;
import models.Usuario;
import repositories.PagamentoRepository;


public class Teste {
         public static void main(String[] args) {
                  Cliente cliente = new Cliente("", "", "", "");
                  
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

                  
                  
                  Usuario user1 = UsuarioFactory.criarUsuario("matheus", "matharuso", "123", "matheus@gmail.com", true);
                  Usuario user2 = UsuarioFactory.criarUsuario("pablo", "pablito", "123", "pablito@gmail.com", false);
                  
                  System.out.println(user1);
                  System.out.println(user2);
         }
}
