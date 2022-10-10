package com.api.pedidos.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_PEDIDO")
public class PedidoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codPedido;
	
	@Column(nullable = false)
	private Double valPedido;
	
	@ManyToMany
	private List<ProdutoModel> produtosPedido; 
	
	@OneToOne
	private ClienteModel cliente;

	public Integer getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(Integer codPedido) {
		this.codPedido = codPedido;
	}

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
