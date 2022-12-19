package com.vendas.venda.controller.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.vendas.venda.repository.VendedorReturn;

public class VendedorReturnDto {	
	private String nome;
	private String endereco;
	private Integer totalVendas;
	private double mediaVendas;	
	private double somaVendas;
	
	public VendedorReturnDto() {		
	}	
	
	public VendedorReturnDto (VendedorReturn vendedorReturn) {
		this.nome = vendedorReturn.getNome();
		this.endereco = vendedorReturn.getEndereco();
		this.totalVendas = vendedorReturn.getTotalVendas();
		this.mediaVendas = vendedorReturn.getMediaVendas();		
		this.somaVendas = vendedorReturn.getSomaVendas();
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public Integer getTotalVendas() {
		return totalVendas;
	}

	public double getMediaVendas() {
		return mediaVendas;
	}

	public double getSomaVendas() {
		return somaVendas;
	}
	
	//para cada vendedor return é criado um novo vendedorReturnDto
	public static List<VendedorReturnDto> converter(List<VendedorReturn> vendedores) {		
		return vendedores.stream().map(VendedorReturnDto::new).collect(Collectors.toList());
	}
}
