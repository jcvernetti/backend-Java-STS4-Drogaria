package br.pro.delphino.drogaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.pro.delphino.drogaria.domain.Categoria;
import br.pro.delphino.drogaria.exception.RecursoNaoEncontradoException;
import br.pro.delphino.drogaria.service.CategoriaService;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;

	// Boa prática: Para listar usa-se root
	@GetMapping
	public List<Categoria> listar() {
		//List<Categoria> categorias = categoriaRepository.findAll();
		List<Categoria> categorias = categoriaService.listar();
		return categorias;
	}

	@GetMapping("/{codigo}")
	public Categoria buscarPorCodigo(@PathVariable Short codigo) {
//		Optional<Categoria> resultado = categoriaRepository.findById(codigo);
//		Categoria categoria = resultado.get();
		try {
			Categoria categoria = categoriaService.buscarPorCodigo(codigo);
			return categoria;
		} catch (RecursoNaoEncontradoException excecao) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada", excecao);
		}
	}

//	@PostMapping
//	public Categoria inserir(@RequestBody Categoria categoria) {
//		Categoria categoriaSalva = categoriaRepository.save(categoria);
//		return categoriaSalva;
//	}

//	@DeleteMapping("/{codigo}")
//	public Optional<Categoria> excluir (@PathVariable Short codigo) {
//		Optional<Categoria> categoria = categoriaRepository.findById(codigo);
//		categoriaRepository.delete(categoria.get());
//		return categoria;
//	}

//	@PutMapping
//	public Categoria editar(@RequestBody Categoria categoria) {
//		Categoria categoriaEditada = categoriaRepository.save(categoria);
//		return categoriaEditada;
//	}
}
