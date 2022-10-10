package com.api.pedidos.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.pedidos.models.ProdutoModel;
import com.api.pedidos.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    
    @Transactional
    public ProdutoModel save(ProdutoModel produto) {
    	return produtoRepository.save(produto);
    }

	public Object findAll() {
		return produtoRepository.findAll();
	}
}
