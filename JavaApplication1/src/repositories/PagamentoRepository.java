package repositories;

import java.util.HashMap;
import java.util.Map;
import models.Cliente;
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
                  return pagamentos.get(id);
         }
         
         public Map<Long, Pagamento> buscarTodos() {
                  return pagamentos;
         }
         
         public Map<Long, Pagamento> buscarPagamentosCliente(Cliente cliente) {
                  Map<Long, Pagamento> pagamentosCliente = new HashMap<>();
                  
                  for(Pagamento p : pagamentos.values()) {
                           if(p.getCliente().equals(cliente)) {
                                    pagamentosCliente.put(p.getId(), p);
                           }
                  }
                  
                  return pagamentosCliente;
         }
         
         public boolean contem(long id) {
                  return pagamentos.containsKey(id);
         }
}
