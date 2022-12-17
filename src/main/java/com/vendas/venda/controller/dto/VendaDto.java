package com.vendas.venda.controller.dto;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import com.vendas.venda.modelo.Venda;

public class VendaDto {
	private Integer id;
	private LocalDate dataVenda;
	private double valor;
	private Integer idVendedor;
	private String nomeVendedor;	
	
	public VendaDto(Venda venda) {		
		this.id = venda.getId();
		this.dataVenda = venda.getDataVenda();
		this.valor = venda.getValor();
		this.idVendedor = venda.getVendedor().getId();
		this.nomeVendedor = venda.getVendedor().getNome();
	}

	public Integer getIdVendedor() {
		return idVendedor;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
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
		
		return vendas.stream().map(VendaDto::new).collect(Collectors.toList());
	}
}
