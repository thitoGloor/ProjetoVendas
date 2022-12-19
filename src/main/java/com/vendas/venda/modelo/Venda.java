package com.vendas.venda.modelo;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate dataVenda = LocalDate.now();
	private double valor;	
	@JoinColumn(name = "vendedor_id")
	@ManyToOne	
	private Vendedor vendedor;
		
	public Venda() {		
	}
	
	public Venda( double valor, Vendedor vendedor) {		
		this.valor = valor;
		this.vendedor = vendedor;
	}
	
	public Venda(double valor) {
		this.valor = valor;		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dataVenda, id, valor, vendedor);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		return Objects.equals(dataVenda, other.dataVenda) && Objects.equals(id, other.id)
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
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

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
}
