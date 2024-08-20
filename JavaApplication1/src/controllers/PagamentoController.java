package controllers;

import enums.TipoPagamento;
import models.Pagamento;
import services.PagamentoService;
import java.util.Scanner;
import models.Cliente;
//NECESSARIO ATUALIZACOES DEPOIS QUE AS CLASSES CLIENTE FOREM IMPLEMENTADAS
//NECESSARIO ATUALIZACOES DEPOIS QUE AS CLASSES CLIENTE FOREM IMPLEMENTADAS
//NECESSARIO ATUALIZACOES DEPOIS QUE AS CLASSES CLIENTE FOREM IMPLEMENTADAS

public class PagamentoController {

         private final PagamentoService pagamentoService;
         private final Scanner scanner = new Scanner(System.in);

         public PagamentoController(PagamentoService pagamentoService) {
                  this.pagamentoService = pagamentoService;
         }

         public void menu() {
                  System.out.println("----- Menu de Pagamentos -----");
                  System.out.println("1. Fazer um pagamento");
                  System.out.println("2. Buscar um pagamento");
                  System.out.println("3. Excluir um pagamento");
                  System.out.println("4. Sair");
                  System.out.print("Digite a opção desejada: ");

                  int opcao = scanner.nextInt();

                  switch (opcao) {
                           case 1 -> fazerPagamento();
                           case 2 -> buscarPagamento();
                           case 3 -> excluirPagamento();
                           case 4 -> System.out.println("Saindo...");
                           default -> System.out.println("Opção inválida!");
                  }
         }

         public void fazerPagamento() {
                  Cliente cliente = new Cliente(); //CLIENTE TEMPORARIO ANTES DA CRIACAO DAS CLASSES CLIENTE

                  System.out.print("Digite o valor do pagamento: ");
                  double valor = scanner.nextDouble();

                  TipoPagamento tipoPagamento = null;
                  int formaPagamento = 0;
                  while (formaPagamento < 1 && formaPagamento > 3) {
                           System.out.println("Selecione a forma de pagamento: \n1-Cartao\n2-Dinheiro\n3-Pix");
                           switch (formaPagamento) {
                                    case 1 -> tipoPagamento = TipoPagamento.CARTAO;
                                    case 2 -> tipoPagamento = TipoPagamento.DINHEIRO;
                                    case 3 -> tipoPagamento = TipoPagamento.PIX;
                                    default -> System.out.println("Valor invalido.");
                           }
                  }

                  Pagamento pagamento = new Pagamento(cliente, valor, tipoPagamento);
                  pagamentoService.fazerPagamento(pagamento);
                  System.out.println("Pagamento realizado com sucesso!");
         }

         public void buscarPagamento() {
                  System.out.print("Digite o ID do pagamento: ");
                  long id = scanner.nextLong();

                  Pagamento pagamento = pagamentoService.buscarPagamentoPorId(id);
                  if (pagamento != null) {
                           System.out.println(pagamento);
                  } else {
                           System.out.println("Pagamento não encontrado.");
                  }
         }

         public void excluirPagamento() {
                  System.out.print("Digite o ID do pagamento a ser excluído: ");
                  long id = scanner.nextLong();

                  pagamentoService.excluirPagamento(id);
                  System.out.println("Pagamento excluído com sucesso!");
         }
}
