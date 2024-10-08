package controllers;

import enums.TipoPagamento;
import models.Pagamento;
import services.PagamentoService;
import java.util.Scanner;
import models.Cliente;
//NECESSARIO ATUALIZACOES DEPOIS QUE AS CLASSES CLIENTE FOREM IMPLEMENTADAS
//NECESSARIO ATUALIZACOES DEPOIS QUE AS CLASSES CLIENTE FOREM IMPLEMENTADAS
//NECESSARIO ATUALIZACOES DEPOIS QUE AS CLASSES CLIENTE FOREM IMPLEMENTADAS

//Criacao e Teste da classe PagamentoController
//criado suas variaveis e metodos

public class PagamentoController {

    private final PagamentoService pagamentoService;
    private final Scanner scanner = new Scanner(System.in);

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    public void menu() {
        int opcao = 0;
        while (opcao != 4) {
            System.out.println("----- Menu de Pagamentos -----");
            System.out.println("1. Fazer um pagamento");
            System.out.println("2. Buscar um pagamento");
            System.out.println("3. Excluir um pagamento");
            System.out.println("4. Sair");
            System.out.print("Digite a opção desejada: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    fazerPagamento();
                    break;
                case 2:
                    buscarPagamento();
                    break;
                case 3:
                    excluirPagamento();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        scanner.close();
    }

    public void fazerPagamento() {
        Cliente cliente = new Cliente("", "", "", ""); // CLIENTE TEMPORARIO ANTES DA CRIACAO DAS CLASSES CLIENTE

        System.out.print("Digite o valor do pagamento: ");
        double valor = scanner.nextDouble();

        TipoPagamento tipoPagamento = TipoPagamento.CARTAO;
        int formaPagamento = 0;
        while (formaPagamento < 1 || formaPagamento > 3) {
            System.out.println("Selecione a forma de pagamento: \n1-Cartao\n2-Dinheiro\n3-Pix");
            formaPagamento = scanner.nextInt();
            switch (formaPagamento) {
                case 1:
                    tipoPagamento = TipoPagamento.CARTAO;
                    break;
                case 2:
                    tipoPagamento = TipoPagamento.DINHEIRO;
                    break;
                case 3:
                    tipoPagamento = TipoPagamento.PIX;
                    break;
                default:
                    System.out.println("Valor invalido.");
                    break;
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
