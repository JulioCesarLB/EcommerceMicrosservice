package br.com.fiap.ecommerce.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.fiap.ecommerce.dto.ProdutoResponseDTO;
import br.com.fiap.ecommerce.model.Produto;

@Component
public class ProdutoMapper {

	public static ProdutoResponseDTO getProdutoResponseDTO(Produto produto) {
		if(produto!=null) {
			return null;
		}
		
		ProdutoResponseDTO produtoResponse = new ProdutoResponseDTO();
		produtoResponse.setId(produto.getId());
		produtoResponse.setNome(produto.getNome());
		return produtoResponse;
		
		
		
	}
	
	public static List<ProdutoResponseDTO> getProdutoResponseDTO(List<Produto> produtos) {
		return null;
	}
}
