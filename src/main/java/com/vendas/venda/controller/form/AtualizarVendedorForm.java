package com.vendas.venda.controller.form;

import com.vendas.venda.modelo.Vendedor;
import com.vendas.venda.repository.VendedorRepository;

public class AtualizarVendedorForm {
	
	private Integer id;
	private String nome;
	private String endereco;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Vendedor atualizar(Integer id, VendedorRepository vendedorRepository) {
		Vendedor vendedor = vendedorRepository.getOne(id);
		vendedor.setNome(this.nome);
		vendedor.setEndereco(this.endereco);					
		return vendedor;
	}
}
