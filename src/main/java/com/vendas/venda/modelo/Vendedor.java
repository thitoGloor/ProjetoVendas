package com.vendas.venda.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vendedor")
public class Vendedor {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String endereco;
	@OneToMany(mappedBy = "vendedor")
	private List<Venda> vendas = new ArrayList<>();	
		
	public Vendedor() {
		
	}
	
	public Vendedor(String nome, String endereco, List<Venda> vendas) {
		this.nome = nome;
		this.endereco = endereco;
		this.vendas = vendas;
	}
	
	public Vendedor(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;		
	}
	
	public Vendedor(String nome) {
		this.nome = nome;		
	}	
		
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
		Vendedor other = (Vendedor) obj;
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

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
}
