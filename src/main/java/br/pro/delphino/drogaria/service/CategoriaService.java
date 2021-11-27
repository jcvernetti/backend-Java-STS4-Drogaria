package br.pro.delphino.drogaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pro.delphino.drogaria.domain.Categoria;
import br.pro.delphino.drogaria.exception.RecursoNaoEncontradoException;
import br.pro.delphino.drogaria.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscarPorCodigo(Short codigo) {
		Optional<Categoria> resultado = categoriaRepository.findById(codigo);
		
		if (resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		
		Categoria categoria = resultado.get();
		return categoria;
	}
	
	public List<Categoria> listar() {
		List<Categoria> resultado = categoriaRepository.findAll();
		return resultado;
 	}
}
