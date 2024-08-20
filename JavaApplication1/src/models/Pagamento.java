package models;

import enums.TipoPagamento;
import exceptions.InvalidPagamentoException;


public class Pagamento {
         private static long contador = 1;
         private double valor;
         private TipoPagamento tipoPagamento;
         private long id;
         private Cliente cliente;

         public Pagamento(Cliente cliente, double valor, TipoPagamento tipoPagamento) {
                  setCliente(cliente);
                  setValor(valor);
                  setTipoPagamento(tipoPagamento);
                  id = contador++;
         }

         public double getValor() {
                  return valor;
         }

         public void setValor(double valor) {
                  if(valor > 0) {
                           this.valor = valor;
                  } else {
                           throw new IllegalArgumentException();
                  }
         }

         public TipoPagamento getTipoPagamento() {
                  return tipoPagamento;
         }

         public void setTipoPagamento(TipoPagamento tipoPagamento) {
                  if(TipoPagamento.contem(tipoPagamento)) {
                           this.tipoPagamento = tipoPagamento;
                  } else {
                           throw new InvalidPagamentoException("O tipo de pagamento é invalido.");
                  }
         }

         public long getId() {
                  return id;
         }

         public Cliente getCliente() {
                  return cliente;
         }

         public void setCliente(Cliente cliente) {
                  this.cliente = cliente;
         }
         
         
         
         @Override
         public String toString() {
                  return "Tipo de pagamento: " + getTipoPagamento() + ", Valor: R$" + getValor() + ", Id: " + getId();
         }
}
