package com.ecstore.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ecstore.dao.CarrinhoDAO;
import com.ecstore.model.Carrinho;
import com.ecstore.model.Usuario;

@WebServlet("/carrinho")
public class CarrinhoController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CarrinhoDAO carrinhoDAO = new CarrinhoDAO();

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
    	Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
    	
    	if(usuario != null) {
	        int usuarioId = usuario.getId();
	        
	        List<Carrinho> itensCarrinho = null;
			try {
				itensCarrinho = this.carrinhoDAO.listByUsuarioId(usuarioId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(!itensCarrinho.isEmpty())
				request.setAttribute("itensCarrinho", itensCarrinho);
    	}
		
		request.getRequestDispatcher("carrinho.jsp").forward(request, response);
    }

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		int usuarioId = usuario.getId();

		try {
             int produtoId = Integer.parseInt(request.getParameter("produto_id"));
             int quantidade = Integer.parseInt(request.getParameter("quantidade"));

             Carrinho carrinho = new Carrinho(usuarioId, produtoId, quantidade);
             carrinhoDAO.create(carrinho);

         } catch (SQLException e) {
             e.printStackTrace();
         }
    	 
    	 response.sendRedirect("carrinho");
    }
	
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	HttpSession session = request.getSession();
    	Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        int usuarioId = usuario.getId();
        
        try {
            int produtoId = Integer.parseInt(request.getParameter("produto_id"));

            carrinhoDAO.deleteProductByUserId(usuarioId, produtoId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        response.sendRedirect("carrinho");
    }
}
