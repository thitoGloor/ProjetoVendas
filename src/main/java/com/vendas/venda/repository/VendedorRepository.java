package com.vendas.venda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vendas.venda.modelo.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
	

	List<Vendedor> findByNome(String nomeVendedor);
	
//@Query(value = "SELECT COUNT(*) AS QUANTIDADE_COLUNA FROM VENDA", nativeQuery = true );
	
	

}
