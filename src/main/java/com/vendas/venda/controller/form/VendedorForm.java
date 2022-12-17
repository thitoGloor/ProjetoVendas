package com.vendas.venda.controller.form;

import com.vendas.venda.modelo.Vendedor;
import com.vendas.venda.repository.VendedorRepository;

public class VendedorForm {
	private String nome;
	private String endereco;	

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

	public Vendedor converter(VendedorRepository vendedorRepository) {		
		return new Vendedor(nome, endereco);
	}
}
