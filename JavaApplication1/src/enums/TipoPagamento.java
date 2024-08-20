package enums;


public enum TipoPagamento {
         CARTAO("Cartão"), DINHEIRO("Dinheiro"), PIX("Pix");
         
         private final String descricao;

         private TipoPagamento(String descricao) {
                  this.descricao = descricao;
         }
         
         public static boolean contem(TipoPagamento tipoPagamento) {
                  for(TipoPagamento tp : TipoPagamento.values()) {
                           if(tp == tipoPagamento) return true;
                  }
                  return false;
         }
         
         @Override
         public String toString() {
                  return descricao;
         }
}
