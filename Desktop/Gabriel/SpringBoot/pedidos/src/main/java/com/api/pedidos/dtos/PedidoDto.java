package com.api.pedidos.dtos;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.api.pedidos.models.ClienteModel;
import com.api.pedidos.models.ProdutoModel;

public class PedidoDto {
	
	
		@NotNull
		private Double valPedido;
		@NotNull
		private List<ProdutoModel> produtosPedido;     
		@NotNull
		private ClienteModel cliente;
		
		
		public Double getValPedido() {
			return valPedido;
		}
		public void setValPedido(Double valPedido) {
			this.valPedido = valPedido;
		}
		public List<ProdutoModel> getProdutosPedido() {
			return produtosPedido;
		}
		public void setProdutosPedido(List<ProdutoModel> produtosPedido) {
			this.produtosPedido = produtosPedido;
		}
		public ClienteModel getCliente() {
			return cliente;
		}
		public void setCliente(ClienteModel cliente) {
			this.cliente = cliente;
		} 
	   
	    
}
