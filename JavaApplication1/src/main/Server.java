package main;

import enums.TipoImovel;
import models.Apartamento;
import models.Casa;
import models.Cliente;
import models.Usuario;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/*
* Nesta parte do Codigo, foi testado a parte de Sevidor (ADM ou Consultor) e Cliente,
* uma vez que ambos terão contato direto um com o outro.
* Assim como foi dito no Doc. de Requisitos, teriamos 1 (Um) ADM principal, que o mesmo
* iria cadastrar os Consultores (Classe Consultor).
* */

public class Server {
    public static void main(String[] args) {
        try{
            //Senha do ADM é sempre a mesma, é uma senha já determinada
            int servicos = 5;
            InetAddress endereco = InetAddress.getByName("191.251.169.32");
            int porta = 12345;
            String senhaAdm = "ABCT";
            boolean admLogado = false;

            int chose = 0;
            Scanner scanner = new Scanner(System.in);
            Scanner scannerCasa = new Scanner(System.in);

            ServerSocket servidor;
            servidor = new ServerSocket(porta, servicos, endereco);

            Socket conexao;
            conexao = servidor.accept();

            ObjectOutputStream outputClienteServidor;
            outputClienteServidor = new ObjectOutputStream(conexao.getOutputStream());
            outputClienteServidor.flush();

            ObjectInputStream inputClienteServidor;
            inputClienteServidor = new ObjectInputStream(conexao.getInputStream());
            int i;

            String mensagem;
            mensagem = "1-Logar como adm\n2-Logar como cliente\n";
            outputClienteServidor.writeObject(mensagem);
            i = (int) inputClienteServidor.readObject();

            if(i == 1){
                mensagem = "Digite a senha do adm: ";
                outputClienteServidor.writeObject(mensagem);
                mensagem = (String) inputClienteServidor.readObject();
                if(senhaAdm.matches(mensagem)){
                    //Ao logar no sistema, o ADM terá livre acesso para fazer o que quiser
                    mensagem = "Logado com sucesso!\n\n";
                    outputClienteServidor.writeObject(mensagem);
                    admLogado = true;

                    //Pequeno painel do que o ADM pode fazer
                    while (chose != -1){
                        System.out.println("1 - Cadastrar Imovel\n");
                        System.out.println("2 - Remover Imovel\n");
                        System.out.println("3 - Mostrar Imoveis\n");
                        System.out.println("4 - Mostrar Visitas\n");
                        System.out.println("-1 - Sair do Sistema\n");

                        System.out.println("Digite o que deseja fazer: \n");
                        chose = scanner.nextInt();

                        switch (chose){
                            case 1:
                                int opc;

                                String titulo;
                                String descricao;
                                double preco;
                                Usuario proprietario = new Cliente("Luiz", "login", "senha", "email");
                                //Teste #1

                                System.out.println("=================================\n");
                                System.out.println("======= CADASTANDO IMOVEL =======\n");
                                System.out.println("=================================\n\n");
                                System.out.println("O imovel é:\n");
                                System.out.println("1- Casa;\n2- Apartamento;\n");
                                opc = scanner.nextInt();

                                if(opc == 1){
                                    //Ira criar um novo objeto do tipo Casa
                                    System.out.println("Informe o Titulo da casa: ");
                                    titulo = scannerCasa.nextLine();

                                    System.out.println("Informe a Descrição da casa: ");
                                    descricao = scannerCasa.nextLine();

                                    System.out.println("Informe o Preço da casa: ");
                                    preco = scannerCasa.nextDouble();

                                    System.out.println("Informe o Proprietario da casa: ");
                                    //proprietario = scannerCasa.nextLine();
                                    Casa casa = new Casa(titulo, descricao, preco, TipoImovel.CASA, proprietario);

                                } else if (opc == 2){
                                    //Ira criar um novo objeto do tipo Apartamento
                                    System.out.println("Informe o Titulo da Apartamento: ");
                                    titulo = scannerCasa.nextLine();

                                    System.out.println("Informe a Descrição da Apartamento: ");
                                    descricao = scannerCasa.nextLine();

                                    System.out.println("Informe o Preço da Apartamento: ");
                                    preco = scannerCasa.nextDouble();

                                    System.out.println("Informe o Proprietario da Apartamento: ");
                                    //proprietario = scannerCasa.nextLine();
                                    Apartamento apartamento = new Apartamento(titulo, descricao, preco, TipoImovel.APARTAMENTO, proprietario);
                                } else{
                                    System.out.println("Opção invalida, tente novamente\n\n");
                                }
                                break;
                            case 2:
                                System.out.println("=================================\n");
                                System.out.println("=======   REMOVER IMOVEL  =======\n");
                                System.out.println("=================================\n\n");
                                break;
                            case 3:
                                System.out.println("=================================\n");
                                System.out.println("=======  MOSTRAR IMOVEIS  =======\n");
                                System.out.println("=================================\n\n");
                                break;
                            case 4:
                                System.out.println("=================================\n");
                                System.out.println("======= VISITAS AGENDADAS =======\n");
                                System.out.println("=================================\n\n");
                                break;
                            case 0:
                                System.out.println("Opção invalida, tente novamente");
                                break;
                            case -1:
                                System.out.println("SAINDO DO SISTEMA...\n");
                                System.out.println("");
                                scannerCasa.close();//Fecha o fluxo do scanner para criar a casa;
                                break;
                        }

                    }
                }else{
                    //Caso não seja a senha correta, o sistema ira reconhecer que não é um ADM que está entrando
                    //logo, o mesmo ira entrar no modo de Cliente.
                    mensagem = "Senha incorreta! Entrando no sistema normal";
                    outputClienteServidor.writeObject(mensagem);
                }
            } else if (i == 2){

            }

            while(i != 0){
                System.out.println("O -");
            }

            outputClienteServidor.close();
            inputClienteServidor.close();
            servidor.close();

        }catch (Exception ex){

        }
    }
}
