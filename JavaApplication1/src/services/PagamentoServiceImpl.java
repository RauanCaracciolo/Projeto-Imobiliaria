package services;

import java.util.List;
import models.Cliente;
import models.Pagamento;
import repositories.ClienteRepository;
import repositories.PagamentoRepository;


public class PagamentoServiceImpl implements PagamentoService{
         private PagamentoRepository pagamentoRepository;
         private ClienteRepository clienteRepository;

         public PagamentoServiceImpl(PagamentoRepository pagamentoRepository, ClienteRepository ClienteRepository) {
                  this.pagamentoRepository = pagamentoRepository;
                  this.clienteRepository = ClienteRepository;
         }

         @Override
         public void fazerPagamento(Pagamento pagamento) {
                  if(pagamento.getValor() > 0) {
                           pagamentoRepository.salvar(pagamento);
                  }
         }

         @Override
         public List<Pagamento> buscarTodosPagamentos() {
         
                  return null;
         
         }

         @Override
         public List<Pagamento> buscarPagamentosCliente(Cliente cliente) {
         
                  return null;
         
         }

         @Override
         public Pagamento buscarPagamentoPorId(long id) {
         
                  return null;
         
         }

         @Override
         public void salvarPagamento(Pagamento pagamento) {
         
         }

         @Override
         public void excluirPagamento(Pagamento pagamento) {
         
         }
}
