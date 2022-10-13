package com.api.pedidos.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.pedidos.models.ClienteModel;
import com.api.pedidos.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    
    @Transactional
    public ClienteModel save(ClienteModel cliente) {
    	return clienteRepository.save(cliente);
    }

	public Object findAll() {
		return clienteRepository.findAll();
	}

	public Optional<ClienteModel> findById(Integer id) {
		return clienteRepository.findById(id);
	}
	
	public void deleteById(Integer id) {
		clienteRepository.deleteById(id); 
	}
}
