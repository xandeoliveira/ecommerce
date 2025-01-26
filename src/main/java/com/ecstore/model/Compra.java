package com.ecstore.model;

import java.sql.Timestamp;

public class Compra {
    private int id;
    private Timestamp dataHora;
    private int usuarioId;
    private int produtoId;
    private float valor;

    public Compra(int id, Timestamp dataHora, int usuarioId, int produtoId, float valor ) {
        this.id = id;
        this.dataHora = dataHora;
        this.usuarioId = usuarioId;
        this.produtoId = produtoId;
        this.valor = valor;
    }

    public Compra(Timestamp dataHora, int usuarioId) {
        this.dataHora = dataHora;
        this.usuarioId = usuarioId;
    }

    public Compra() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDataHora() {
		return dataHora;
	}

	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	public int getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(int ProdutoId) {
		this.produtoId = ProdutoId;
	}
	
	public float getValor() {
		return valor;
	}

	public void setValor(int ProdutoId) {
		this.valor = ProdutoId;
	}
}
