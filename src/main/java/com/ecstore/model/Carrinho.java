package com.ecstore.model;

public class Carrinho {
	private int id;
    private int usuarioId;
    private int produtoId;
    private int quantidade;

    public Carrinho(int id, int usuarioId, int produtoId, int quantidade) {
    	this.id = id;
        this.usuarioId = usuarioId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }
    
    public Carrinho(int usuarioId, int produtoId, int quantidade) {
        this.usuarioId = usuarioId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public Carrinho() {}

	public int getId() {
		return usuarioId;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int compraId) {
		this.usuarioId = compraId;
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
	
	public float getSubtotal(float valorUnitario) {
		return this.quantidade * valorUnitario;
	}
}
