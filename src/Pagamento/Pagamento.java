package Pagamento;

public class Pagamento {

    private double valor;
    private TiposPagamento tipo;

    public Pagamento(double valor, TiposPagamento tipo) {
        setTipo(tipo);
        setValor(valor);
    }

    public double getValor() {
        return valor;
    }

    public TiposPagamento getTipo() {
        return tipo;
    }

    public void setValor(double valor) {
        if(valor > 0.0){
            this.valor = valor;
        } else{
            throw  new RuntimeException("O valor precisa ser maior que R$ 0,00");
        }
    }

    public void setTipo(TiposPagamento tipo) {
        this.tipo = tipo;
    }
}
