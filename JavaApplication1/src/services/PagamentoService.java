package services;

import java.util.List;
import models.Cliente;
import models.Pagamento;

public interface PagamentoService {
         public void fazerPagamento(Pagamento pagamento);
         public List<Pagamento> buscarTodosPagamentos();
         public List<Pagamento> buscarPagamentosCliente(Cliente cliente);
         public Pagamento buscarPagamentoPorId(long id);
         public void salvarPagamento(Pagamento pagamento);
         public void excluirPagamento(Pagamento pagamento);
}
