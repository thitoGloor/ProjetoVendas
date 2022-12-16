package com.vendas.venda.controller.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.vendas.venda.modelo.Venda;
import com.vendas.venda.modelo.Vendedor;


public class VendaDto {
	private Integer id;
	private LocalDate dataVenda;
	private double valor;
	private String nomeVendedor;
	private String enderecoVendedor;
	
	public VendaDto(Venda venda) {		
		this.id = venda.getId();
		this.dataVenda = venda.getDataVenda();
		this.valor = venda.getValor();
		this.nomeVendedor = venda.getVendedor().getNome();
		this.enderecoVendedor = venda.getVendedor().getEndereco();
	}

	public String getEnderecoVendedor() {
		return enderecoVendedor;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	public Integer getId() {
		return id;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public double getValor() {
		return valor;
	}

	public static List<VendaDto> converter(List<Venda> vendas) {
		// TODO Auto-generated method stub
		return vendas.stream().map(VendaDto::new).collect(Collectors.toList());
	}
}
