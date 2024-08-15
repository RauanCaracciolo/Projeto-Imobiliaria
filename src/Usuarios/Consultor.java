package Usuarios;

import Imoveis.Imovel;

public class Consultor extends Usuario{

    private double salario;
    public Consultor(String login, String nome, String senha, String email, Endereco endereco, double salario) {
        super(login, nome, senha, email, endereco);
        setSalario(salario);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if(salario > 0.0){
            this.salario = salario;
        } else{
            throw new RuntimeException("O salario precisa ser maio que 0");
        }
    }
    public void cadastraImovel(){}
    public void validaImovel(Imovel i){
        i.setValidado();
    }
}
