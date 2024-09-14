package br.com.fiap.ecommerce.controller;

import static br.com.fiap.ecommerce.mapper.ProdutoMapper.getProdutoResponseDTO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ecommerce.dto.ProdutoRequestDTO;
import br.com.fiap.ecommerce.dto.ProdutoResponseDTO;
import br.com.fiap.ecommerce.model.Produto;
import br.com.fiap.ecommerce.service.ProdutoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public List<ProdutoResponseDTO> list() {
		
		return getProdutoResponseDTO(produtoService.list());
	}
	
	@GetMapping("{id}")
	public ProdutoResponseDTO getById(@PathVariable Long id) {
		
		Optional<Produto> produto =  produtoService.getById(id);
		
		return getProdutoResponseDTO(produto.isPresent()?produto.get():null);
	}
	
	@PostMapping
	public ProdutoResponseDTO create(ProdutoResponseDTO dto) {
		Produto produto = new Produto();
		produto.setNome(dto.getNome());
		return getProdutoResponseDTO(produtoService.save(produto));
	}
	
	@PutMapping("{id}")
	public ProdutoResponseDTO update(@PathVariable Long id, @RequestBody ProdutoRequestDTO dto) {
		
		if(!produtoService.existById(id)) {
			new RuntimeException("Não existe produto com esse ID");
		}
		return null;
	}
	
	@DeleteMapping("{id}")
	public String  delete(@PathVariable Long id) {
		if(!produtoService.existById(id)) {
			new RuntimeException("Não existe produto com esse ID");
		}
		if(produtoService.deleteById(id)) {
			return "Deletado";
		}	
		return "Não foi deletado";
	
	}
}