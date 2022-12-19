package com.vendas.venda.controller.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.vendas.venda.modelo.Vendedor;

public class VendedorDto {	
	private Integer id;
	private String nome;
	private String endereco;
	private int quantidadeVendas;
	
	public VendedorDto (Vendedor vendedores) {
		this.id = vendedores.getId();
		this.nome = vendedores.getNome();
		this.endereco = vendedores.getEndereco();
		this.quantidadeVendas = vendedores.getVendas().size();
	}	
	
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}	

	public int getQuantidadeVendas() {
		return quantidadeVendas;
	}

	public String getEndereco() {
		return endereco;
	}	

	public static List<VendedorDto> converter(List<Vendedor> vendedores) {
		
		return vendedores.stream().map(VendedorDto::new).collect(Collectors.toList());
	}
}
