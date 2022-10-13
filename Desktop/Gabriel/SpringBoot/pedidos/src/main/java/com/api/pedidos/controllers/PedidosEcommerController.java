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
import com.api.pedidos.models.PedidoModel;
import com.api.pedidos.services.PedidoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pedido")
public class PedidosEcommerController {

final PedidoService pedidoService;
	
	public PedidosEcommerController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	
	@PostMapping
    public ResponseEntity<Object> saveProduto(@RequestBody @Valid PedidoDto pedidoDto){
		var PedidoModel = new PedidoModel();
        BeanUtils.copyProperties(pedidoDto, PedidoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(PedidoModel));
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Object> getOnePedido(@PathVariable(value="id") Integer id){
    	Optional<PedidoModel> pedidoModel = pedidoService.findById(id);
    	if(!pedidoModel.isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found");    		
    	}
    	return ResponseEntity.status(HttpStatus.OK).body(pedidoModel.get());
    }
	
	@GetMapping("/cliente/{id}")
	public ResponseEntity<Object> getPedidoByCliente(@PathVariable(value="id") Integer idCliente){	
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.findPedidoByClienteId(idCliente));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePedido(@PathVariable(value="id") Integer id ,@RequestBody @Valid PedidoDto pedidoDto){
		Optional<PedidoModel> pedidoModelOptional = pedidoService.findById(id);
    	if(!pedidoModelOptional.isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido:"+ id + " not found");    		
    	}
    	
		var PedidoModel = new PedidoModel();
        BeanUtils.copyProperties(pedidoDto, PedidoModel);
        PedidoModel.setCodPedido(id);
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.save(PedidoModel));	
     
	}
	
	
}
