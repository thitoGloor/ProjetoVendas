package com.vendas.venda.controller.form;
import java.time.LocalDate;

import javax.persistence.Id;

import com.vendas.venda.modelo.Venda;
import com.vendas.venda.modelo.Vendedor;
import com.vendas.venda.repository.VendedorRepository;

public class VendaForm {
	@Id 
	private Integer id;
	private LocalDate dataVenda;
	private double valor;
	private Integer idVendedor;
	
	public Integer getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Venda converter(VendedorRepository vendedorRepository) {
		Vendedor vendedor = vendedorRepository.findById(idVendedor).orElse(null);
		return new Venda(valor, vendedor);
	}
}
