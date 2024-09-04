package composite;

import models.Imovel;
import java.util.ArrayList;

public class Composite implements CompositeAttributes {
    private ArrayList<ImovelLeaf> il;

    public Composite() {
        il = new ArrayList<>();
    }

    public ArrayList<ImovelLeaf> getImovel() {
        return il;
    }
}