package com.api.pedidos.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.pedidos.dtos.PedidoDto;
import com.api.pedidos.dtos.ProdutoDto;
import com.api.pedidos.models.PedidoModel;
import com.api.pedidos.models.ProdutoModel;
import com.api.pedidos.services.ProdutoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/produto")
public class ProdutosControler {
	
	final ProdutoService produtoService;
	
	public ProdutosControler(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	
	@PostMapping
    public ResponseEntity<Object> saveProduto(@RequestBody @Valid ProdutoDto produtoDto){
		var produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(produtoDto, produtoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produtoModel));
	}
	
	@GetMapping
	public ResponseEntity<Object> getAllProdutos(){

		return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.findAll());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProduto(@PathVariable(value="id") Integer id ,@RequestBody @Valid ProdutoDto produtoDto){
		Optional<ProdutoModel> ProdtuoModelOptional = produtoService.findById(id);
    	if(!ProdtuoModelOptional.isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto:"+ id + " not found");    		
    	}
    	
    	var produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(produtoDto, produtoModel);
        produtoModel.setCodProduto(id);
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(produtoModel));	
     
	}
	
}
