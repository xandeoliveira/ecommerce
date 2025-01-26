package com.ecstore.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ecstore.model.Carrinho;

public class CarrinhoDAO {
    private Connection connection;

    public CarrinhoDAO() {
        try {
			this.connection = DatabaseConnection.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void create(Carrinho carrinho) throws SQLException {
        String sql = "INSERT INTO Carrinho (usuario_id, produto_id, quantidade) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, carrinho.getUsuarioId());
            stmt.setInt(2, carrinho.getProdutoId());
            stmt.setInt(3, carrinho.getQuantidade());
            stmt.executeUpdate();
        }
    }

    public List<Carrinho> listByUsuarioId(int usuarioId) throws SQLException {
        String sql = "SELECT * FROM Carrinho WHERE usuario_id = ?";
        List<Carrinho> carrinhos = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                carrinhos.add(new Carrinho(
                        rs.getInt("usuario_id"),
                        rs.getInt("produto_id"),
                        rs.getInt("quantidade")
                ));
            }
        }
        return carrinhos;
    }

    public void deleteProductByUserId(int usuarioId, int produtoId) throws SQLException {
        String sql = "DELETE FROM Carrinho WHERE usuario_id = ? AND produto_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        	stmt.setInt(1, usuarioId);
            stmt.setInt(2, produtoId);
            stmt.executeUpdate();
        }
    }
}
