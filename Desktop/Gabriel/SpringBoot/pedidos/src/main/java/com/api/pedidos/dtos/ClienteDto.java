package com.api.pedidos.dtos;

import javax.validation.constraints.NotBlank;

public class ClienteDto {
	

 	@NotBlank
	private String nomcliente;

 	@NotBlank
	private String cpfcliente;

 	@NotBlank
	private String numTelefonecliente;


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
