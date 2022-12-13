package com.vendas.venda.modelo;

import java.util.Objects;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Vendedores {
	private Integer id;
	private String nome;
	private String endereco;	
	
	@Override
	public int hashCode() {
		return Objects.hash(endereco, id, nome);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedores other = (Vendedores) obj;
		return Objects.equals(endereco, other.endereco) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}
	
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
}
