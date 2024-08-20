package services;

import exceptions.PagamentoDuplicadoException;
import java.util.Map;
import models.Cliente;
import models.Pagamento;
import repositories.ClienteRepository;
import repositories.PagamentoRepository;
//VERIFICAR SE O CLIENTE EXISTE APOS CRIAR CLIENTEREPOSITORY
//VERIFICAR SE O CLIENTE EXISTE APOS CRIAR CLIENTEREPOSITORY
//VERIFICAR SE O CLIENTE EXISTE APOS CRIAR CLIENTEREPOSITORY
public class PagamentoServiceImpl implements PagamentoService {

         private PagamentoRepository pagamentoRepository;
         private ClienteRepository clienteRepository;

         public PagamentoServiceImpl(PagamentoRepository pagamentoRepository, ClienteRepository ClienteRepository) {
                  this.pagamentoRepository = pagamentoRepository;
                  this.clienteRepository = ClienteRepository;
         }

         @Override
         public void fazerPagamento(Pagamento pagamento) {
                  if (pagamento.getValor() <= 0) {
                           throw new IllegalArgumentException("O valor do pagamento deve ser positivo.");
                  }
                  if (pagamento.getCliente() == null) {
                           throw new IllegalArgumentException("O pagamento deve estar associado a um cliente.");
                  }
                  pagamentoRepository.salvar(pagamento);
         }

         @Override
         public Map<Long, Pagamento> buscarTodosPagamentos() {
                  return pagamentoRepository.buscarTodos();
         }

         @Override //VERIFICAR SE O CLIENTE EXISTE APOS CRIAR CLIENTEREPOSITORY
         public Map<Long, Pagamento> buscarPagamentosCliente(Cliente cliente) {
                  return pagamentoRepository.buscarPagamentosCliente(cliente);
         }

         @Override
         public Pagamento buscarPagamentoPorId(long id) {
                  if (id <= 0) {
                           throw new IllegalArgumentException("O id deve ser maior que 0.");
                  }
                  return pagamentoRepository.buscarPorId(id);
         }

         @Override
         public void salvarPagamento(Pagamento pagamento) {
                  if (pagamentoRepository.contem(pagamento.getId())) {
                           throw new PagamentoDuplicadoException("Ja existe um pagamento com o id: " + pagamento.getId());
                  }
                  pagamentoRepository.salvar(pagamento);
         }

         @Override
         public void excluirPagamento(long id) {
                  if (pagamentoRepository.contem(id)) {
                           throw new IllegalArgumentException("Nao existe nenhum pagamento com o id: " + id);
                  }
                  pagamentoRepository.excluir(id);
         }
}
