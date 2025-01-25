package com.ecstore.model;

public class Produto {
    private int id;
    private String categoria;
    private int quantidade;
    private float preco;
    private String descricao;
    private byte[] foto;

    public Produto(String categoria, int quantidade, float preco, String descricao, byte[] foto) {
    	this.categoria = categoria;
    	this.quantidade = quantidade;
    	this.preco = preco;
    	this.descricao = descricao;
    	this.foto = foto;
    }

    public Produto(int id, String categoria, int quantidade, float preco, String descricao, byte[] foto) {
        this.id = id;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.preco = preco;
        this.descricao = descricao;
        this.foto = foto;
    }
    
    public Produto() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
}
