package com.api.pedidos.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.pedidos.models.PedidoModel;
import com.api.pedidos.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
    
    @Transactional
    public PedidoModel save(PedidoModel pedido) {
    	return pedidoRepository.save(pedido);
    }

	public Optional<PedidoModel> findById(Integer id) {
		return pedidoRepository.findById(id);
	}

	public List<PedidoModel> findPedidoByClienteId(Integer codCliente) {
		return pedidoRepository.findPedidoByClienteId(codCliente);
	}
}
