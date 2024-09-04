package composite;

import models.Imovel;

public class ImovelLeaf implements CompositeAttributes {

    private Imovel imovel;

    public ImovelLeaf(Imovel im) {
        setImovel(im);
    }

    public void setImovel(Imovel im) {
        imovel = im;
    }

    public Imovel getImovel() {
        return imovel;
    }
}