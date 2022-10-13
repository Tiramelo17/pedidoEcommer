package com.api.pedidos.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.pedidos.dtos.ClienteDto;
import com.api.pedidos.models.ClienteModel;
import com.api.pedidos.services.ClienteService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cliente")
public class ClienteEcommerceController {
	
final ClienteService clienteService;
	
	public ClienteEcommerceController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	
	@PostMapping
    public ResponseEntity<Object> saveProduto(@RequestBody @Valid ClienteDto clienteDto){
		var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
	}
	
	@GetMapping
	public ResponseEntity<Object> getAllClientes(){
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.findAll());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCliente(@PathVariable(value="id") Integer id ,@RequestBody @Valid ClienteDto clienteDto){
		Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
    	if(!clienteModelOptional.isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente:"+ id + " not found");    		
    	}
    	
    	var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        clienteModel.setCodCliente(id);
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(clienteModel));	
     
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCliente(@PathVariable(value="id") Integer id){
		Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
    	if(!clienteModelOptional.isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente:"+ id + " not found");    		
    	}
    	
		return ResponseEntity.status(HttpStatus.OK).body("Cliente: "+id+" deleted");	
	}
}
