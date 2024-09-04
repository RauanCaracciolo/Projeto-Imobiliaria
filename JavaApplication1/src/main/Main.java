package main;

import Decorator.EventoManager;
import Decorator.Visita;
import enums.TipoImovel;
import models.*;
import proxy.EmailCache;
import proxy.EmailLib;
import proxy.EmailService;
import repositories.ImovelRepository;

import java.util.Scanner;

/*
* Nesta parte do Codigo, foi testado a parte de Sevidor (ADM ou Consultor) e Cliente,
* uma vez que ambos terão contato direto um com o outro.
* Assim como foi dito no Doc. de Requisitos, teriamos 1 (Um) ADM principal, que o mesmo
* iria cadastrar os Consultores (Classe Consultor).
* */

public class Main {
    public static void main(String[] args) {
        try {
            // Variaveis auxiliares
            int opc, i, choose = 0;

            // Repositorio de Imoveis, facilitando na hora de achar o imovel desejado
            ImovelRepository imovel = new ImovelRepository();

            //Decorator
            EventoManager notificacao = new EventoManager();

            // Scanners para ajudar, um para usar na Main inteiro e o outro é destinado para
            // a criação de imoveis
            Scanner scanner = new Scanner(System.in);
            Scanner scannerCasa = new Scanner(System.in);

            // Senha do ADM já pré-definida
            String senhaADM = "ABCT";
            boolean run = true;

            while (run) {
                System.out.println("======================================");
                System.out.println("======= IMOBILIARIA LAR IDEIAL =======");
                System.out.println("======================================\n");

                System.out.println("1-Logar como adm\n2-Logar como cliente");
                i = Integer.parseInt(scanner.nextLine());
                if (i == 1) {
                    System.out.println("Digite a senha do adm: ");
                    if (scanner.nextLine().matches(senhaADM)) {
                        // Ao logar no sistema, o ADM terá livre acesso para fazer o que quiser
                        System.out.println("Logado com sucesso!");

                        // Pequeno painel do que o ADM pode fazer
                        while (choose != -1) {
                            System.out.println("======================================");
                            System.out.println("======= AREA DO ADM/CONSULTOR  =======");
                            System.out.println("======================================\n");

                            System.out.println("1 - Cadastrar Imovel");
                            System.out.println("2 - Remover Imovel");
                            System.out.println("3 - Mostrar Imoveis");
                            System.out.println("4 - Mostrar Visitas");
                            System.out.println("5 - Contatar Consultor");
                            System.out.println("-1 - Sair do Sistema");

                            System.out.println("Digite o que deseja fazer: ");
                            choose = Integer.parseInt(scanner.nextLine());

                            switch (choose) {
                                case 1:

                                    String titulo;
                                    String descricao;
                                    double preco;

                                    Consultor consultor = new Consultor("Luiz", "login", "senha", "email");

                                    System.out.println("=================================");
                                    System.out.println("======= CADASTANDO IMOVEL =======");
                                    System.out.println("=================================");
                                    System.out.println("O imovel é: ");
                                    System.out.println("1- Casa;\n2- Apartamento;");
                                    opc = Integer.parseInt(scanner.nextLine());

                                    if (opc == 1) {
                                        // Ira criar um novo objeto do tipo Casa
                                        System.out.println("Informe o Titulo da casa: ");
                                        titulo = scannerCasa.nextLine();

                                        System.out.println("Informe a Descrição da casa: ");
                                        descricao = scannerCasa.nextLine();

                                        System.out.println("Informe o Preço da casa: ");
                                        preco = Double.parseDouble(scannerCasa.nextLine());

                                        Casa casa = new Casa(titulo, descricao, preco, TipoImovel.CASA, consultor);
                                        System.out.println(casa);
                                        imovel.salvar(casa);

                                    } else if (opc == 2) {
                                        // Ira criar um novo objeto do tipo Apartamento
                                        System.out.println("Informe o Titulo da Apartamento: ");
                                        titulo = scannerCasa.nextLine();

                                        System.out.println("Informe a Descrição da Apartamento: ");
                                        descricao = scannerCasa.nextLine();

                                        System.out.println("Informe o Preço da Apartamento: ");
                                        preco = Double.parseDouble(scannerCasa.nextLine());

                                        Apartamento apartamento = new Apartamento(titulo, descricao, preco, TipoImovel.APARTAMENTO, consultor);
                                        imovel.salvar(apartamento);
                                    } else {
                                        System.out.println("Opção invalida, tente novamente\n");
                                    }
                                    break;
                                case 2:
                                    System.out.println("=================================");
                                    System.out.println("=======   REMOVER IMOVEL  =======");
                                    System.out.println("=================================\n");
                                    break;
                                case 3:
                                    System.out.println("=================================");
                                    System.out.println("=======  MOSTRAR IMOVEIS  =======");
                                    System.out.println("=================================\n");
                                    System.out.println("1 - Mostrar Todos os Imoveis");
                                    System.out.println("2 - Mostrar Imoveis Mais Caros");
                                    System.out.println("3 - Mostrar Imoveis Mais Baratos");
                                    System.out.println("4 - Buscar por Proprietario");
                                    opc = scanner.nextInt();
                                    switch (opc) {
                                        case 1:
                                            System.out.println(imovel.buscarTodos());
                                            scanner.nextLine();
                                            break;
                                        case 2:
                                            System.out.println("Informe o preço que deseja procurar: ");
                                            System.out.println(imovel.buscarPorValorMaior(scanner.nextDouble()));
                                            break;
                                        case 3:
                                            System.out.println("Informe o preço que deseja procurar: ");
                                            System.out.println(imovel.buscarPorValorMenor(scanner.nextDouble()));
                                            break;
                                        case 4:
                                            String nome, email, login, senha;

                                            System.out.println("Informe o Proprietario da casa: ");
                                            System.out.print("Nome ==> ");
                                            nome = scannerCasa.nextLine();

                                            System.out.print("EMAIL ==> ");
                                            email = scannerCasa.nextLine();

                                            System.out.print("Login ==> ");
                                            login = scannerCasa.nextLine();

                                            System.out.print("Senha ==> ");
                                            senha = scannerCasa.nextLine();

                                            System.out.println(
                                                    imovel.buscarPorProprietario(
                                                            new Cliente(nome, login, senha, email)));
                                            break;
                                        default:
                                            System.out.println("precione uma opção existente");
                                    }

                                    break;
                                case 4:
                                    System.out.println("=================================");
                                    System.out.println("======= VISITAS AGENDADAS =======");
                                    System.out.println("=================================\n");
                                    break;
                                case 5:
                                    String email_consultor, mensagem;

                                    System.out.println("=================================");
                                    System.out.println("======= CONTATAR CONSULTOR =======");
                                    System.out.println("=================================\n");

                                    System.out.println("Digite o email do consultor que deseja enviar uma mensagem: ");
                                    email_consultor = scanner.nextLine();
                                    System.out.println("Digite a mensagem que deseja enviar: ");
                                    mensagem = scanner.nextLine();

                                    EmailService servico = new EmailCache(new EmailLib());
                                    Consultor c = new Consultor("d", "ds", "senha", email_consultor);

                                    servico.enviarEmail(mensagem, c);
                                    break;
                                case 0:
                                    System.out.println("Opção invalida, tente novamente");
                                    break;
                                case -1:
                                    System.out.println("SAINDO DO SISTEMA...\n");
                                    scannerCasa.close();// Fecha o fluxo do scanner para criar a casa;
                                    run = false;
                                    break;
                            }
                        }
                    }
                }else if (i == 2 || !scanner.nextLine().matches(senhaADM)){
                    //Caso não seja a senha correta, o sistema ira reconhecer que não é um ADM que está entrando
                    //logo, o mesmo ira entrar no modo de Cliente.
                    System.out.println("Senha incorreta! Entrando no sistema normal");

                    while (choose != -1){
                        System.out.println("======================================");
                        System.out.println("=======    AREA DO CLIENTE     =======");
                        System.out.println("======================================\n");
                        System.out.println("1 - Mostrar Imoveis");
                        System.out.println("2 - Agendar Visitas");
                        System.out.println("3 - Realizar pagamento");
                        System.out.println("-1 - Sair do Sistema");

                        System.out.println("Digite o que deseja fazer: ");
                        choose = scanner.nextInt();

                        if(choose == 1){
                            System.out.println("=================================");
                            System.out.println("=======  MOSTRAR IMOVEIS  =======");
                            System.out.println("=================================\n");
                            System.out.println("1 - Mostrar Todos os Imoveis");
                            System.out.println("2 - Mostrar Imoveis Mais Caros");
                            System.out.println("3 - Mostrar Imoveis Mais Baratos");
                            System.out.println("4 - Buscar por Proprietario");

                            opc = scanner.nextInt();

                            switch (opc){
                                case 1:
                                    System.out.println(imovel.buscarTodos());
                                    break;
                                case 2:
                                    System.out.println("Informe o preço que deseja procurar: ");
                                    System.out.println(imovel.buscarPorValorMaior(scanner.nextDouble()));
                                    break;
                                case 3:
                                    System.out.println("Informe o preço que deseja procurar: ");
                                    System.out.println(imovel.buscarPorValorMenor(scanner.nextDouble()));
                                    break;
                                case 4:
                                    String nome, email, login, senha;

                                    System.out.println("Informe o Proprietario da casa: ");
                                    System.out.print("Nome ==> ");
                                    nome = scannerCasa.nextLine();

                                    System.out.print("EMAIL ==> ");
                                    email = scannerCasa.nextLine();

                                    System.out.print("Login ==> ");
                                    login = scannerCasa.nextLine();

                                    System.out.print("Senha ==> ");
                                    senha = scannerCasa.nextLine();

                                    System.out.println(imovel.buscarPorProprietario(new Cliente(nome,login,senha,email)));
                                    break;
                                default:
                                    System.out.println("precione uma opção existente");
                            }
                        } else if (choose == 2) {
                            System.out.println("=================================");
                            System.out.println("=======  AGENDAR VISITA   =======");
                            System.out.println("=================================\n");

                            System.out.println("1 - Casa\n2 - Apartamento");

                            System.out.println("Informe qual é o imovel que deseja visitar?");

                            if(scanner.nextInt() == 1){

                                String data, nome, email, login, senha;
                                int titulo;
                                Visita v1;

                                System.out.println("Informe o Proprietario da casa: ");
                                System.out.print("Nome ==> ");
                                nome = scannerCasa.nextLine();

                                System.out.print("EMAIL ==> ");
                                email = scannerCasa.nextLine();

                                System.out.print("Login ==> ");
                                login = scannerCasa.nextLine();

                                System.out.print("Senha ==> ");
                                senha = scannerCasa.nextLine();

                                System.out.println("Informe qual é o titulo da Casa que deseja ver");
                                titulo = scanner.nextInt();

                                System.out.println("informe a Data ==> (EX: 04 de Setembro de 2024)");
                                data = scanner.nextLine();

                                v1 = new Visita(data, new Cliente(nome,login,senha,email), imovel.buscarTodos().get(titulo));

                                notificacao.inscrever(v1);

                                System.out.println("Deseja agendar a visita? \n1 - SIM\n 2 - NAO");

                                if(scanner.nextInt() == 1){
                                    notificacao.notificar("VISITA AGENDADA");
                                } else if(scanner.nextInt() == 2){
                                    notificacao.remover(v1);
                                }
                            } else if(scanner.nextInt() == 2){

                                String data, nome, email, login, senha;
                                int titulo;
                                Visita v1;

                                System.out.println("Informe o Proprietario do Aapartamento: ");
                                System.out.print("Nome ==> ");
                                nome = scannerCasa.nextLine();

                                System.out.print("EMAIL ==> ");
                                email = scannerCasa.nextLine();

                                System.out.print("Login ==> ");
                                login = scannerCasa.nextLine();

                                System.out.print("Senha ==> ");
                                senha = scannerCasa.nextLine();

                                System.out.println("Informe qual é o titulo do Aparamento que deseja ver");
                                titulo = scanner.nextInt();

                                System.out.println("informe a Data ==> (EX: 04 de Setembro de 2024)");
                                data = scanner.nextLine();

                                v1 = new Visita(data, new Cliente(nome,login,senha,email), imovel.buscarTodos().get(titulo));

                                notificacao.inscrever(v1);

                                System.out.println("Deseja agendar a visita? \n1 - SIM\n 2 - NAO");

                                if(scanner.nextInt() == 1){
                                    notificacao.notificar("VISITA AGENDADA");
                                } else if(scanner.nextInt() == 2){
                                    notificacao.remover(v1);
                                }
                            } else{
                                System.out.println("Informe qual é o Imovel que deseja Visitar");
                            }
                        } else if (choose == 3) {
                            System.out.println("=================================");
                            System.out.println("======  REALIZAR PAGAMENTO ======");
                            System.out.println("=================================\n");

                            System.out.println("1- Dinheiro\n2- Cartão\n 3- PIX");
                        } else if (choose == -1){
                            System.out.println("Saindo do sistema...");
                        } else{
                            System.out.println("Informe alguma das opcoes ");
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
