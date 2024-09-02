package main;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try{
            int servicos = 5;
            InetAddress endereco = InetAddress.getByName("191.251.169.32");
            int porta = 12345;
            String senhaAdm = "ABCT";
            boolean admLogado = false;

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
            mensagem = "1-Logar como adm\n2-Logar como cliente";
            outputClienteServidor.writeObject(mensagem);
            i = (int) inputClienteServidor.readObject();

            if(i == 1){
                mensagem = "Digite a senha do adm: ";
                outputClienteServidor.writeObject(mensagem);
                mensagem = (String) inputClienteServidor.readObject();
                if(mensagem == senhaAdm){
                    mensagem = "Logado com sucesso!";
                    outputClienteServidor.writeObject(mensagem);
                    admLogado = true;
                }else{
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
