package main;

import factories.UsuarioFactory;
import models.Usuario;
import repositories.UsuarioRepository;
import updaters.UsuarioUpdater;


public class Teste {
         public static void main(String[] args) {
                  /*
                  PagamentoRepository pr = new PagamentoRepository();
                  PagamentoService ps = new PagamentoServiceImpl(pr, new UsuarioRepository());
                  PagamentoController pc = new PagamentoController(ps);
                  
                  boolean a = true;
                  while(a) {
                           pc.menu();
                           a = false;
                  }
                  
                  Cliente cliente = new Cliente("", "", "", "");
                  
                  Pagamento p1 = new Pagamento(cliente, 10.0, TipoPagamento.CARTAO);
                  Pagamento p2 = new Pagamento(cliente, 20.0, TipoPagamento.DINHEIRO);
                  Pagamento p3 = new Pagamento(cliente, 30.0, TipoPagamento.PIX);
                  
                  //System.out.println(p1);
                  
                  
                  
                  pr.salvar(p1);
                  pr.salvar(p2);
                  pr.salvar(p3);
                  
                  pr.excluir(p2.getId());
                  
                  System.out.println(pr.buscarPorId(1));
                  
                  System.out.println(pr.buscarTodos());

                  
                  
                  Usuario user1 = UsuarioFactory.criarUsuario("Matheus", "matharuso", "123", "matheus@gmail.com", true);
                  Usuario user2 = UsuarioFactory.criarUsuario("Pablo", "pablito", "123", "pablito@gmail.com", false);
                  
                  System.out.println(user1);
                  System.out.println(user2);
                  
                  Imovel imovel1 = ImovelFactory.novoImovel("Casa centro da cidade", "Casa com 2 quartos, 1 banheiro e piscina", 20000000, TipoImovel.CASA, user1);
                  Imovel imovel2 = ImovelFactory.novoImovel("Triplex condominio Atlas", "Triplex com 3 suites, 2 banheiros, terraco e vista pra praia", 15000000.99, TipoImovel.APARTAMENTO, user2);
                  
                  System.out.println(imovel1);
                  System.out.println(imovel2);
                  */
                  
                  Usuario user1 = UsuarioFactory.criarUsuario("Matheus", "matharuso", "123", "matheus@gmail.com", true);
                  Usuario user2 = UsuarioFactory.criarUsuario("Pablo", "pablito1", "123", "pablito@gmail.com", false);
                  Usuario user3 = UsuarioFactory.criarUsuario("Marcelo", "pablito2", "123", "pablito@gmail.com", false);
                  Usuario user4 = UsuarioFactory.criarUsuario("Hugo", "pablito3", "123", "pablito@gmail.com", false);
                  Usuario user5 = UsuarioFactory.criarUsuario("Thiago", "pablito4", "123", "pablito@gmail.com", false);
                  
                  UsuarioRepository ur = new UsuarioRepository();
                  ur.salvar(user1);
                  ur.salvar(user2);
                  ur.salvar(user3);
                  ur.salvar(user4);
                  ur.salvar(user5);
                  
                  
                  System.out.println(ur.buscarTodos());
                  
                  UsuarioUpdater usuarioUpdater = new UsuarioUpdater(ur, user5);
                  usuarioUpdater.mudarNome("afonso");
                  
                  System.out.println(ur.buscarTodos());
         }
}