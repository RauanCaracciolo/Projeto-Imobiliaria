package main;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        try{
            InetAddress endereco = InetAddress.getByName("191.251.169.32");
            int porta = 12345;

            Socket cliente;
            cliente = new Socket(endereco, porta);


            ObjectOutputStream outputClienteServidor;
            outputClienteServidor = new ObjectOutputStream(cliente.getOutputStream());
            outputClienteServidor.flush();

            ObjectInputStream inputClienteServidor;
            inputClienteServidor = new ObjectInputStream(cliente.getInputStream());

            //Base para ler mensagem recebida
            String mensagem = (String) inputClienteServidor.readObject();
            //Base para enviar mensagem para server
            mensagem = "XXXXX";
            outputClienteServidor.writeObject(mensagem);


        }catch (Exception ex){

        }
    }
}
