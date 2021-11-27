package br.pro.delphino.drogaria.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.pro.delphino.drogaria.domain.Produto;

@SpringBootTest
public class ProdutoRepositoryTests {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Test
	public void inserir() {
		Produto p1 = new Produto(
				//Short.valueOf("1"),Já tem a tabela com autoincremento
				null,
				"Coca Cola",
				Short.valueOf("15"),
				BigDecimal.valueOf(10.50),
				LocalDate.of(2021, 11, 23),
				null //colocado null para não dar erro - categoria
				//Mas, agora não dá prá rodar JUnit
		);
		
		Produto p2 = new Produto(
				//Short.valueOf("1"),
				null,
				"Heineken",
				Short.valueOf("23"),
				BigDecimal.valueOf(10.50),
				LocalDate.of(2022, 4, 1),
				null
		);
		
		produtoRepository.save(p1);
		produtoRepository.save(p2);
	}
}
