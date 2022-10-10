package com.api.pedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pedidos.models.PedidoModel;

public interface PedidoRepository extends JpaRepository<PedidoModel, Integer> {

}
