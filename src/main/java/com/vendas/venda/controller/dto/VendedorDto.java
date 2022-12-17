package com.vendas.venda.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.vendas.venda.modelo.Venda;
import com.vendas.venda.modelo.Vendedor;

public class VendedorDto {
	
	private Integer id;
	private String nome;
	private String endereco;
	private List<Venda> vendas = new ArrayList<>();	
	
	public VendedorDto (Vendedor vendedores) {
		this.id = vendedores.getId();
		this.nome = vendedores.getNome();
		this.endereco =vendedores.getEndereco();		
	}	
	
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Venda> getVendas() {
		return vendas;
	}	

	public String getEndereco() {
		return endereco;
	}	

	public static List<VendedorDto> converter(List<Vendedor> vendedores) {		
		return vendedores.stream().map(VendedorDto::new).collect(Collectors.toList());
	}
}
