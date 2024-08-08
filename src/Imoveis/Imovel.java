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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getAndares() {
        return andares;
    }

    public void setAndares(int andares) {
        this.andares = andares;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public TiposImoveis getTipo() {
        return tipo;
    }

    public void setTipo(TiposImoveis tipo) {
        this.tipo = tipo;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado() {
        this.validado = true;
    }
}
