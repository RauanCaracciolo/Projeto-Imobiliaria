package Usuarios;

public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    private String CEP;
    private int numero;

    public Endereco(String rua, String bairro, String cidade, String CEP, int numero){
        setRua(rua);
        setBairro(bairro);
        setCidade(cidade);
        setCEP(CEP);
        setNumero(numero);
    }
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
