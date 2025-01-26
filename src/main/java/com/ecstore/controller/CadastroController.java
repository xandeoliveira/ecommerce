package com.ecstore.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.ecstore.dao.UsuarioDAO;
import com.ecstore.model.Usuario;

@WebServlet("/cadastro")
public class CadastroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
       
    public CadastroController() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadastro.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        // Cria um novo objeto Usuario
        Usuario usuario = new Usuario(email, nome, endereco, login, senha);
        try {
			usuarioDAO.create(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        response.sendRedirect("/ecommerce/login");
	}

}
