package com.api.pedidos.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProdutoDto {


	
 	@NotBlank
 	private String nomProduto;

 	@NotNull
	private Double valProduto;

	

	

	public String getNomProduto() {
		return nomProduto;
	}

	public void setNomProduto(String nomProduto) {
		this.nomProduto = nomProduto;
	}

	public Double getValProduto() {
		return valProduto;
	}

	public void setValProduto(Double valProduto) {
		this.valProduto = valProduto;
	}
 	
 	
}
