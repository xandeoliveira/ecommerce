package com.ecstore.model;

public class Carrinho {
    private int compraId;
    private int produtoId;
    private int quantidade;

    public Carrinho(int compraId, int produtoId, int quantidade) {
        this.compraId = compraId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public Carrinho() {}

	public int getCompraId() {
		return compraId;
	}

	public void setCompraId(int compraId) {
		this.compraId = compraId;
	}

	public int getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(int produtoId) {
		this.produtoId = produtoId;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
