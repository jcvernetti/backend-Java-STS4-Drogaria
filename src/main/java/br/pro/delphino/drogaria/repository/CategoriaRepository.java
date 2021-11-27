package br.pro.delphino.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pro.delphino.drogaria.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Short> {

}
