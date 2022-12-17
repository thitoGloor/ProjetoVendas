package com.vendas.venda.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.vendas.venda.modelo.Venda;

public interface VendaRepository extends JpaRepository<Venda, Integer>{

	@Query(value = "SELECT COUNT(*) AS QUANTIDADE_COLUNA FROM VENDA", nativeQuery = true )
	public Integer quantidadeVenda();
}
