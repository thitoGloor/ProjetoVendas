package com.vendas.venda.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.vendas.venda.modelo.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {	
	List<Vendedor> findByNome(String nomeVendedor);
	
	@Query(value = " SELECT VENDEDOR.NOME AS nome , VENDEDOR.ENDERECO AS endereco,\r\n"
			+ "COUNT(VENDA.VENDEDOR_ID) AS totalVendas, \r\n"
			+ "AVG(VALOR) AS mediaVendas, SUM(VALOR) AS somaVendas\r\n"
			+ "FROM VENDEDOR\r\n"
			+ "JOIN VENDA\r\n"
			+ "ON VENDA.VENDEDOR_ID = VENDEDOR.ID\r\n"
			+ "WHERE DATA_VENDA BETWEEN '2019-12-15' AND '2022-12-16' \r\n"
			+ "GROUP BY VENDA.VENDEDOR_ID", nativeQuery = true )
	 List<VendedorReturn> listaSelecao ();
}
