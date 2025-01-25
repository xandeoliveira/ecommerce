package com.ecstore.model;

import java.sql.Timestamp;

public class Compra {
    private int id;
    private Timestamp dataHora;
    private int usuarioId;

    public Compra(int id, Timestamp dataHora, int usuarioId) {
        this.id = id;
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
}
