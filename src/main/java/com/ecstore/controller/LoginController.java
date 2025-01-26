package com.ecstore.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.ecstore.dao.UsuarioDAO;
import com.ecstore.model.Usuario;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
	    String login = request.getParameter("login");
	    String senha = request.getParameter("senha");
	
	    // Busca o usuário pelo login
	    Usuario usuario = null;
		try {
			usuario = usuarioDAO.listAll()
			    .stream()
			    .filter(u -> u.getLogin().equals(login))
			    .findFirst()
			    .orElse(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	    // Verifica se o usuário foi encontrado e se a senha é válida
	    if (usuario != null && usuario.getSenha().equals(senha)) {
	        // Armazena o usuário na sessão
	        HttpSession session = request.getSession();
	        session.setAttribute("usuarioLogado", usuario);
	
	        // Redireciona para a página inicial
	        response.sendRedirect("home");
	    } else {
	        // Redireciona para a página de login com erro
	        response.sendRedirect("login");
	    }
    }
}
