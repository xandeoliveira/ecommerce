package com.ecstore.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ecstore.dao.ProdutoDAO;
import com.ecstore.model.Produto;

@WebServlet(urlPatterns={"/","/home"})
public class ProdutoController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProdutoDAO produtoDAO = new ProdutoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	List<Produto> produtos = null;
		try {
			produtos = produtoDAO.listAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("produtos", produtos);
		request.getRequestDispatcher("/produtos.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String categoria = request.getParameter("categoria");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        float preco = Float.parseFloat(request.getParameter("preco"));
        String descricao = request.getParameter("descricao");
        
        Produto produto = new Produto(categoria, quantidade, preco, descricao, null);
        try {
			produtoDAO.create(produto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        response.sendRedirect("ProdutoController");
    }
}
