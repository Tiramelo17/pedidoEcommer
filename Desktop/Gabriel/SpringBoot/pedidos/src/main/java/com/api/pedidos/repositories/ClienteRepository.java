package com.api.pedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pedidos.models.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {

}
