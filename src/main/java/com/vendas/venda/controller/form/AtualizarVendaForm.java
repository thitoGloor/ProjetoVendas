package com.vendas.venda.controller.form;

import java.time.LocalDate;


import com.vendas.venda.modelo.Venda;
import com.vendas.venda.repository.VendaRepository;

public class AtualizarVendaForm {
	
		private LocalDate dataVenda;		
		private double valor;		
		
		public LocalDate getDataVenda() {
			return dataVenda;
		}
		public void setDataVenda(LocalDate dataVenda) {
			this.dataVenda = dataVenda;
		}
		public double getValor() {
			return valor;
		}
		public void setValor(double valor) {
			this.valor = valor;
		}
		
		public Venda atualizar(Integer id, VendaRepository vendaRepository) {
			Venda venda = vendaRepository.getOne(id);
			venda.setDataVenda(this.dataVenda);
			venda.setValor(this.valor);			
						
			return venda;
		}
		
}
