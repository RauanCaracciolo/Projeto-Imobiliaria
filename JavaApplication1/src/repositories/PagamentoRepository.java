package repositories;

import java.util.HashMap;
import java.util.Map;
import models.Pagamento;


public class PagamentoRepository {
         private Map<Long, Pagamento> pagamentos = new HashMap<>();
         
         public void salvar(Pagamento pagamento) {
                  if(!pagamentos.containsKey(pagamento.getId())) {
                           pagamentos.put(pagamento.getId(), pagamento);
                  }
         }
         
         public void excluir(long id) {
                  if(pagamentos.containsKey(id)) {
                           pagamentos.remove(id);
                  }
         }
         
         public Pagamento buscarPorId(long id) {
                  if(pagamentos.containsKey(id)) {
                           return pagamentos.get(id);
                  }
                  return null;
         }
         
         public Map<Long, Pagamento> buscarTodos() {
                  if(!pagamentos.isEmpty()) {
                           return pagamentos;
                  }
                  return null;
         }
}
