package com.api.pedidos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.pedidos.models.PedidoModel;

public interface PedidoRepository extends JpaRepository<PedidoModel, Integer> {

	@Query(value = "SELECT * FROM TB_PEDIDO P INNER JOIN TB_CLIENTE C ON P.cliente_cod_cliente = C.cod_cliente WHERE P.cliente_cod_cliente = ? ",nativeQuery = true)
	List<PedidoModel> findPedidoByClienteId(Integer codCliente);

}
