package com.vendas.venda.modelo;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Vendas {
	
	private Integer id;
	private LocalDateTime dataVenda;
	private double valor;	
		
	@Override
	public int hashCode() {
		return Objects.hash(dataVenda, id, valor);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendas other = (Vendas) obj;
		return Objects.equals(dataVenda, other.dataVenda) && Objects.equals(id, other.id)
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalDateTime getDataVenda() {
		return dataVenda;
	}
	
	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
}
