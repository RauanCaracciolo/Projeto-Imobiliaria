package Usuarios;

public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    private long CEP;
    private int numero;

    public Endereco(String rua, String bairro, String cidade, long CEP, int numero){
        setRua(rua);
        setBairro(bairro);
        setCidade(cidade);
        setCEP(CEP);
        setNumero(numero);
    }
    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public long getCEP() {
        return CEP;
    }

    public int getNumero() {
        return numero;
    }

    public void setRua(String rua) {
        if(rua != "" || rua != null){
            this.rua = rua;
        }else{
            throw new RuntimeException("A rua precisa ser uma rua valida");
        }
    }

    public void setBairro(String bairro) {
        if(bairro != "" || bairro != null){
            this.bairro = bairro;
        }else{
            throw new RuntimeException("O bairro precisa ser um bairro valido");
        }
    }

    public void setCidade(String cidade) {
        if(cidade != "" || cidade != null){
            this.cidade = cidade;
        }else{
            throw new RuntimeException("A cidade precisa ser uma cidade valido");
        }
    }

    public void setCEP(long CEP) {
        if(CEP > 0){
            this.CEP = CEP;
        } else{
            throw new RuntimeException("O CEP precisa ser um numero valido");
        }
    }

    public void setNumero(int numero) {
        if(numero > 0){
            this.numero = numero;
        } else{
            throw new RuntimeException("O Numero da casa precisa ser maior que 0 e precisa ser um numero real");
        }
    }
}
