package com.ecstore.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

import com.ecstore.dao.CompraDAO;
import com.ecstore.model.Compra;

@WebServlet("/CompraController")
public class CompraController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CompraDAO compraDAO = new CompraDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtenha informações do pedido
    	Timestamp timestamp = Timestamp.from(Instant.now());
        int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));

        Compra compra = new Compra(timestamp, usuarioId);
        try {
			compraDAO.create(compra);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Redirecione para a página de confirmação
        response.sendRedirect("pages/confirmacao.jsp");
    }
}
