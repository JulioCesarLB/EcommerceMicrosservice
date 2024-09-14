package br.com.fiap.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ecommerce.model.Produto;
import br.com.fiap.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> list(){
		return produtoRepository.findAll();
	}
	
	public Produto save(Produto  dto) {
		// TODO Auto-generated method stub
		return produtoRepository.save(dto);
	}

	public boolean existById(Long id) {
		// TODO Auto-generated method stub
		return produtoRepository.existsById(id);
		
	}

	public boolean deleteById(Long id) {
		 produtoRepository.deleteById(id);
		 return !produtoRepository.existsById(id);
	}

	public Optional<Produto> getById(Long id) {
		// TODO Auto-generated method stub
		return produtoRepository.findById(id);
	}
	
	
}
