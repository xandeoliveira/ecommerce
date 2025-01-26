package com.ecstore.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.ecstore.dao.DatabaseConnection;
import com.ecstore.model.Compra;
import com.ecstore.model.Produto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gerarRelatorio")
public class RelatorioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int usuarioId = (int) request.getSession().getAttribute("usuarioId");

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = """
                SELECT 
                    c.id AS compra_id, 
                    c.data_hora, 
                    p.id AS produto_id, 
                    p.nome AS produto_nome, 
                    cp.quantidade, 
                    cp.valor_unitario
                FROM 
                    Compra c
                INNER JOIN 
                    Compra_Produto cp ON c.id = cp.compra_id
                INNER JOIN 
                    Produto p ON cp.produto_id = p.id
                WHERE 
                    c.usuario_id = ?
            """;

            List<Compra> compras = new ArrayList<>();

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, usuarioId);
                ResultSet rs = stmt.executeQuery();

                Compra compraAtual = null;
                while (rs.next()) {
                    int compraId = rs.getInt("compra_id");
                    if (compraAtual == null || compraAtual.getId() != compraId) {
                        if (compraAtual != null) {
                            compras.add(compraAtual);
                        }
                        compraAtual = new Compra();
                        compraAtual.setId(compraId);
                        compraAtual.setDataHora(rs.getTimestamp("data_hora"));
                       
                    }

                    Produto produto = new Produto();
                    produto.setId(rs.getInt("produto_id"));
                    produto.setQuantidade(rs.getInt("quantidade"));
                    produto.setPreco(rs.getFloat("valor_unitario"));

                }

                if (compraAtual != null) {
                    compras.add(compraAtual);
                }
            }

            String formato = request.getParameter("formato"); // "pdf", "html" ou "txt"
            if ("pdf".equalsIgnoreCase(formato)) {
                gerarRelatorioPDF(compras, response);
            } else if ("html".equalsIgnoreCase(formato)) {
                gerarRelatorioHTML(compras, response);
            } else if ("txt".equalsIgnoreCase(formato)) {
                gerarRelatorioTXT(compras, response);
            } else {
                response.getWriter().write("Formato inválido!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao buscar as compras.");
        }
    }

    private void gerarRelatorioPDF(List<Compra> compras, HttpServletResponse response) throws IOException {
        // Implementação do relatório em PDF
    }

    private void gerarRelatorioHTML(List<Compra> compras, HttpServletResponse response) throws IOException {
        // Implementação do relatório em HTML
    }

    private void gerarRelatorioTXT(List<Compra> compras, HttpServletResponse response) throws IOException {
        // Implementação do relatório em texto
    }
}
