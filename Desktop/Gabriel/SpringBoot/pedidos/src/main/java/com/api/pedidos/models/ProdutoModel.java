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
@Table(name="TB_PRODUTO")
public class ProdutoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codProduto;
	

	@Column(nullable = false,length=70)
	private String nomProduto;
	
	@Column(nullable = false)
	private Double valProduto;
	
	@ManyToMany
	private List<PedidoModel> pedido;

	public Integer getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}

	

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
