package com.ecstore.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ecstore.dao.CarrinhoDAO;
import com.ecstore.model.Carrinho;

@WebServlet("/CarrinhoController")
public class CarrinhoController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CarrinhoDAO carrinhoDAO = new CarrinhoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int compraId = Integer.parseInt(request.getParameter("compra"));        
        List<Carrinho> itensCarrinho;
        
		try {
			itensCarrinho = this.carrinhoDAO.listByCompraId(compraId);
			request.setAttribute("itensCarrinho", itensCarrinho);
			request.getRequestDispatcher("carrinho.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int compraId = Integer.parseInt(request.getParameter("compra"));
        int produtoId = Integer.parseInt(request.getParameter("produto"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));

        Carrinho carrinho = new Carrinho(compraId, produtoId, quantidade); // Adiciona quantidade inicial 1

        String action = request.getParameter("action");
		if ("adicionar".equals(action)) {    
            try {
				this.carrinhoDAO.create(carrinho);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        } else if ("remover".equals(action)) {
            try {
				this.carrinhoDAO.deleteByCompraId(compraId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        response.sendRedirect("carrinho.jsp");
    }
}
