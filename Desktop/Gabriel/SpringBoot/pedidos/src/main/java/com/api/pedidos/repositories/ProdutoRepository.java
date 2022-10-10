package com.api.pedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pedidos.models.ProdutoModel;


public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer> {

}
