package com.ecstore.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ecstore.model.Compra;

public class CompraDAO {
    private Connection connection;

    public CompraDAO() {
        try {
			this.connection = DatabaseConnection.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void create(Compra compra) throws SQLException {
        String sql = "INSERT INTO Compra (data_hora, usuario_id, produto_id, valor) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setTimestamp(1, compra.getDataHora());
            stmt.setInt(2, compra.getUsuarioId());
            stmt.setInt(3, compra.getProdutoId());
            stmt.setFloat(4, compra.getValor());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                compra.setId(generatedKeys.getInt(1));
            }
        }
    }

    public Compra read(int id_usuario) throws SQLException {
        String sql = "SELECT * FROM Compra WHERE id_usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id_usuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Compra(
                        rs.getInt("id"),
                        rs.getTimestamp("data_hora"),
                        rs.getInt("usuario_id"),
                        rs.getInt("produto_id"),
                        rs.getInt("valor")
                );
            }
        }
        return null;
    }

    public List<Compra> listAll() throws SQLException {
        String sql = "SELECT * FROM Compra";
        List<Compra> compras = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                compras.add(new Compra(
                        rs.getInt("id"),
                        rs.getTimestamp("data_hora"),
                        rs.getInt("usuario_id"),
                        rs.getInt("produto_id"),
                        rs.getInt("valor")
                ));
            }
        }
        return compras;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Compra WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
