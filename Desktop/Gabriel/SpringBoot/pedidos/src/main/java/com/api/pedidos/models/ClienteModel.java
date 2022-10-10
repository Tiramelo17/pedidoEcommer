package com.api.pedidos.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_CLIENTE")
public class ClienteModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codCliente;
	

	@Column(nullable = false,length=130)
	private String nomcliente;
	
	@Column(nullable = false,length=11)
	private String cpfcliente;
	
	@Column(nullable = false,length=11)
	private String numTelefonecliente;
	
	@ManyToMany
	private List<PedidoModel> pedidoCliente;

	

	public Integer getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public String getNomcliente() {
		return nomcliente;
	}

	public void setNomcliente(String nomcliente) {
		this.nomcliente = nomcliente;
	}

	public String getCpfcliente() {
		return cpfcliente;
	}

	public void setCpfcliente(String cpfcliente) {
		this.cpfcliente = cpfcliente;
	}

	public String getNumTelefonecliente() {
		return numTelefonecliente;
	}

	public void setNumTelefonecliente(String numTelefonecliente) {
		this.numTelefonecliente = numTelefonecliente;
	}

	
	
	
}
