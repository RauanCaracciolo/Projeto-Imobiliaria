package services;

import java.util.Map;
import models.Cliente;
import models.Pagamento;

public interface PagamentoService {
         public void fazerPagamento(Pagamento pagamento);
         public Map<Long, Pagamento> buscarTodosPagamentos();
         public Map<Long, Pagamento> buscarPagamentosCliente(Cliente cliente);
         public Pagamento buscarPagamentoPorId(long id);
         public void salvarPagamento(Pagamento pagamento);
         public void excluirPagamento(long id);
}
