package Imoveis;

public class Casa extends Imovel{

    public Casa(String descricao, double valor, double area, int andares, String vendedor) {
        super(descricao, valor, area, andares, vendedor, TiposImoveis.CASA);
    }
}
