package Imoveis;

public abstract class Imovel {
    private String descricao;
    private double valor;
    private double area;
    private int andares;
    private String vendedor;
    private TiposImoveis tipo;
    private boolean validado;

    public Imovel(String descricao, double valor, double area, int andares, String vendedor, TiposImoveis tipo) {
        setDescricao(descricao);
        setValor(valor);
        setArea(area);
        setAndares(andares);
        setVendedor(vendedor);
        setTipo(tipo);
        this.validado = false;
    }

    public boolean isValidado() {
        return validado;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getArea() {
        return area;
    }

    public int getAndares() {
        return andares;
    }

    public double getValor() {
        return valor;
    }

    public String getVendedor() {
        return vendedor;
    }

    public TiposImoveis getTipo() {
        return tipo;
    }

    public void setDescricao(String descricao) {
        if(descricao != "" || descricao != null){
            this.descricao = descricao;
        } else{
            throw new RuntimeException("A descricao precisa ser valida");
        }
    }

    public void setArea(double area) {
        if(area > 0.0){
            this.area = area;
        } else{
            throw new RuntimeException("A area precisa ser maior que 0");
        }
    }

    public void setAndares(int andares) {
        if(andares > 0){
            this.andares = andares;
        } else{
            throw new RuntimeException("Os andares precisam ser maior que 0");
        }
    }

    public void setValor(double valor) {
        if(valor > 0.0){
            this.valor = valor;
        } else{
            throw new RuntimeException("O valor do imovel precisam ser maior que 0");
        }
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public void setTipo(TiposImoveis tipo) {
        this.tipo = tipo;
    }

    public void setValidado() {
        this.validado = true;
    }
}
