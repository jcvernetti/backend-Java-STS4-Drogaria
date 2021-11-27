package br.pro.delphino.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pro.delphino.drogaria.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
